package interfaceImp;

import java.security.KeyStore.ProtectionParameter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Database;
import interfaces.AnouncmentDao;
import pojos.Anouncment;

public class AnouncmentDaoImp extends Database implements AnouncmentDao {

	@Override
	public ArrayList<Anouncment> getAllAnouncment() {
		Anouncment anouncment;
		ArrayList<Anouncment> anouncments = new ArrayList<>();	
		Connection connection = null;
		String query = "SELECT * FROM Anouncment";
		
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
				 String filePath = resultSet.getString("Path");
				 String fileName = resultSet.getString("Name");
				 String fileType = resultSet.getString("Type");
				 int postedTo = resultSet.getInt("PostedTO");
				 
				 
				 
				 if (filePath == null) {
					 anouncment = new Anouncment(anouncmentID, postedBy, title, content, postedAt, postedTo);
					
				 }
				 else {
					anouncment= new Anouncment(anouncmentID, postedBy, title, content, postedAt, filePath, fileName, fileType, postedTo);
				 }
				 
				 if(!anouncments.contains(anouncment)) { // eger aynisi anouncments icinde yosksa ekle
					 anouncments.add(anouncment);
				 }
				 
				 
			 }
			 
			
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		finally {
			if (connection != null ) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	

		return anouncments;
	}

	@Override
	public ArrayList<Anouncment> getAnouncmentsByLecture(int lectureID) {
		Anouncment anouncment;
		ArrayList<Anouncment> anouncments = new ArrayList<>();	
		Connection connection = null;
		String query = "SELECT * FROM Anouncment WHERE WHERE PostedTO = ?)";
		
		try {
			connection = super.getConnection();
			 PreparedStatement sqlStatement = connection.prepareStatement(query);
	
			 sqlStatement.setInt(1, lectureID);
			 ResultSet resultSet = sqlStatement.executeQuery();
			 
			 while(resultSet.next()) {
				 int anouncmentID = resultSet.getInt("AnouncmentID");
				 int postedBy = resultSet.getInt("PostedBY");
				 String title = resultSet.getString("Title");
				 String content = resultSet.getString("Content");
				 String postedAt = resultSet.getString("PostedAT");
				 String filePath = resultSet.getString("Path");
				 String fileName = resultSet.getString("Name");
				 String fileType = resultSet.getString("Type");
				 int postedTo = resultSet.getInt("PostedTO");
				 
				 
				 
				 if (filePath == null) {
					 anouncment = new Anouncment(anouncmentID, postedBy, title, content, postedAt, postedTo);
					
				 }
				 else {
					anouncment= new Anouncment(anouncmentID, postedBy, title, content, postedAt, filePath, fileName, fileType, postedTo);
				 }
				 
				 if(!anouncments.contains(anouncment)) { // eger aynisi anouncments icinde yosksa ekle
					 anouncments.add(anouncment);
				 }
				 
				 
			 }
			 
			
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		finally {
			if (connection != null ) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	

		return anouncments;
	}

	@Override
	public Anouncment getAnouncmentByID(int AnouncmentID) {
		Anouncment anouncment = null;
		Connection connection = null;
		String query = "SELECT * FROM Anouncment WHERE AnouncmentID = ?";
		
		try {
			connection = super.getConnection();
			 PreparedStatement sqlStatement = connection.prepareStatement(query);
	
			 sqlStatement.setInt(1, AnouncmentID);
			 ResultSet resultSet = sqlStatement.executeQuery();
			 
			 if(resultSet.next()) {
				 int anouncmentID = resultSet.getInt("AnouncmentID");
				 int postedBy = resultSet.getInt("PostedBY");
				 String title = resultSet.getString("Title");
				 String content = resultSet.getString("Content");
				 String postedAt = resultSet.getString("PostedAT");
				 String filePath = resultSet.getString("Path");
				 String fileName = resultSet.getString("Name");
				 String fileType = resultSet.getString("Type");
				 int postedTo = resultSet.getInt("PostedTO");
				 
				 
				 
				 if (filePath == null) {
					 anouncment = new Anouncment(anouncmentID, postedBy, title, content, postedAt, postedTo);
					
				 }
				 else {
					anouncment= new Anouncment(anouncmentID, postedBy, title, content, postedAt, filePath, fileName, fileType, postedTo);
				 }
	 
				 
			 }
			 
			
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		finally {
			if (connection != null ) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	

		return anouncment;
	}

	@Override
	public ArrayList<Anouncment> getAnouncmentsBySchoolID(int schoolID) {
		Anouncment anouncment;
		ArrayList<Anouncment> anouncments = new ArrayList<>();	
		Connection connection = null;
		String query = "SELECT * FROM Anouncment WHERE SchoolID = ?";
		
		try {
			connection = super.getConnection();
			 PreparedStatement sqlStatement = connection.prepareStatement(query);
			
			 sqlStatement.setInt(1, schoolID);
			 ResultSet resultSet = sqlStatement.executeQuery();
			 
			 while(resultSet.next()) {
				 int anouncmentID = resultSet.getInt("AnouncmentID");
				 int postedBy = resultSet.getInt("PostedBY");
				 String title = resultSet.getString("Title");
				 String content = resultSet.getString("Content");
				 String postedAt = resultSet.getString("PostedAT");
				 String filePath = resultSet.getString("Path");
				 String fileName = resultSet.getString("Name");
				 String fileType = resultSet.getString("Type");
				 int postedTo = resultSet.getInt("PostedTO");
				 
				 
				 
				 if (filePath == null) {
					 anouncment = new Anouncment(anouncmentID, postedBy, title, content, postedAt, postedTo);
					
				 }
				 else {
					anouncment= new Anouncment(anouncmentID, postedBy, title, content, postedAt, filePath, fileName, fileType, postedTo);
				 }
				 
				 if(!anouncments.contains(anouncment)) { // eger aynisi anouncments icinde yosksa ekle
					 anouncments.add(anouncment);
				 }
				 
				 
			 }
			 
			
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		finally {
			if (connection != null ) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	

		return anouncments;
	}

	@Override
	public ArrayList<Anouncment> getAnouncmentsByRole(int level) {
		Anouncment anouncment;
		ArrayList<Anouncment> anouncments = new ArrayList<>();	
		Connection connection = null;
		String query = "SELECT * FROM Anouncment WHERE PostedBY IN (SELECT SchoolID FROM User WHERE Role <= ?)";
		
		try {
			connection = super.getConnection();
			 PreparedStatement sqlStatement = connection.prepareStatement(query);
			 if(level < 2)
				 level = 2; // eger SA ise Admin duyurularini da cekmek icin leveli 2 yap
			 
			 sqlStatement.setInt(1, level);
			 ResultSet resultSet = sqlStatement.executeQuery();
			 
			 while(resultSet.next()) {
				 int anouncmentID = resultSet.getInt("AnouncmentID");
				 int postedBy = resultSet.getInt("PostedBY");
				 String title = resultSet.getString("Title");
				 String content = resultSet.getString("Content");
				 String postedAt = resultSet.getString("PostedAT");
				 String filePath = resultSet.getString("Path");
				 String fileName = resultSet.getString("Name");
				 String fileType = resultSet.getString("Type");
				 int postedTo = resultSet.getInt("PostedTO");
				 
				 
				 
				 if (filePath == null) {
					 anouncment = new Anouncment(anouncmentID, postedBy, title, content, postedAt, postedTo);
					
				 }
				 else {
					anouncment= new Anouncment(anouncmentID, postedBy, title, content, postedAt, filePath, fileName, fileType, postedTo);
				 }
				 
				 if(!anouncments.contains(anouncment)) { // eger aynisi anouncments icinde yosksa ekle
					 anouncments.add(anouncment);
				 }
				 
				 
			 }
			 
			
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		finally {
			if (connection != null ) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	

		return anouncments;
	}

	

	
	
	
	

}
