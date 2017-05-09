package interfaceImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Database;
import enums.AppRole;
import interfaces.LecturerDao;
import pojos.Lecturer;
import pojos.Manager;

public class LecturerDaoImp extends Database implements LecturerDao{

	
	
	private ArrayList<Lecturer> getLecturers(String query){
		ArrayList<Lecturer> lecturers = new ArrayList<>();
		Connection connection = null;
		Lecturer lecturer = null;
		
		try {
			connection = super.getConnection();
			PreparedStatement sqlStatement = connection.prepareStatement(query);
			ResultSet resultSet = sqlStatement.executeQuery();
			
			while(resultSet.next()){
				int schoolID = resultSet.getInt("SchoolID");
				String name = resultSet.getString("Name");
				String surname = resultSet.getString("Surname");
				String email = resultSet.getString("Email");
				int role = resultSet.getInt("Role");
				String roleDescription = resultSet.getString("Description");
				
				lecturer = new Lecturer(schoolID, email, name, surname, role);
				lecturers.add(lecturer);
				
			}

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return lecturers;
		
	}
	
	
	private Lecturer getLecturer(String query) {
			Connection connection = null;
			Lecturer lecturer = null;
			
			try {
				connection = super.getConnection();
				PreparedStatement sqlStatement = connection.prepareStatement(query);
				ResultSet resultSet = sqlStatement.executeQuery();
				
				if(resultSet.next()){
					int schoolID = resultSet.getInt("SchoolID");
					String name = resultSet.getString("Name");
					String surname = resultSet.getString("Surname");
					String email = resultSet.getString("Email");
					int role = resultSet.getInt("Role");
					String roleDescription = resultSet.getString("Description");
					
					lecturer = new Lecturer(schoolID, email, name, surname, role);
					
				}

			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			finally{
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			return lecturer;
			
		
		
	}
	
	
	
	@Override
	public Lecturer getLecturerBySchooID(int schoolID) {
		
		String query = "SELECT  u.* "
				 + "FROM User u "
				 + "WHERE u.Role = " + AppRole.LECTURER + " "
				 + "AND u.visible = true"
				 + "AND u.SchoolID = " +schoolID;
		
		return this.getLecturer(query);
	}

	@Override
	public ArrayList<Lecturer> getAllLecturers() {
		
		String query = "SELECT  u.* "
					 + "FROM User u "
					 + "WHERE u.Role = " + AppRole.LECTURER + " "
					 + "AND u.visible = true";
		
		return this.getLecturers(query);
		
	}

	@Override
	public ArrayList<Lecturer> getLecturersByName(String name) {
		String query = "SELECT  u.* "
				 + "FROM User u "
				 + "WHERE u.Role = " + AppRole.LECTURER + " "
				 + "AND u.visible = true "
				 + "AND u.Name LIKE '%" + name + "%'";
	
		return this.getLecturers(query);
	
	}
	
	
	

}
