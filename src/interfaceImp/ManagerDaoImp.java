package interfaceImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Database;
import enums.AppRole;
import interfaces.ManagerDao;
import pojos.Manager;
import pojos.Role;
import pojos.User;

public class ManagerDaoImp extends Database implements ManagerDao{

	@Override
	public boolean createNewManager(Manager manager) {
		boolean doesSaved = false;
		
		Connection connection = null;
		
		String query = "INSERT INTO User (SchoolID, Name, Surname, Password, Email, Role) VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
			connection = super.getConnection();
			PreparedStatement sqlStatement = connection.prepareStatement(query);
			
			sqlStatement.setInt(1, manager.getSchoolID());
			sqlStatement.setString(2, manager.getName());
			sqlStatement.setString(3, manager.getSurname());
			sqlStatement.setString(4, manager.getPassword());
			sqlStatement.setString(5, manager.getEmail());
			sqlStatement.setInt(6, manager.getRole());
			
			sqlStatement.executeUpdate();
			doesSaved = true;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return doesSaved;
	}

	@Override
	public boolean updateRole(Manager manager) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteManager(Manager manager) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Manager> getAllManagers() {
		Manager manager = null;
		ArrayList<Manager> managers = new ArrayList<>();
		Connection connection = null;
		
		String query = "SELECT  u.*, r.Description "
					 + "FROM User u, Role r "
					 + "WHERE u.Role <= 2 AND u.visible = true AND r.Level = u.Role";
		
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
				
				manager = new Manager(schoolID, email, name, surname, role, roleDescription);
				managers.add(manager);
				
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
		
		return managers;
	}

	@Override
	public Manager getManagerByID(int SchoolID) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	public ArrayList<Role> getAdminRoles() {
		ArrayList<Role> roles = new ArrayList<>();
		
		roles.add(new Role(AppRole.SUPER_ADMIN, "Super Admin"));
		roles.add(new Role(AppRole.ADMIN, "Admin"));
		
		return roles;
		
	}
	
	
	
}
