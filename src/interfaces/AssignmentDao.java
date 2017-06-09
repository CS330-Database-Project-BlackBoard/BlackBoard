package interfaces;

import pojos.Assignment;
import pojos.CourseAssignment;
import pojos.SimpleFile;

import java.util.ArrayList;

public interface AssignmentDao {
    
	
    public ArrayList<CourseAssignment> getCourseAssignmentByStudentID(int studentID);

	public ArrayList<Assignment> getAllAssignmentByStudentID(int studentID);
	
    public ArrayList<Assignment> getAllAssignmentByLectureID(int courseID,int studentID);
    
    public boolean isSubmitted(int assignmentID,int studentID);
    
    public boolean saveAssignmentofStudent(SimpleFile file, int schoolID, int lectureID ,int assignmentID, int announcementID);

}
