package pojos;

public class Assignment {
	 
	//Need new table called Assignment (AssignmentID, lectureID, FileID, Title, Detail, PostedAT, DueDate)

	/**
	 * In fact we do not need to keep course because of the CourseAssignment class.
	 * But if we keep the course in here too, jsp implementation is easily than.
	 */
	private int assignmentID;
	private int lectureID;
	private String filePath;
	private String name;
	private String postedAT;
	private String dueDate;
	private Course course;
	private boolean isSubmitted;

	public Assignment(int assignmentID, int lectureID, String filePath, String name, String postedAT, String dueDate, Course course, boolean isSubmitted) {
		this.assignmentID = assignmentID;
		this.lectureID = lectureID;
		this.filePath = filePath;
		this.name = name;
		this.postedAT = postedAT;
		this.dueDate = dueDate;
		this.course = course;
		this.isSubmitted = isSubmitted;
	}

	public int getAssignmentID() {
		return assignmentID;
	}

	public int getLectureID() {
		return lectureID;
	}

	public String getFilePath() {
		return filePath;
	}

	public String getName() {
		return name;
	}

	public String getPostedAT() {
		return postedAT;
	}

	public String getDueDate() {
		return dueDate;
	}

	public Course getCourse() {
		return course;
	}

	public boolean isSubmitted() {
		return isSubmitted;
	}

	public void setSubmitted(boolean submitted) {
		isSubmitted = submitted;
	}
}
