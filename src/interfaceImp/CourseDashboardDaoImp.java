package interfaceImp;


import java.util.ArrayList;

import interfaces.CourseDashboardDao;
import pojos.Course;
import pojos.CourseDashboard;

public class CourseDashboardDaoImp implements CourseDashboardDao{

	
	
	@Override
	public CourseDashboard getCourseDashboard() {
		
		CourseDashboard courseDashboard = null;
		
		CourseDaoImp courseDaoImp = new CourseDaoImp();
		
		int activeCourseCount = 0;
		int inactiveCourseCount = 0;
		
		ArrayList<Course> allCourses = courseDaoImp.getAllCourses();
		ArrayList<Course> visibleCourses = new ArrayList<>();

		
		
		for (Course course : allCourses) {
			
			if(course.isVisible()) {
				activeCourseCount++;
				visibleCourses.add(course);
			}
			else {
				inactiveCourseCount++;
			}
			
		}
		
		courseDashboard = new CourseDashboard(activeCourseCount, inactiveCourseCount, visibleCourses);

		return courseDashboard;
		
	}
	
	
	
	
	

}
