package controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.SecurityController;
import enums.AppPath;
import interfaceImp.LecturerDaoImp;
import pojos.CourseOfLecturer;
import pojos.Lecturer;
import pojos.User;



/*
 * This servlet renders course of lecturer
 * */

@WebServlet(name="ServletLecturer", urlPatterns= {"/admin/lecturer/*"})
public class ServletLecturerCourses extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();


		User user = null;
		
		if(!SecurityController.adminRequired(session, req, resp)){
			return;
		}
			
		
		try {
			
			String pathInfo = req.getPathInfo();
			String[] path = pathInfo.split("/");
			
			int lecturerID = Integer.parseInt(path[1]); // get lecturer id from path
			
	
			
			
			
			LecturerDaoImp lecturerDaoImp = new LecturerDaoImp();
			
			Lecturer lecturer = lecturerDaoImp.getLecturerBySchooID(lecturerID); // get lecturer object
			
			if(lecturer == null) {
				throw new Exception("Lecturer is not found");
			}
			
			
			ArrayList<CourseOfLecturer> coursesOfLecturer = lecturerDaoImp.getCoursesOfLecturer(lecturer); // get course of lecturer
			
			session.setAttribute("lecturer", lecturer); // put to session
			session.setAttribute("coursesOfLecturer", coursesOfLecturer);
		
			
		}
		catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect((String)session.getAttribute("lastPath"));
			resp.sendRedirect(req.getContextPath() + "/admin/lecturer"); 
			return;
		}
		
		
	
		session.setAttribute("lastPath", req.getRequestURI());
		// render
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/bb-lecturer-management-course-list.jsp");
		requestDispatcher.forward(req, resp);
		
	}
	
}