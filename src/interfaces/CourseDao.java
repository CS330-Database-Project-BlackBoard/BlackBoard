package interfaces;

import java.util.ArrayList;

import pojos.Course;

public interface CourseDao {
	
	public ArrayList<Course> getAllCourses();
	
	public ArrayList<Course> getCoursesByLecturerID(int schoolID);
	
	public Course getCourseByCourseID(int courseID);
	
	public Course getCourseByLectureID(int lectureID);
	
	public ArrayList<Course> getAllVisibleCourses();
	
	public ArrayList<Course> getAllInVisibleCourses();
	
	public ArrayList<Course> getCourseByStudentID(int schoolID);
	
	public ArrayList<Course> getCourseByDepartmentID(int departmentID);
	
	public ArrayList<Course> getCoursesByCode(String courseCode);

	public ArrayList<Course> getCoursesByCodeUsingLike(String courseCode);
}
