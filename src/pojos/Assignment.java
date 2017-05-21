package pojos;

public class Assignment {
	 
	//Need new table called Assignment (AssignmentID, lectureID, FileID, Title, Detail, PostedAT, DueDate)

	
	private int assignmentID;
	private int lectureID;
	private int fileID;
	private String title;
	private String detail;
	private String posterAT;
	private String dueDate;
	
	
	public int getAssignmentID() {
		return assignmentID;
	}
	public int getLectureID() {
		return lectureID;
	}
	public int getFileID() {
		return fileID;
	}
	public String getTitle() {
		return title;
	}
	public String getDetail() {
		return detail;
	}
	public String getPosterAT() {
		return posterAT;
	}
	public String getDueDate() {
		return dueDate;
	}
	
	
	

}
