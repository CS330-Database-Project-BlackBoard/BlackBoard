package pojos;

import java.util.ArrayList;

public class StudentCourseGrade {
	
	private Course course;
	private ArrayList<StudentGrade> grades;
	
	
	
	public StudentCourseGrade(Course course, ArrayList<StudentGrade> grades) {
		super();
		this.course = course;
		this.grades = grades;
	}



	public Course getCourse() {
		return course;
	}



	public ArrayList<StudentGrade> getGrades() {
		return grades;
	}
	
	
	

}
