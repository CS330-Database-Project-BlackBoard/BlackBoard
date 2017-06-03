package interfaces;

import java.util.ArrayList;

import pojos.CourseOfLecturer;
import pojos.Lecturer;
import pojos.LecturerCourseGrade;

public interface LecturerDao {
	
	
	public Lecturer getLecturerBySchooID(int schoolID);
	
	public ArrayList<Lecturer> getAllLecturers();
	
	public ArrayList<Lecturer> getLecturersByName(String name);
	
	public ArrayList<CourseOfLecturer> getCoursesOfLecturer(Lecturer lecturer);
	
	public ArrayList<LecturerCourseGrade> getCourseGradesOfLecturer(Lecturer lecturer);
	

}
