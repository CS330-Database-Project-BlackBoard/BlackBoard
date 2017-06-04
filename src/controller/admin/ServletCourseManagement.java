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
import enums.AppForm;
import interfaceImp.CourseDaoImp;
import interfaceImp.CourseDashboardDaoImp;
import pojos.CourseDashboard;
import pojos.User;

/*
 * This servlet helps to manage courses
 * 
 * */

@WebServlet(name="ServletCourseManagement", urlPatterns= {"/admin/courses"})
public class ServletCourseManagement extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		CourseDashboard courseDashboard = null;

		if(!SecurityController.adminRequired(session, req, resp)){
			return;
		}
		
		
		CourseDashboardDaoImp courseDashboardDaoImp = new CourseDashboardDaoImp();
		
		courseDashboard = courseDashboardDaoImp.getCourseDashboard(); // get dashboard which contains courses, 
		
		session.setAttribute("courseDashboard", courseDashboard); // 
		
		session.setAttribute("lastPath", req.getRequestURI());
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/bb-course-management.jsp");// render course page
		requestDispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// runs when form is posted, (when adding new course)
		
		User user = null;
		HttpSession session = req.getSession();
		CourseDashboard courseDashboard = null;
		
		if(!SecurityController.signinRequired(session, req,resp) && !SecurityController.adminRequired(session, req, resp)){
			return;
		}
		
		
		CourseDaoImp courseDaoImp = new CourseDaoImp();
		
		// get form datas
		String code = (String) req.getParameter(AppForm.COURSE_CODE);
		String lecture = (String) req.getParameter(AppForm.COURSE_LECTURE);
		String lecturerEmail = (String) req.getParameter(AppForm.LECTURER_EMAIL);

		boolean result = courseDaoImp.addNewCourse(code.toUpperCase(), lecture.toUpperCase(), lecturerEmail.toLowerCase()); // add to database
		
		/*
		String message = "";
		if (result) {
			message = "Course is added";
		}
		else {
			message = "Course is not added";
		}
		*/
		
		
		resp.sendRedirect(req.getContextPath() + "/admin/courses"); // update page
		
	}

}
