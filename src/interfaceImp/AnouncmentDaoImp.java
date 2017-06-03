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
import interfaces.AnouncmentDao;
import pojos.Anouncment;
import pojos.Lecturer;
import pojos.Manager;
import pojos.Student;

public class AnouncmentDaoImp extends Database implements AnouncmentDao {
	
	private ArrayList<Anouncment> getAnouncments(String query) {
		Anouncment anouncment;
		ArrayList<Anouncment> anouncments = new ArrayList<>();	
		Connection connection = null;
		
		try {
			connection = super.getConnection();
			 PreparedStatement sqlStatement = connection.prepareStatement(query);

			 ResultSet resultSet = sqlStatement.executeQuery();
			 
			 while(resultSet.next()) {
				 int anouncmentID = resultSet.getInt("AnouncmentID");
				 int postedBy = resultSet.getInt("PostedBY");
				 String title = resultSet.getString("Title");
				 String content = resultSet.getString("Content");
				 String postedAt = resultSet.getString("PostedAT");
				 
				 
				 
				anouncment = new Anouncment(anouncmentID, postedBy, title, content, postedAt);
				anouncments.add(anouncment);	 
				 
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
	

		return anouncments;
	
	}
	
	

	@Override
	public ArrayList<Anouncment> getAllAnouncments() {
		String query = "SELECT * FROM Anouncment";
		return this.getAnouncments(query);
	}

	@Override
	public ArrayList<Anouncment> getAnouncmentsByLecture(int lectureID) {
	
		String query = "SELECT * FROM Anouncment WHERE PostedTO = " + lectureID;
		return this.getAnouncments(query);
	}

	@Override
	public Anouncment getAnouncmentByID(int anouncmentID) {
		
		String query = "SELECT * FROM Anouncment WHERE AnouncmentID = " + anouncmentID;
		return this.getAnouncments(query).get(0);
	}

	@Override
	public ArrayList<Anouncment> getAnouncmentsBySchoolID(int schoolID) {
		
		String query = "SELECT * FROM Anouncment WHERE AnouncmentID IN (SELECT AnouncmentID FROM AnouncmentOwner WHERE SchoolID = " + schoolID + ");"; 
		return this.getAnouncments(query);
	}

	@Override
	public ArrayList<Anouncment> getAnouncmentsByRole(int level) {
		
		String query = "SELECT * FROM Anouncment WHERE PostedBY IN (SELECT SchoolID FROM User WHERE Role <= " + level + ")";
		return this.getAnouncments(query);
	}

	@Override
	public boolean sendAnouncment(String title, String content, String toWho, int sentBy) {
		
		Connection connection = null;
		
		String query = "INSERT INTO Anouncment(PostedBy, Title, Content, PostedAT) VALUES (?, ?, ?, ?)";
		
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
					int anouncmentID = resultSet.getInt(1);
					
					query = "";
					
					
					if (toWho.equals(AppForm.ONLY_MANAGERS)) {
						query = "INSERT INTO AnouncmentOwner(AnouncmentID, SchoolID) SELECT " + anouncmentID + ", SchoolID FROM User WHERE Role = 1 OR Role = 2";
						
					}
					else if(toWho.equals(AppForm.ONLY_LECTURERS)) {
						query = "INSERT INTO AnouncmentOwner(AnouncmentID, SchoolID) SELECT " + anouncmentID + ", SchoolID FROM User WHERE Role = 3 OR Role = 4";
						
						
					}
					else if(toWho.equals(AppForm.ALL_USERS)){
						query = "INSERT INTO AnouncmentOwner(AnouncmentID, SchoolID) SELECT " + anouncmentID + ", SchoolID FROM User";
						
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
