package interfaceImp;


import database.Database;
import interfaces.AssignmentDao;
import pojos.Assignment;
import pojos.Course;
import pojos.CourseAssignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AssignmentDaoImp extends Database implements AssignmentDao{

    private ArrayList<Assignment> getAssignments(String query){

        ArrayList<Assignment> assignments = new ArrayList<>();

        Assignment assignment = null;

        CourseDaoImp courseDaoImp = new CourseDaoImp();

        Course course = null;

        Connection connection = null;

        try {
            connection = super.getConnection();
            PreparedStatement sqlStatement = connection.prepareStatement(query);
            ResultSet resultSet = sqlStatement.executeQuery();
            while (resultSet.next()){
                int assignmentID = resultSet.getInt("AssignmentID");
                int lectureID = resultSet.getInt("LectureID");
                String filePath = resultSet.getString("filePath");
                String name = resultSet.getString("Name");
                String postedAT = resultSet.getString("PostedAT");
                String dueDate = resultSet.getString("DueDate");
                boolean isSubmitted = resultSet.getBoolean("isSubmitted");

                assignment = new Assignment(assignmentID,lectureID,filePath,name,postedAT,dueDate ,courseDaoImp.getCourseByLectureID(lectureID),isSubmitted);
                assignments.add(assignment);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(connection!= null){
                try {
                    connection.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return assignments;
    }

    public ArrayList<CourseAssignment> getCourseAssignmentByStudentID(int studentID){
        CourseAssignment courseAssignment = null;
        ArrayList<CourseAssignment> courseAssignments = new ArrayList<>();
        Course course = null;
        CourseDaoImp courseDaoImp = new CourseDaoImp();
        ArrayList<Assignment> assignments = this.getAllAssignmentByStudentID(studentID);
        ArrayList<Assignment> tempAssignments = null;
        for(Assignment assignment: assignments){
            course = courseDaoImp.getCourseByLectureID(assignment.getLectureID());
            tempAssignments = this.getAllAssignmentByLectureID(course.getLectureID());
            courseAssignment = new CourseAssignment(course,tempAssignments);
            courseAssignments.add(courseAssignment);
        }
        return courseAssignments;
    }

    @Override
    public ArrayList<Assignment> getAllAssignmentByStudentID(int studentID) {
        String query = "SELECT assign.AssignmentID, assign.LectureID,(SELECT Path FROM File f WHERE assign.AnouncmentID = f.AnnouncementID) AS filePath, assign.Name, assign.PostedAT ,assign.DueDate, assign.isSubmitted  "
                         +   "FROM Assignment assign, CourseOfStudent cos  "
                         +   "WHERE cos.LectureID = assign.LectureID "
                         +   "AND cos.SchoolID = " + studentID;
        ArrayList<Assignment> assignments = this.getAssignments(query);
        return assignments;
    }

    @Override
    public ArrayList<Assignment> getAllAssignmentByLectureID(int LectureID) {
        String query = "SELECT assign.AssignmentID, assign.LectureID,(SELECT Path FROM File f WHERE assign.AnouncmentID = f.AnnouncementID) AS filePath, assign.Name, assign.PostedAT ,assign.DueDate, assign.isSubmitted  "
                +   "FROM Assignment assign, CourseOfStudent cos  "
                +   "WHERE cos.LectureID = assign.LectureID "
                +   "AND cos.LectureID = " + LectureID + " "
                + "Group BY assign.AssignmentID ";
        ArrayList<Assignment> assignments = this.getAssignments(query);
        return assignments;
    }
}










