package pojos;

import java.util.ArrayList;

public class LectureDashboard {
	
	
		private Course course;
		private int lectureID;
		private ArrayList<Announcement> announcements;
		private int enrolledStudentCount = 0;
		private int gradeCount = 0;
		
		public LectureDashboard(Course course, int lectureID, ArrayList<Announcement> anouncments, int enrolledStudentCount, int gradeCount) {
			this.course = course;
			this.lectureID = lectureID;
			this.announcements = anouncments;
			this.enrolledStudentCount = enrolledStudentCount;
			this.gradeCount = gradeCount;
		}
		
		public int getLectureID() {
			return lectureID;
		}
		public ArrayList<Announcement> getAnnouncements() {
			return announcements;
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
