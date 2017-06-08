package interfaces;

import pojos.Assignment;

import java.util.ArrayList;

public interface AssignmentDao {
    public ArrayList<Assignment> getAllAssignmentByStudentID(int studentID);
    public ArrayList<Assignment> getAllAssignmentByLectureID(int courseID,int studentID);
}
