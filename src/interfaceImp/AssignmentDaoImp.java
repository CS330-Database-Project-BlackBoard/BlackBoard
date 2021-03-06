package interfaceImp;


import database.Database;
import helper.TimeZone;
import interfaces.AssignmentDao;
import pojos.Assignment;
import pojos.Course;
import pojos.CourseAssignment;
import pojos.SimpleFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AssignmentDaoImp extends Database implements AssignmentDao{
	
    private ArrayList<Assignment> getAssignments(String query,int studentID){

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
                int announcementID = resultSet.getInt("AnnouncementID");
                int lectureID = resultSet.getInt("LectureID");
                String filePath = resultSet.getString("filePath");
                String name = resultSet.getString("Name");
                String postedAT = resultSet.getString("PostedAT");
                String dueDate = resultSet.getString("DueDate");

                assignment = new Assignment(assignmentID,lectureID,filePath,name,postedAT,dueDate ,courseDaoImp.getCourseByLectureID(lectureID),this.isSubmitted(assignmentID,studentID), announcementID);
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
    
    @Override
    public ArrayList<CourseAssignment> getCourseAssignmentByStudentID(int studentID){
        CourseAssignment courseAssignment = null;
        ArrayList<CourseAssignment> courseAssignments = new ArrayList<>();
        Course course = null;
        CourseDaoImp courseDaoImp = new CourseDaoImp();
        ArrayList<Assignment> assignments = this.getAllAssignmentByStudentID(studentID);
        ArrayList<Assignment> tempAssignments = null;
        for(Assignment assignment: assignments){
            course = courseDaoImp.getCourseByLectureID(assignment.getLectureID());
            tempAssignments = this.getAllAssignmentByLectureID(course.getLectureID(),studentID);
            courseAssignment = new CourseAssignment(course,tempAssignments);
            courseAssignments.add(courseAssignment);
        }
        return courseAssignments;
    }

    @Override
    public ArrayList<Assignment> getAllAssignmentByStudentID(int studentID) {
        String query = "SELECT assign.AssignmentID,assign.AnnouncementID, assign.LectureID,(SELECT Path FROM File f WHERE assign.AnnouncementID = f.AnnouncementID) AS filePath, assign.Name, assign.PostedAT ,assign.DueDate  "
                         +   "FROM Assignment assign, CourseOfStudent cos  "
                         +   "WHERE cos.LectureID = assign.LectureID "
                         +   "AND cos.SchoolID = " + studentID;
        ArrayList<Assignment> assignments = this.getAssignments(query,studentID);
        return assignments;
    }

    @Override
    public ArrayList<Assignment> getAllAssignmentByLectureID(int LectureID,int studentID) {
        String query = "SELECT assign.AssignmentID, assign.AnnouncementID, assign.LectureID,(SELECT Path FROM File f WHERE assign.AnnouncementID = f.AnnouncementID) AS filePath, assign.Name, assign.PostedAT ,assign.DueDate  "
                +   "FROM Assignment assign, CourseOfStudent cos  "
                +   "WHERE cos.LectureID = assign.LectureID "
                +   "AND cos.LectureID = " + LectureID + " "
                + "Group BY assign.AssignmentID ";
        ArrayList<Assignment> assignments = this.getAssignments(query,studentID);
        return assignments;
    }

    public boolean isSubmitted(int assignmentID,int studentID){
        String query = "SELECT isSubmitted FROM AssignmentOwner WHERE studentID = " + studentID + " AND AssignmentID = " + assignmentID ;
        boolean isSubmitted = false;
        Connection connection = null;

        try {
            connection = super.getConnection();
            PreparedStatement sqlStatement = connection.prepareStatement(query);
            ResultSet resultSet = sqlStatement.executeQuery();
            while (resultSet.next()){
                isSubmitted = resultSet.getBoolean("isSubmitted");
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
        return isSubmitted;
    }

    
    
    
    public boolean saveAssignmentofStudent(SimpleFile file, int schoolID, int lectureID ,int assignmentID, int announcementID){
    	
    	CourseDaoImp courseDaoImp = new CourseDaoImp();
    	
    	courseDaoImp.saveFile(file, schoolID, lectureID, announcementID);
    	
    	
        String query = "INSERT INTO AssignmentOwner(AssignmentID, StudentID, isSubmitted) VALUES(?,?, 1)";

        

        Connection connection = null;

        try {
            connection = super.getConnection();
            PreparedStatement sqlStatement = connection.prepareStatement(query);
            sqlStatement.setInt(1, assignmentID);
            sqlStatement.setInt(2, schoolID);
            sqlStatement.executeUpdate();
            


        }catch (Exception e){
            e.printStackTrace();
            return false;
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
        return true;
    }






}










