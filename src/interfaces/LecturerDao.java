package interfaces;

import java.util.ArrayList;
import java.util.HashMap;

import pojos.CourseOfLecturer;
import pojos.Lecturer;
import pojos.LecturerCourseGrade;

public interface LecturerDao {
	
	
	public Lecturer getLecturerBySchooID(int schoolID);
	
	public ArrayList<Lecturer> getAllLecturers();
	
	public ArrayList<Lecturer> getLecturersByName(String name);
	
	public ArrayList<CourseOfLecturer> getCoursesOfLecturer(Lecturer lecturer);
	
	public ArrayList<LecturerCourseGrade> getCourseGradesOfLecturer(Lecturer lecturer);
	
	public boolean saveStudentGrades(Lecturer lecturer, int lectureID, String name, float affect, HashMap<Integer, Float> gradeOfStudents);

	public boolean updateStudentGrades(int gradeID, HashMap<Integer, Float> gradeOfStudents);

}
