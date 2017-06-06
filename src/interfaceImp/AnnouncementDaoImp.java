package interfaceImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.api.jdbc.Statement;

import database.Database;
import enums.AppForm;
import helper.TimeZone;
import interfaces.AnnouncementDao;
import pojos.Announcement;
import pojos.Lecturer;
import pojos.Manager;
import pojos.Student;

public class AnnouncementDaoImp extends Database implements AnnouncementDao {
	
	
	// main function, will return given sql
	private ArrayList<Announcement> getAnnouncements(String query) {
		Announcement announcement;
		ArrayList<Announcement> announcements = new ArrayList<>();	 // keeps anouncements
		Connection connection = null;
		
		try {
			connection = super.getConnection();
			 PreparedStatement sqlStatement = connection.prepareStatement(query); // prepare statement

			 ResultSet resultSet = sqlStatement.executeQuery(); // execute
			 
			 while(resultSet.next()) { // iterate resultset
				 int AnnouncementID = resultSet.getInt("AnnouncementID"); // get fields by column name
				 int postedBy = resultSet.getInt("PostedBY");
				 String title = resultSet.getString("Title");
				 String content = resultSet.getString("Content");
				 String postedAt = resultSet.getString("PostedAT");
				 
				 
				 
				announcement = new Announcement(AnnouncementID, postedBy, title, content, postedAt); // put in new object
				announcements.add(announcement); // add object to arraylist
				 
			 }
			 
			
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		finally {
			if (connection != null ) {
				try {
					connection.close(); // close connection
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
	

		return announcements; // return objects as arraylist
	
	}
	
	
	// send sql to getAnnouncement function
	@Override
	public ArrayList<Announcement> getAllAnnouncements() {
		String query = "SELECT * FROM Announcement";
		return this.getAnnouncements(query);
	}

	@Override
	public ArrayList<Announcement> getAnnouncementsByLecture(int lectureID) {
	
		String query = "SELECT * FROM Announcement WHERE AnnouncementID IN (SELECT AnnouncementID FROM CourseAnnouncement WHERE LectureID =" + lectureID + ")";
		return this.getAnnouncements(query);
	}


	@Override
	public ArrayList<Announcement> getAnnouncementsBySchoolID(int schoolID) {
		
		String query = "SELECT * FROM Announcement WHERE AnnouncementID IN (SELECT AnnouncementID FROM AnnouncementOwner WHERE SchoolID = " + schoolID + ");"; 
		return this.getAnnouncements(query);
	}

	@Override
	public ArrayList<Announcement> getAnnouncementsByRole(int level) {
		
		String query = "SELECT * FROM Announcement WHERE PostedBY IN (SELECT SchoolID FROM User WHERE Role <= " + level + ")";
		return this.getAnnouncements(query);
	}

	@Override
	public boolean sendAnnouncement(String title, String content, String toWho, int sentBy) {
		
		Connection connection = null;
		
		String query = "INSERT INTO Announcement(PostedBy, Title, Content, PostedAT) VALUES (?, ?, ?, ?)";
		
		try {
			connection = super.getConnection();
			PreparedStatement sqlStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS); // RETURN GENERATED KEYS WILL HELP TO GET LAST GENERATED INDEX
			sqlStatement.setInt(1, sentBy);
			sqlStatement.setString(2, title);
			sqlStatement.setString(3, content);
			sqlStatement.setString(4, TimeZone.getDateTime());
			
			sqlStatement.executeUpdate(); // insert anouncement
			
			try (ResultSet resultSet = sqlStatement.getGeneratedKeys()){ // if no error when getting generated key
				if (resultSet.next()) {
					int AnnouncementID = resultSet.getInt(1); // get key
					
					query = "";
					
					
					if (toWho.equals(AppForm.ONLY_MANAGERS)) { // according to form data execute one of sql query
						
						query = "INSERT INTO AnnouncementOwner(AnnouncementID, SchoolID) SELECT " + AnnouncementID + ", SchoolID FROM User WHERE Role = 1 OR Role = 2";
						
					}
					else if(toWho.equals(AppForm.ONLY_LECTURERS)) {
						query = "INSERT INTO AnnouncementOwner(AnnouncementID, SchoolID) SELECT " + AnnouncementID + ", SchoolID FROM User WHERE Role = 3 OR Role = 4";
						
						
					}
					else if(toWho.equals(AppForm.ALL_USERS)){
						query = "INSERT INTO AnnouncementOwner(AnnouncementID, SchoolID) SELECT " + AnnouncementID + ", SchoolID FROM User";
						
					}
					
					sqlStatement = connection.prepareStatement(query);
					sqlStatement.executeLargeUpdate(); // insert
					
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}	
		catch(Exception e){
			e.printStackTrace();
			
		}
		finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public Announcement getAnnouncementByID(int announcementID) {
		
		String query = "SELECT * FROM Announcement WHERE AnnouncementID = " + announcementID;
		return this.getAnnouncements(query).get(0); // function will return single anouncment so get first element
		
	}


	@Override
	public Announcement getMaterialAnnouncementByID(int announcementID) {
		String query = "SELECT * FROM MaterialAnnouncement WHERE AnnouncementID = " + announcementID;
		return this.getAnnouncements(query).get(0); // function will return single anouncment so get first element
	}

	
	
	
}
