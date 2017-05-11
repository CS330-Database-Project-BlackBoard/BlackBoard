package pojos;

public class CourseOfLecturer extends Course {

	
	private int enrolledStudent = 0;
	
	public CourseOfLecturer(int courseID, int departmentID, String code, String name, int semesterID, boolean visible,
			int lecturerID, String lecturerName, String lecturerSurname, int lectureID, String lectureName, int enrolledStudent) {
		super(courseID, departmentID, code, name, semesterID, visible, lecturerID, lecturerName, lecturerSurname, lectureID,
				lectureName);
		this.enrolledStudent = enrolledStudent;
	}

	
	public int getEnrolledStudent() {
		return enrolledStudent;
	}


}
