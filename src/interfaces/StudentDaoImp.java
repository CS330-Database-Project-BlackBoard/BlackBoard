package interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Database;
import pojos.Lecturer;
import pojos.SimpleCourse;
import pojos.Student;
import pojos.StudentGrade;

public class StudentDaoImp extends Database implements StudentDao{

	
	
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
		String query = "";
		
		
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
	
	
	
	

}
