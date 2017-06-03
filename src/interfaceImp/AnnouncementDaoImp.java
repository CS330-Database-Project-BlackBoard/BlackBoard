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
	
	private ArrayList<Announcement> getAnnouncements(String query) {
		Announcement announcement;
		ArrayList<Announcement> announcements = new ArrayList<>();	
		Connection connection = null;
		
		try {
			connection = super.getConnection();
			 PreparedStatement sqlStatement = connection.prepareStatement(query);

			 ResultSet resultSet = sqlStatement.executeQuery();
			 
			 while(resultSet.next()) {
				 int AnnouncementID = resultSet.getInt("AnnouncementID");
				 int postedBy = resultSet.getInt("PostedBY");
				 String title = resultSet.getString("Title");
				 String content = resultSet.getString("Content");
				 String postedAt = resultSet.getString("PostedAT");
				 
				 
				 
				announcement = new Announcement(AnnouncementID, postedBy, title, content, postedAt);
				announcements.add(announcement);	 
				 
			 }
			 
			
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		finally {
			if (connection != null ) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
	

		return announcements;
	
	}
	
	

	@Override
	public ArrayList<Announcement> getAllAnnouncements() {
		String query = "SELECT * FROM Announcement";
		return this.getAnnouncements(query);
	}

	@Override
	public ArrayList<Announcement> getAnnouncementsByLecture(int lectureID) {
	
		String query = "SELECT * FROM Announcement WHERE PostedTO = " + lectureID;
		return this.getAnnouncements(query);
	}

	@Override
	public Announcement getAnnouncementByID(int AnnouncementID) {
		
		String query = "SELECT * FROM Announcement WHERE AnnouncementID = " + AnnouncementID;
		return this.getAnnouncements(query).get(0);
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
			PreparedStatement sqlStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			sqlStatement.setInt(1, sentBy);
			sqlStatement.setString(2, title);
			sqlStatement.setString(3, content);
			sqlStatement.setString(4, TimeZone.getDateTime());
			
			sqlStatement.executeUpdate();
			
			try (ResultSet resultSet = sqlStatement.getGeneratedKeys()){
				if (resultSet.next()) {
					int AnnouncementID = resultSet.getInt(1);
					
					query = "";
					
					
					if (toWho.equals(AppForm.ONLY_MANAGERS)) {
						query = "INSERT INTO AnnouncementOwner(AnnouncementID, SchoolID) SELECT " + AnnouncementID + ", SchoolID FROM User WHERE Role = 1 OR Role = 2";
						
					}
					else if(toWho.equals(AppForm.ONLY_LECTURERS)) {
						query = "INSERT INTO AnnouncementOwner(AnnouncementID, SchoolID) SELECT " + AnnouncementID + ", SchoolID FROM User WHERE Role = 3 OR Role = 4";
						
						
					}
					else if(toWho.equals(AppForm.ALL_USERS)){
						query = "INSERT INTO AnnouncementOwner(AnnouncementID, SchoolID) SELECT " + AnnouncementID + ", SchoolID FROM User";
						
					}
					
					sqlStatement = connection.prepareStatement(query);
					sqlStatement.executeLargeUpdate();
					
					
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

}
