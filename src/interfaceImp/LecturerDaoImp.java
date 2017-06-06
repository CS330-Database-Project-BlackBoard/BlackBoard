package interfaceImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.mysql.cj.api.jdbc.Statement;

import database.Database;
import enums.AppRole;
import helper.TimeZone;
import interfaces.LecturerDao;
import pojos.Course;
import pojos.CourseOfLecturer;
import pojos.Lecturer;
import pojos.LecturerCourseGrade;
import pojos.Manager;
import pojos.SimpleGrade;

public class LecturerDaoImp extends Database implements LecturerDao{

	
	// return lecturers as arraylist, gets query as parameter
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
	
	
	
	@Override
	public Lecturer getLecturerBySchooID(int schoolID) {
		
		String query = "SELECT  u.* "
				 + "FROM User u "
				 + "WHERE u.Role = " + AppRole.LECTURER + " "
				 + "AND u.visible = true "
				 + "AND u.SchoolID = " +schoolID;
		
		//return this.getLecturer(query); // no need extra function just get the first element of array list for single object
		return this.getLecturers(query).get(0);
	
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

	// get courses that are given by lecturer
	@Override
	public ArrayList<CourseOfLecturer> getCoursesOfLecturer(Lecturer lecturer) {

		ArrayList<CourseOfLecturer> courses = new ArrayList<>();
		
		CourseOfLecturer course = null;
		
		Connection connection = null;
		
		String query = "SELECT DISTINCT c.*, u.schoolID, u.Name AS LecturerName, u.Surname AS LecturerSurname, l.LectureID, l.Name AS LectureName, "
				+ "(SELECT COUNT(*) FROM CourseOfStudent WHERE LectureID = l.LectureID and Visible = true) AS EnrolledCount "
				+ "FROM Course c, User u, CourseOfLecturer cl, Lecture l " 
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

	// return course grades of lectures which are given by lecturer
	@Override
	public ArrayList<LecturerCourseGrade> getCourseGradesOfLecturer(Lecturer lecturer) {
		
		LecturerCourseGrade courseGrade= null;
		
		ArrayList<LecturerCourseGrade> courseGradesOfLecturer = new ArrayList<>();
		
		
		ArrayList<CourseOfLecturer> coursesOfLecturer = this.getCoursesOfLecturer(lecturer);  // use exist function
		
		CourseDaoImp courseDaoImp = new CourseDaoImp();
		
		for (CourseOfLecturer course : coursesOfLecturer) {
			
			ArrayList<SimpleGrade> grades = courseDaoImp.getLectureGrades(course.getLectureID()); // execute exist function for each course
			
			courseGrade = new LecturerCourseGrade(course, grades); // put in LecturerCourseGrade container
			courseGradesOfLecturer.add(courseGrade);
			
		}
		
		
		
		return courseGradesOfLecturer;
	}


	
	// save new grade and student grades
	@Override
	public boolean saveStudentGrades(Lecturer lecturer, int lectureID, String name, float affect, HashMap<Integer, Float> gradeOfStudents) {
		
		Connection connection = null;
		
		String queryInsertGrade = "INSERT INTO GradeOfCourse (LectureID, Name, Affect, CreatedBY) VALUES (?, ?, ?, ?)";
		String queryInsertStudentGrade =  "INSERT INTO GradeOfStudent (CourseGradeID, StudentID, Grade, GivenBY, CreatedAT) VALUES (?, ?, ?, ?, ?)";
		
		try {
			connection = super.getConnection();
			// firt insert the grade into Grade of course table
			
			PreparedStatement sqlStatement = connection.prepareStatement(queryInsertGrade, Statement.RETURN_GENERATED_KEYS); // return generated key will help to return the last genereted index
			sqlStatement.setInt(1, lectureID);
			sqlStatement.setString(2, name);
			sqlStatement.setFloat(3, affect);
			sqlStatement.setInt(4, lecturer.getSchoolID());
			sqlStatement.executeUpdate(); // insert
			
			try(ResultSet resultSet = sqlStatement.getGeneratedKeys()){ // if no error 
				if (resultSet.next()) { // get next element
					int courseGradeID = resultSet.getInt(1); // get last index from table
					
					sqlStatement = connection.prepareStatement(queryInsertStudentGrade); // now will add the user grades
					
					for (Map.Entry<Integer, Float> entry : gradeOfStudents.entrySet()) { // iterate hash map
						
						sqlStatement.setInt(1, courseGradeID); 
						sqlStatement.setInt(2, entry.getKey());
						sqlStatement.setFloat(3, entry.getValue());
						sqlStatement.setInt(4, lecturer.getSchoolID());
						sqlStatement.setString(5, TimeZone.getDateTime());
						sqlStatement.executeUpdate(); // insert datas and execute
					}
					
				}
			}
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
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
		
		
		return true;
	}


	@Override
	public boolean updateStudentGrades(int gradeID, HashMap<Integer, Float> gradeOfStudents) {

		Connection connection = null;


		try {

			connection = super.getConnection();
			String queryUpdateStudentGrades = "UPDATE GradeOfStudent SET Grade = ?, UpdatedAt = ? WHERE CourseGradeID = ? AND StudentID = ?";

			PreparedStatement sqlStatement = connection.prepareStatement(queryUpdateStudentGrades);

			for (Map.Entry<Integer, Float> entry : gradeOfStudents.entrySet()){
				sqlStatement.setFloat(1, entry.getValue());
				sqlStatement.setString(2, TimeZone.getDateTime());
				sqlStatement.setInt(3, gradeID);
				sqlStatement.setInt(4, entry.getKey());

				sqlStatement.executeUpdate(); // insert datas and execute
			}

		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
		finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		return true;
	}



}
