package interfaces;

import java.util.ArrayList;

import pojos.Course;
import pojos.CourseMaterial;
import pojos.File;
import pojos.LectureDetail;
import pojos.LectureDashboard;
import pojos.SimpleCourse;
import pojos.SimpleFile;
import pojos.SimpleGrade;
import pojos.StudentGradeView;

public interface CourseDao {
	
	public ArrayList<Course> getAllCourses();
	
	public ArrayList<Course> getCoursesByLecturerID(int schoolID);
	
	public Course getCourseByCourseID(int courseID);
	
	public Course getCourseByLectureID(int lectureID);
	
	public ArrayList<Course> getAllVisibleCourses();
	
	public ArrayList<Course> getAllInVisibleCourses();
	
	public ArrayList<Course> getCourseByStudentID(int schoolID);
	
	

	public ArrayList<SimpleCourse> getCoursesByCodeUsingLike(String courseCode);
	
	public boolean addNewCourse(String code, String lecture, String lecturerEmail);
	
	public LectureDashboard getLectureDashboard(int lectureID);

	public ArrayList<SimpleGrade> getLectureGrades(int lectureID);
	
	public ArrayList<StudentGradeView> getStudentListofGradeByGradeID(int gradeID);
	
	public LectureDetail getLectureDetail(int lectureID);
	
	public ArrayList<Course> getAllCoursesNotTakenByStudent(int schoolID);

	public SimpleGrade getGradeName(int lectureID, int gradeID);

	public ArrayList<File> getFilesByLectureID(int lectureID);
	
	public boolean saveFile(SimpleFile file, int schoolID, int lectureID, int announcementID);

	
	public boolean saveCourseMaterial(SimpleFile file, int schoolID, int lectureID, String title, String content);

	
}
