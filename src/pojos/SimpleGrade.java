
package pojos;

public class SimpleGrade {

	private int lectureID;
	private int gradeID;
	private String name;
	private float affect;
	private float average;
	private float grade;
	
	
	public SimpleGrade( int lectureID, int gradeID, String name, float affect, float average) {
		super();
		this.lectureID = lectureID;
		this.gradeID = gradeID;
		this.name = name;
		this.affect = affect;
		this.average = average;
	}
	
	
	


	

	public SimpleGrade(int lectureID, int gradeID, String name, float affect, float average, float grade) {
		this.lectureID = lectureID;
		this.gradeID = gradeID;
		this.name = name;
		this.affect = affect;
		this.average = average;
		this.grade = grade;
	}

	



	public float getGrade() {
		return grade;
	}


	public int getLectureID() {
		return lectureID;
	}

	public int getGradeID() {
		return gradeID;
	}

	public String getName() {
		return name;
	}


	public float getAffect() {
		return affect;
	}







	public float getAverage() {
		return average;
	}


	
	
	
	
	
	
	
}
