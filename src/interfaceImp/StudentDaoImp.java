package interfaceImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import database.Database;
import interfaces.StudentDao;
import pojos.Course;
import pojos.Student;
import pojos.StudentCourseGrade;
import pojos.StudentGrade;

public class StudentDaoImp extends Database implements StudentDao {

	
	// get courses that are taken by student
	@Override
	public ArrayList<Course> getStudentCourse(int schoolID) {
		
		
		CourseDaoImp courseDaoImp = new CourseDaoImp();
		return courseDaoImp.getCourseByStudentID(schoolID); // use exist function
	}

	// get student grades for specific lecture
	@Override
	public ArrayList<StudentGrade> getStudentGradesByLecture(int schoolID, int lectureID) {
		
		ArrayList<StudentGrade> grades = new ArrayList<>();
		StudentGrade grade = null;
		
		Connection connection = null;
		
		String query = "SELECT distinct  gos.GradeID, goc.Name, goc.Affect, "
					 + "(SELECT AVG(Grade) FROM GradeOfStudent WHERE CourseGradeID = goc.GradeID) AS Average, gos.Grade " 
					 + "FROM GradeOfCourse goc, GradeOfStudent gos, CourseOfStudent cos "
					 + "WHERE " 
					 + "gos.CourseGradeID = goc.GradeID " 
					 + "AND gos.StudentID = ? "
					 + "AND goc.LectureID = ?;";
		
		
		try {
			connection = super.getConnection();
			PreparedStatement sqlStatement = connection.prepareStatement(query);
			
			sqlStatement.setInt(1, schoolID);
			sqlStatement.setInt(2, lectureID);
			ResultSet resultSet = sqlStatement.executeQuery();
			while(resultSet.next()) {
				
				int gradeID = resultSet.getInt("GradeID");
				String name = resultSet.getString("Name");
				float affect  = resultSet.getFloat("Affect");
				float average = resultSet.getFloat("Average");
				float studentGrade = resultSet.getFloat("Grade");

				grade = new StudentGrade(lectureID, gradeID, name, affect, average, studentGrade);
				grades.add(grade);
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
		
		
		return grades;
	}

	
	// return students for specific lecture
	@Override
	public ArrayList<Student> getStudentsByLectureID(int lectureID) {
		
		ArrayList<Student> students = new ArrayList<>();
		Connection connection = null;
		Student student = null;
		/*
		String query = "set @countOfLectureGrade = (SELECT Count(goc.Affect) FROM GradeOfCourse goc WHERE goc.LectureID = ?);" 
						+ "SELECT u.SchoolID, u.Name, u.Surname, u.Role, u.Email, " 
						+ "CASE WHEN @countOfLecture = 0 then 0 " 
						+ "ELSE AVG(0.01 * goc.Affect * gos.Grade) " 
						+ "END AS Average "  
						+ "FROM GradeOfCourse goc, GradeOfStudent gos, User u, CourseOfStudent cos "
						+ "WHERE " 
						+ "(gos.CourseGradeID = goc.GradeID AND u.SchoolID = gos.StudentID AND goc.LectureID = ?) " 
						+ "OR (u.SchoolID = cos.SchoolID AND cos.LectureID = ? AND @countOfLectureGrade = 0) " 
						+ "GROUP BY u.SchoolID;";
				
		*/
		
		// if user has grades use this query
		String query1 = "SELECT u.SchoolID, u.Name, u.Surname, u.Role, u.Email, SUM(0.01 * goc.Affect* gos.Grade) AS Average "
					  + "FROM GradeOfCourse goc, GradeOfStudent gos, User u, CourseOfStudent cos " 
					  + "WHERE " 
					  + "gos.CourseGradeID = goc.GradeID "  
					  + "AND u.SchoolID = gos.StudentID "
					  + "AND goc.LectureID = cos.LectureID "
					  + "AND goc.LectureID = ? "
					  + "AND  cos.SchoolID = gos.StudentID "
					  + "AND cos.visible = true "
					  + "GROUP BY u.SchoolID;";
		
		// if user does not have any grade use this query
		String query2 = "SELECT u.SchoolID, u.Name, u.Surname, u.Role, u.Email, 0 AS Average "
				  + "FROM User u, CourseOfStudent cos " 
				  + "WHERE " 
				  + "u.SchoolID = cos.SchoolID "
				  + "AND cos.LectureID = ? "
				  + "AND cos.visible = true "
				  + "GROUP BY u.SchoolID;";
	
		
		try {
			connection = super.getConnection();
			PreparedStatement sqlStatement = connection.prepareStatement(query1);
			sqlStatement.setInt(1, lectureID);
			ResultSet resultSet = sqlStatement.executeQuery();
	
			while(resultSet.next()){ // get resuts from first query
				
				int schoolID = resultSet.getInt("SchoolID");
				String name = resultSet.getString("Name");
				String surname = resultSet.getString("Surname");
				String email = resultSet.getString("Email");
				int role = resultSet.getInt("Role");
				float average = resultSet.getFloat("Average");
				
				student = new Student(schoolID, email, name, surname, role, average);
				students.add(student);
			}
			// eger ogrencinin notu yoksa ama derse kayit edilmis ise
			
			sqlStatement = connection.prepareStatement(query2);
			sqlStatement.setInt(1, lectureID);
			resultSet = sqlStatement.executeQuery();
		
			while(resultSet.next()){ // then get from second query
				int schoolID = resultSet.getInt("SchoolID");
				String name = resultSet.getString("Name");
				String surname = resultSet.getString("Surname");
				String email = resultSet.getString("Email");
				int role = resultSet.getInt("Role");
				float average = resultSet.getFloat("Average");
				
				student = new Student(schoolID, email, name, surname, role, average);
				
				if(!students.contains(student)) { // if there is no conflict
					students.add(student);
				}
				
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
		
		return students;
	}


	/*
	* coded by: koryozyut
	* */
	@Override
	public ArrayList<Student> getAllStudents() {
		Student student = null;
		ArrayList<Student> students = new ArrayList<>();
		Connection connection = null;

		String query = "SELECT u.SchoolID, u.Email, u.Name, u.Surname, u.Role "
				+ "FROM User u "
				+ "WHERE u.Role = 5 AND u.visible = true;";

		try {
			connection = super.getConnection();
			PreparedStatement sqlStatement = connection.prepareStatement(query);
			ResultSet resultSet = sqlStatement.executeQuery();
			while (resultSet.next()){
				int schoolID = resultSet.getInt("SchoolID");
				String name = resultSet.getString("Name");
				String surname = resultSet.getString("Surname");
				String email = resultSet.getString("Email");
				int role = resultSet.getInt("Role");

				student = new Student(schoolID, email, name, surname, role);
				students.add(student);
			}
		}catch (Exception e){
			System.out.println(getClass() + " ");
			e.printStackTrace();
		}finally {
			if(connection != null){
				try{
					connection.close();
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		}

		return students;
	}

	
	// get specific student
	@Override
	public Student getStudent(int schoolID) {
		Student student = null;
		
		String query = "SELECT SchoolID, Email, Name, Surname, Role from User WHERE SchoolID = ? AND visible = true;";
		Connection connection = null;
		
		try {
			connection = this.getConnection();
			PreparedStatement sqlStatement = connection.prepareStatement(query);
			sqlStatement.setInt(1, schoolID);
			
			ResultSet resultSet = sqlStatement.executeQuery();
			if (resultSet.next()) {
				String email = resultSet.getString("Email");
				String name = resultSet.getString("Name");
				String surname = resultSet.getString("Surname");
				int role = resultSet.getInt("Role");
				student = new Student(schoolID, email, name, surname, role);
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
		
		
		return student;
	}

	// remove course from student course list
	@Override
	public boolean deleteStudentCourse(int schoolID, int lectureID) {
		
		boolean result = false;
		
		Connection connection = null;
		
		String query = "UPDATE CourseOfStudent SET Visible = false WHERE SchoolID = ? AND LectureID = ?";
		
		
		
		try {
			connection = super.getConnection();
			PreparedStatement sqlStatement = connection.prepareStatement(query);
			sqlStatement.setInt(1, schoolID);
			sqlStatement.setInt(2,lectureID);
			sqlStatement.executeUpdate();
			result = true;
		}
		catch(Exception e) {
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
		
		return result;
	}

	
	// add new course to student course list
	@Override
	public boolean addStudentCourse(int schoolID, int lectureID) {

		boolean added = false;
		Connection connection = null;
		
		String query = "INSERT INTO CourseOfStudent(SchoolID, LectureID) VALUES (?, ?) ON DUPLICATE KEY UPDATE Visible = true";

		
		
		try {
			connection = super.getConnection();
			
			PreparedStatement sqlStatement = connection.prepareStatement(query);
			sqlStatement.setInt(1, schoolID);
			sqlStatement.setInt(2, lectureID);
			sqlStatement.executeUpdate();
			added = true;
			
			
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
		
		return added;
	
	}

	
	// returns grades of student for all courses, StudentCourseGrade acts as container keep Course object and Arraylist for grades
	@Override
	public ArrayList<StudentCourseGrade> getStudentCourseGrades(int schoolID) {
		ArrayList<StudentCourseGrade> studentCourseGrades = new ArrayList<>();
		
		ArrayList<Course> courses = this.getStudentCourse(schoolID);
		
		StudentCourseGrade studentCourseGrade = null;
		
		float classAverage;
		float overAll;
		float affectTotal;
		
		for (Course course : courses) {
			classAverage = 0; // set 0 for each course
			overAll = 0;
			affectTotal = 0;
			
			ArrayList<StudentGrade> grades = this.getStudentGradesByLecture(schoolID, course.getLectureID()); // get grades from exist func.
			
			for(StudentGrade studentGrade: grades) { // calculate averages and over all grade
				classAverage += (0.01 * studentGrade.getAffect() * studentGrade.getAverage());
				overAll += (0.01 * studentGrade.getAffect() * studentGrade.getGrade());
				affectTotal += studentGrade.getAffect();
			}
			
			StudentGrade overAllGrade = new StudentGrade(course.getLectureID(), 0, "Overall", affectTotal , classAverage, overAll); // add overall for each course
			
			grades.add(overAllGrade);
			
			studentCourseGrade = new StudentCourseGrade(course, grades);
			
			studentCourseGrades.add(studentCourseGrade);
			
		}
		
	
		
		
		return studentCourseGrades;
	}





}
