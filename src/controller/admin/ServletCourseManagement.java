package controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.SignInController;
import interfaceImp.CourseDashboardDaoImp;
import pojos.CourseDashboard;
import pojos.User;


@WebServlet(name="ServletCourseManagement", urlPatterns= {"/admin/courses"})
public class ServletCourseManagement extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User user = null;
		HttpSession session = req.getSession();
		CourseDashboard courseDashboard = null;
		
		try {
			user = (User) session.getAttribute("user");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(user != null){
				SignInController.isSignedIn(user, resp);
				
			}
		}
		
		CourseDashboardDaoImp courseDashboardDaoImp = new CourseDashboardDaoImp();
		courseDashboard = courseDashboardDaoImp.getCourseDashboard();
		
		session.setAttribute("courseDashboard", courseDashboard);
		
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/bb-course-management.jsp");
		requestDispatcher.forward(req, resp);
		
	}

}
