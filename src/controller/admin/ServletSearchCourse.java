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

import controller.SigninController;
import interfaceImp.CourseDaoImp;
import pojos.CourseDashboard;
import pojos.SimpleCourse;

@WebServlet(name="ServletSearchCourse", urlPatterns= {"/admin/search/course"})
public class ServletSearchCourse extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		HttpSession session = req.getSession();

		CourseDashboard courseDashboard = null;

		if(!SigninController.signinRequired(session, req,resp)){
			return;
		}
		
		
		String courseCode = (String) req.getParameter("course-code");
		
		CourseDaoImp courseDaoImp = new CourseDaoImp();
		
		
		ArrayList<SimpleCourse> courses = courseDaoImp.getCoursesByCodeUsingLike(courseCode);
		JSONObject response = new JSONObject();
		
		
		for (SimpleCourse course : courses) {
			response.put(course.getCode(), course.getName());
		}
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");
		
		PrintWriter printWriter = resp.getWriter();
		
		printWriter.print(response.toString());
		
		
		
		
		
		
	}

}
