package pojos;

public class Course {
	private int courseID;
	private int departmentID;
	private String code;
	private String name;
	private int semesterID;
	private boolean visible;
	
	private int lecturerID;
	private String lecturerName;
	private String lecturerSurname;
	
	private int lectureID;
	private String lectureName;
	
	
	

	
	public Course(int courseID, int departmentID, String code, String name, int semesterID, boolean visible,
			int lecturerID, String lecturerName, String lecturerSurname, int lectureID, String lectureName) {
		super();
		this.courseID = courseID;
		this.departmentID = departmentID;
		this.code = code;
		this.name = name;
		this.semesterID = semesterID;
		this.visible = visible;
		this.lecturerID = lecturerID;
		this.lecturerName = lecturerName;
		this.lecturerSurname = lecturerSurname;
		this.lectureID = lectureID;
		this.lectureName = lectureName;
	}
	

	
	public int getCourseID() {
		return courseID;
	}



	public int getDepartmentID() {
		return departmentID;
	}



	public String getCode() {
		return code;
	}



	public String getName() {
		return name;
	}



	public int getSemesterID() {
		return semesterID;
	}



	public boolean isVisible() {
		return visible;
	}



	public int getLecturerID() {
		return lecturerID;
	}



	public String getLecturerName() {
		return lecturerName;
	}



	public String getLecturerSurname() {
		return lecturerSurname;
	}



	public int getLectureID() {
		return lectureID;
	}



	public String getLectureName() {
		return lectureName;
	}



	public String getLecturerInf() {
		return String.format("%s %s", this.lecturerName, this.lecturerSurname);
	}
	
	@Override
	public boolean equals(Object obj) {
		Course course = (Course) obj;
		if(this.getCourseID() == course.getCourseID()) {
			return true;
		}
		return false;
	}
	
	
}
