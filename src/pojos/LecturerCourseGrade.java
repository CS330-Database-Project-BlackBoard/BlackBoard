package pojos;

import java.util.ArrayList;

public class LecturerCourseGrade {
	
	private CourseOfLecturer course;
	private ArrayList<SimpleGrade> grades;
	
	
	
	
	public LecturerCourseGrade(CourseOfLecturer course, ArrayList<SimpleGrade> grades) {
		super();
		this.course = course;
		this.grades = grades;
	}
	
	
	public Course getCourse() {
		return course;
	}
	public ArrayList<SimpleGrade> getGrades() {
		return grades;
	}
	
	
	

}
