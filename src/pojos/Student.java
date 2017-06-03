package pojos;

import java.util.ArrayList;

public class Student extends User {

	private float average = 0;
	private ArrayList<StudentGrade> grades = null;
	
	public Student(int schoolID, String email, String name, String surname, int role) {
		super(schoolID, email, name, surname, role);
	}
	
	public Student(int schoolID, String email, String name, String surname, int role, float average) {
		super(schoolID, email, name, surname, role);
		this.average = average;
	}
	
	public Student(int schoolID, String email, String name, String surname, int role, float average, ArrayList<StudentGrade> grades) {
		super(schoolID, email, name, surname, role);
		this.average = average;
		this.grades = grades;
	}

	public float getAverage() {
		return average;
	}

	public ArrayList<StudentGrade> getGrades() {
		return grades;
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		Student other = (Student) obj;
		return other.getSchoolID() == this.getSchoolID();
	}

	
	
}
