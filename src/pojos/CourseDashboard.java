package pojos;

import java.util.ArrayList;

public class CourseDashboard {
	
	private int activeCourseCount;
	private int inactiveCourseCount;
	private ArrayList<Course> courses;
	
	
	public CourseDashboard(int activeCourseCount, int inactiveCourseCount, ArrayList<Course> courses) {
		super();
		this.activeCourseCount = activeCourseCount;
		this.inactiveCourseCount = inactiveCourseCount;
		this.courses = courses;
	}


	public int getActiveCourseCount() {
		return activeCourseCount;
	}


	public int getInactiveCourseCount() {
		return inactiveCourseCount;
	}


	public ArrayList<Course> getCourses() {
		return courses;
	}
	
	
	
	
	

}
