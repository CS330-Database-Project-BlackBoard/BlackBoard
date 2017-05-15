package pojos;

import java.util.ArrayList;

public class LectureDetail {

	private Course course;
	private ArrayList<SimpleGrade> grades;
	private ArrayList<Student> students;
	

	public LectureDetail(Course course, ArrayList<SimpleGrade> grades, ArrayList<Student> students) {
		super();
		this.course = course;
		this.grades = grades;
		this.students = students;
	}

	public Course getCourse() {
		return course;
	}

	public ArrayList<SimpleGrade> getGrades() {
		return grades;
	}
	
	
	
	

	
	

}
