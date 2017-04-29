package interfaceImp;

import java.math.BigInteger;
import java.security.MessageDigest;
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

	@Override
	public boolean signIn(String email, String password) {
		if (this.user == null) {
			String query = "SELECT SchoolID, Name, Surname, Role from User WHERE Email=? AND Password=?;";
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
	
	
	private static String md5(String input) {
		
		String md5 = null;
		
		if(null == input) return null;
		
		try {
			
		//Create MessageDigest object for MD5
		MessageDigest digest = MessageDigest.getInstance("MD5");
		
		//Update input string in message digest
		digest.update(input.getBytes(), 0, input.length());

		//Converts message digest value in base 16 (hex) 
		md5 = new BigInteger(1, digest.digest()).toString(32);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return md5;
	}
}

	
	

