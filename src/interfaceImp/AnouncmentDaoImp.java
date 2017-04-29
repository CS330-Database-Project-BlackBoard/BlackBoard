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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Anouncment> getAnouncmentsByLecture(int lectureID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Anouncment getAnouncmentByID(int AnouncmentID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Anouncment> getAnouncmentsBySchoolID(int schoolID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Anouncment> getAnouncmentsByRole(int level) {
		ArrayList<Anouncment> anouncments = new ArrayList<>();
		ArrayList<Anouncment> anouncmentsFiltered = new ArrayList<>();
		
		Connection connection = null;
		String query = "SELECT from Anouncments WHERE PostedBY IN (Select SchoolID FROM User WHERE Role = ?)";
		
		try {
			connection = super.getConnection();
			 PreparedStatement sqlStatement = connection.prepareStatement(query);
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
				 
				 if (filePath.isEmpty()) {
					anouncments.add(new Anouncment(anouncmentID, postedBy, title, content, postedAt, postedTo));
				 }
				 else {
					 anouncments.add(new Anouncment(anouncmentID, postedBy, title, content, postedAt, filePath, fileName, fileType, postedTo));
				 }
				 for (Anouncment anouncment : anouncments) {
					if (!anouncmentsFiltered.contains(anouncment)) {
						anouncmentsFiltered.add(anouncment);
					}
				}
			 }
			 
			
			 
			
		} catch (Exception e) {
		
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
		System.out.println(anouncments.size());
		System.out.println(anouncmentsFiltered.size());
		return anouncmentsFiltered;
	}

	

	
	
	
	

}
