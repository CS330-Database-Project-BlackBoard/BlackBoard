package controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.SecurityController;
import interfaceImp.CourseDaoImp;
import interfaceImp.CourseDashboardDaoImp;
import pojos.CourseDashboard;
import pojos.User;


@WebServlet(name="ServletCourseManagement", urlPatterns= {"/admin/courses"})
public class ServletCourseManagement extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		CourseDashboard courseDashboard = null;


		if(!SecurityController.signinRequired(session, req,resp) && !SecurityController.adminRequired(session, req, resp)){
			return;
		}
		
		CourseDashboardDaoImp courseDashboardDaoImp = new CourseDashboardDaoImp();
		courseDashboard = courseDashboardDaoImp.getCourseDashboard();
		
		session.setAttribute("courseDashboard", courseDashboard);
		
		session.setAttribute("lastPath", req.getRequestURI());
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/bb-course-management.jsp");
		requestDispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("here");
		User user = null;
		HttpSession session = req.getSession();
		CourseDashboard courseDashboard = null;
		
		if(!SecurityController.signinRequired(session, req,resp) && !SecurityController.adminRequired(session, req, resp)){
			return;
		}
		
		
		CourseDaoImp courseDaoImp = new CourseDaoImp();
		
		
		String code = (String) req.getParameter("course-code");
		String lecture = (String) req.getParameter("course-lecture");
		String lecturerEmail = (String) req.getParameter("lecturer-email");
		System.out.println(String.format("%s %s %s", code, lecture, lecturerEmail));
		boolean result = courseDaoImp.addNewCourse(code.toUpperCase(), lecture.toUpperCase(), lecturerEmail.toLowerCase());
		System.out.println("new course is added: " + result);

		String message = "";
		if (result) {
			message = "Course is added";
		}
		else {
			message = "Course is not added";
		}
		
		
		resp.sendRedirect(req.getContextPath() + "/admin/courses");
		
	}

}
