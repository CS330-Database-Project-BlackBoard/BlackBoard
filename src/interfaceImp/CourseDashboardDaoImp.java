package interfaceImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Database;
import interfaces.CourseDashboardDao;
import pojos.Course;
import pojos.CourseDashboard;

public class CourseDashboardDaoImp extends Database implements CourseDashboardDao{

	
	
	@Override
	public CourseDashboard getCourseDashboard() {
		
		int activeCourseCount = 0;
		int inactiveCourseCount = 0;
		
		CourseDashboard courseDashboard = null;
		ArrayList<Course> courses = new ArrayList<>();
		Course course = null;
		
		Connection connection = null;
		
		String query = "SELECT c.*, u.schoolID, u.Name AS LecturerName, u.Surname AS LecturerSurname, l.LectureID, l.Name AS LectureName "
					 + "FROM Course c, User u, CourseOfLecturer cl, Lecture l "
					 + "WHERE cl.LectureID = l.LectureID "
					 + "AND l.CourseID = c.CourseID "
					 + "AND cl.SchoolID = u.SchoolID;";		
		try {
			connection = super.getConnection();
			PreparedStatement sqlStatement = connection.prepareStatement(query);
			ResultSet resultSet = sqlStatement.executeQuery();
			
			while(resultSet.next()) {
				int courseID = resultSet.getInt("CourseID");
				int departmentID = resultSet.getInt("DepartmentID");
				String code = resultSet.getString("Code");
				String name = resultSet.getString("Name");
				int semesterID = resultSet.getInt("SemesterID");
				boolean visible = resultSet.getBoolean("Visible");
				int lecturerID = resultSet.getInt("SchoolID");
				String lecturerName = resultSet.getString("LecturerName");
				String lecturerSurname = resultSet.getString("LecturerSurname");
				int lectureID = resultSet.getInt("LectureID");
				String lectureName = resultSet.getString("LectureName");
				
				if(visible == true) {
					activeCourseCount++;
					course = new Course(courseID, departmentID, code, name, semesterID, visible, lecturerID, lecturerName, lecturerSurname, lectureID, lectureName);
					courses.add(course);
				}
				else {
					inactiveCourseCount++;
				}		
			}
			
			
		} 
		catch (Exception e) {
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
		
		courseDashboard = new CourseDashboard(activeCourseCount, inactiveCourseCount, courses);

		return courseDashboard;
		
	}
	
	
	
	
	

}
