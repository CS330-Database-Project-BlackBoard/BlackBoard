package pojos;

import java.util.ArrayList;

public class CourseMaterial {
	private Course course;
	ArrayList<File> files;
	
	
	

	
	public CourseMaterial(Course course, ArrayList<File> files) {
		super();
		this.course = course;
		this.files = files;
	}


	public Course getCourse() {
		return course;
	}
	
	public ArrayList<File> getFiles() {
		return files;
	}
	
	
	
	
	
	

}
