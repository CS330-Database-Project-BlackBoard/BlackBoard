package interfaces;

import java.util.ArrayList;

import pojos.CourseOfLecturer;
import pojos.Lecturer;

public interface LecturerDao {
	
	
	public Lecturer getLecturerBySchooID(int schoolID);
	
	public ArrayList<Lecturer> getAllLecturers();
	
	public ArrayList<Lecturer> getLecturersByName(String name);
	
	public ArrayList<CourseOfLecturer> getCoursesOfLecturer(Lecturer lecturer);
	

}
