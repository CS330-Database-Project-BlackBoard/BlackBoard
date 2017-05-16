package interfaces;

import java.util.ArrayList;

import pojos.SimpleCourse;
import pojos.Student;
import pojos.StudentGrade;


public interface StudentDao {

	public ArrayList<Student> getAllStudents();

	public ArrayList<SimpleCourse> getStudentGrades(int schoolID); 
	
	
	public ArrayList<StudentGrade> getStudentGradesByLecture(int schoolID,int lectureID); 
	
	public ArrayList<Student> getStudentsByLectureID(int lectureID); 
	
	
}
