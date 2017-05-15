package pojos;

public class SimpleCourse {

	private int courseID;
	private String code;
	private String name;
	
	
	
	public int getCourseID() {
		return courseID;
	}

	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	
	public SimpleCourse(int courseID, String code, String name) {
		super();
		this.courseID = courseID;
		this.code = code;
		this.name = name;
	}
	
	
	
}
