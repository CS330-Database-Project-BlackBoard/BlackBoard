package controller.lecturer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.SecurityController;

@WebServlet(name="ServletLecturerCourses", urlPatterns= {"/lecturer/courses"})
public class ServletLecturerCourses extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession session = req.getSession();
		
		if (!SecurityController.lecturerRequired(session, req, resp)) {
			return;
		}
		try {
			
			
			
			session.setAttribute("lastPath", req.getRequestURI());
			
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/lecturer/courses.jsp");
			requestDispatcher.forward(req, resp);
			return;
			
		}
		catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect((String) session.getAttribute("lastPath"));
		}
		
	
		
	}
	
}
