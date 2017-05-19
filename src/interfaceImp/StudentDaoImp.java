package interfaceImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Database;
import interfaces.StudentDao;
import pojos.Lecturer;
import pojos.SimpleCourse;
import pojos.Student;
import pojos.StudentGrade;

public class StudentDaoImp extends Database implements StudentDao {

	
	
	@Override
	public ArrayList<SimpleCourse> getStudentGrades(int schoolID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<StudentGrade> getStudentGradesByLecture(int schoolID, int lectureID) {
		// TODO Auto-generated method stub
		return null;
	}

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
		String query1 = "SELECT u.SchoolID, u.Name, u.Surname, u.Role, u.Email, AVG(0.01 * goc.Affect* gos.Grade) "
					  + "FROM GradeOfCourse goc, GradeOfStudent gos, User u, CourseOfStudent cos " 
					  + "WHERE " 
					  + "gos.CourseGradeID = goc.GradeID "  
					  + "AND u.SchoolID = gos.StudentID " 
					  + "AND goc.LectureID = ? "  
					  + "GROUP BY u.SchoolID;";
		
		String query2 = "SELECT u.SchoolID, u.Name, u.Surname, u.Role, u.Email, 0 "
				  + "FROM GradeOfCourse goc, GradeOfStudent gos, User u, CourseOfStudent cos " 
				  + "WHERE " 
				  + "gos.CourseGradeID = goc.GradeID "  
				  + "AND u.SchoolID = gos.StudentID " 
				  + "AND goc.LectureID = ?"  
				  + "GROUP BY u.SchoolID ";
	
		
		try {
			connection = super.getConnection();
			PreparedStatement sqlStatement = connection.prepareStatement(query1);
			sqlStatement.setInt(1, lectureID);

			ResultSet resultSet = sqlStatement.executeQuery();
			
			while(resultSet.next()){
				int schoolID = resultSet.getInt("SchoolID");
				String name = resultSet.getString("Name");
				String surname = resultSet.getString("Surname");
				String email = resultSet.getString("Email");
				int role = resultSet.getInt("Role");
				float average = resultSet.getFloat("Average");
				
				student = new Student(schoolID, email, name, surname, role, average);
				students.add(student);
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
					System.out.println(getClass() + "line 100 ");
					e.printStackTrace();
				}
			}
		}

		return students;
	}





}
