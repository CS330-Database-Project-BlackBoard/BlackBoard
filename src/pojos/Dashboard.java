package pojos;

import java.util.ArrayList;

public class Dashboard {
	
	private int managerCount;
	private int courseCount;
	private int lecturerCount;
	private int studentCount;
	private ArrayList<Anouncment> anouncments;
	
	
	public Dashboard(int managerCount, int courseCount, int lecturerCount, int studentCount, ArrayList<Anouncment> anouncments) {
		this.managerCount = managerCount;
		this.courseCount = courseCount;
		this.lecturerCount = lecturerCount;
		this.studentCount = studentCount;
		this.anouncments = anouncments;
	}
	
	public int getManagerCount() {
		return managerCount;
	}
	public int getCourseCount() {
		return courseCount;
	}
	public int getLecturerCount() {
		return lecturerCount;
	}
	public int getStudentCount() {
		return studentCount;
	}

	public ArrayList<Anouncment> getAnouncments() {
		return anouncments;
	}
	
	
	
	
	

}
