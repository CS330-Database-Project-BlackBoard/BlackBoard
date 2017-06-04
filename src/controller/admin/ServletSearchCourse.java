package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import controller.SecurityController;
import enums.AppForm;
import interfaceImp.CourseDaoImp;
import pojos.CourseDashboard;
import pojos.SimpleCourse;

@WebServlet(name="ServletSearchCourse", urlPatterns= {"/admin/search/course"})
public class ServletSearchCourse extends HttpServlet{
	
	/* Search Course
	 * This servlet renders json for front end
	 * Jquert will send post request with course code parameter and servlet will return courses
	 * */
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		HttpSession session = req.getSession();

		CourseDashboard courseDashboard = null;

		if(!SecurityController.adminRequired(session, req, resp)){
			return;
		}
		
		
		
		
		String courseCode = (String) req.getParameter(AppForm.COURSE_CODE);
		
		CourseDaoImp courseDaoImp = new CourseDaoImp();
		
		
		ArrayList<SimpleCourse> courses = courseDaoImp.getCoursesByCodeUsingLike(courseCode); // get courses
		JSONObject response = new JSONObject();
		
		
		for (SimpleCourse course : courses) {
			response.put(course.getCode(), course.getName()); // put courses in json object 
		}
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");
		
		PrintWriter printWriter = resp.getWriter();
		
		printWriter.print(response.toString());  // write json 
		
		
		
		
		
		
	}

}
