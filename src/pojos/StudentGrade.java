package pojos;

public class StudentGrade extends SimpleGrade {

	float grade = 0;
	
	public StudentGrade(int lectureID, int gradeID, String name, float affect, float average, float grade) {
		super(lectureID, gradeID, name, affect, average);
		this.grade = grade;
	}

	public float getGrade() {
		return grade;
	}
	
	
	
	

}
