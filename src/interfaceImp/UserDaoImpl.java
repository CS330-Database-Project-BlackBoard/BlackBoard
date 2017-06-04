package interfaceImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.Database;
import interfaces.UserDao;
import pojos.User;

public class UserDaoImpl extends Database implements UserDao{

	private User user = null;
	
	@Override
	public User getUser() {
		return this.user;
	}

	// check user exist and parameters are correct, and assign new User to user object
	@Override
	public boolean signIn(String email, String password) {
		if (this.user == null) {
			String query = "SELECT SchoolID, Name, Surname, Role from User WHERE Email=? AND Password=? AND visible = true;";
			Connection connection = null;
			
			try {
				connection = this.getConnection();
				PreparedStatement sqlStatement = connection.prepareStatement(query);
				sqlStatement.setString(1, email);
				sqlStatement.setString(2, password);
				
				ResultSet resultSet = sqlStatement.executeQuery();
				if (resultSet.next()) {
					int schoolID = resultSet.getInt("SchoolID");
					String name = resultSet.getString("Name");
					String surname = resultSet.getString("Surname");
					int role = resultSet.getInt("Role");
					this.user = new User(schoolID, email, name, surname, role);
					return true;
				}
				
			} catch (Exception e) {
				e.fillInStackTrace();
			}
			finally {
				if(connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
		return false;
	}

	@Override
	public boolean signOut() {
		this.user = null;
		return true;
	}
	
	

}

	
	

