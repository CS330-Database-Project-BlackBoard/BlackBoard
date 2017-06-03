package interfaceImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Database;
import enums.AppRole;
import interfaces.DashboardDao;
import pojos.Announcement;
import pojos.Dashboard;
import pojos.User;

public class DashboardDaoImp extends Database implements DashboardDao{

	@Override
	public Dashboard getDashboard(User user) {
		Connection connection = null;
		Dashboard dashboard = null;
		PreparedStatement sqlStatement = null;
		ResultSet resultSet = null;
		int manager = 0, lecturer = 0, student = 0, course = 0;
		
		AnnouncementDaoImp announcementDaoImp = new AnnouncementDaoImp();
		ArrayList<Announcement> anouncments = announcementDaoImp.getAnnouncementsByRole(user.getRole());

		String managerSql = "SELECT COUNT(*) AS Count FROM User WHERE visible = 1 AND Role BETWEEN ? AND ?";
		String lecturerAndStudentSql = "SELECT COUNT(*) AS Count FROM User WHERE visible = 1 AND Role = ?";
		String CourseSql = "SELECT COUNT(*) AS Count FROM Lecture WHERE visible = 1;";
		//String CourseSql = "SELECT COUNT(*) AS Count FROM Lecture WHERE visible = 1 AND SemesterID = (SELECT SemesterID FROM Semester WHERE Name = ? and Year = ?)";
		
		try {
			connection = super.getConnection();
			sqlStatement = connection.prepareStatement(managerSql);
			sqlStatement.setInt(1, AppRole.SUPER_ADMIN);
			sqlStatement.setInt(2, AppRole.ADMIN);
			resultSet = sqlStatement.executeQuery();
			
			if (resultSet.next()) {
				manager = resultSet.getInt("Count");
			}
			
			sqlStatement = connection.prepareStatement(lecturerAndStudentSql);
			sqlStatement.setInt(1, AppRole.LECTURER);
			resultSet = sqlStatement.executeQuery();
			
			if (resultSet.next()) {
				lecturer = resultSet.getInt("Count");
				
			}
			
			sqlStatement = connection.prepareStatement(lecturerAndStudentSql);
			sqlStatement.setInt(1,AppRole.STUDENT);
			resultSet = sqlStatement.executeQuery();
			if (resultSet.next()) {
				student = resultSet.getInt("Count");
				
			}
			
			sqlStatement = connection.prepareStatement(CourseSql);
			//sqlStatement.setString(1,"Spring");
			//sqlStatement.setInt(2, 2017);
			resultSet = sqlStatement.executeQuery();
			
			if (resultSet.next()) {
				course = resultSet.getInt("Count");
				
			}
	
			dashboard = new Dashboard(manager, course, lecturer, student, anouncments);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		return dashboard;
	}

	
	
}
