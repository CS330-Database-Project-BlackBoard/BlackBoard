package interfaceImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Database;
import enums.AppRole;
import interfaces.LecturerDao;
import pojos.Course;
import pojos.CourseOfLecturer;
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
				 + "AND u.visible = true "
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
				 + "AND concat(u.Name, '', u.Surname) LIKE '%" + name + "%';";
	
		return this.getLecturers(query);
	
	}


	
	
	
	@Override
	public ArrayList<CourseOfLecturer> getCoursesOfLecturer(Lecturer lecturer) {

		ArrayList<CourseOfLecturer> courses = new ArrayList<>();
		
		CourseOfLecturer course = null;
		
		Connection connection = null;
		
		String query = "SELECT DISTINCT c.*, u.schoolID, u.Name AS LecturerName, u.Surname AS LecturerSurname, l.LectureID, l.Name AS LectureName, "
				+ "(SELECT COUNT(*) FROM CourseOfStudent WHERE LectureID = l.LectureID) AS EnrolledCount "
				+ "FROM Course c, User u, CourseOfLecturer cl, Lecture l, CourseOfStudent cs " 
				+ "WHERE c.CourseID =  l.CourseID " 
				+ "AND l.LectureID = cl.LectureID " 
				+ "AND u.SchoolID = cl.SchoolID "
				+ "AND u.Role = " + AppRole.LECTURER + " " 
				+ "AND cl.SchoolID = " + lecturer.getSchoolID() + " " 
				+ "AND cl.Visible = true;"; 
			
		
		
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
				int enrolledStudent = resultSet.getInt("EnrolledCount");
				course = new CourseOfLecturer(courseID, departmentID, code, name, semesterID, visible, lecturerID, lecturerName, lecturerSurname, lectureID, lectureName, enrolledStudent);
				courses.add(course);
				
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
		return courses;
		
	}
	
	
	

}
