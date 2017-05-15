package pojos;

import java.util.ArrayList;

public class LectureDashboard {
	
	
		private Course course;
		private int lectureID;
		private ArrayList<Anouncment> anouncments;
		private int enrolledStudentCount = 0;
		private int gradeCount = 0;
		
		public LectureDashboard(Course course, int lectureID, ArrayList<Anouncment> anouncments, int enrolledStudentCount, int gradeCount) {
			this.course = course;
			this.lectureID = lectureID;
			this.anouncments = anouncments;
			this.enrolledStudentCount = enrolledStudentCount;
			this.gradeCount = gradeCount;
		}
		
		public int getLectureID() {
			return lectureID;
		}
		public ArrayList<Anouncment> getAnouncments() {
			return anouncments;
		}
		public int getEnrolledStudentCount() {
			return enrolledStudentCount;
		}
		public int getGradeCount() {
			return gradeCount;
		}

		public Course getCourse() {
			return course;
		}
		
		
		
		
		
		
		
		

}
