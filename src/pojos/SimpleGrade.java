package pojos;

public class SimpleGrade {

	private int lectureID;
	private int gradeID;
	private String name;
	private int affect;
	private float average;
	
	public SimpleGrade( int lectureID, int gradeID, String name, int affect, float average) {
		super();
		this.lectureID = lectureID;
		this.gradeID = gradeID;
		this.name = name;
		this.affect = affect;
		this.average = average;
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

	public int getAffect() {
		return affect;
	}

	public float getAverage() {
		return average;
	}


	
	
	
	
	
	
	
}
