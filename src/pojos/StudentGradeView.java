package pojos;

public class StudentGradeView {
	
	private int studentID;
	private int gradeID;
	private String nameSurname;
	private float grade;
	
	
	
	public StudentGradeView(int studentID, int gradeID, String nameSurname, float grade) {
		super();
		this.studentID = studentID;
		this.gradeID = gradeID;
		this.nameSurname = nameSurname;
		this.grade = grade;
	}
	
	
	public int getStudentID() {
		return studentID;
	}
	public int getGradeID() {
		return gradeID;
	}
	public String getNameSurname() {
		return nameSurname;
	}
	public float getGrade() {
		return grade;
	}
	
	
	
	
}
