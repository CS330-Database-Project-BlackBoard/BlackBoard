package controller.student;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.SecurityController;
import interfaceImp.StudentDaoImp;
import pojos.StudentCourseGrade;
import pojos.User;


@WebServlet(name="ServletStudentGrade", urlPatterns= {"/student/grades"})
public class ServletStudentGrade extends HttpServlet {
	
	/*
	 * create new function in StudentDao, called -> getStudentGrades(int schoolID) -> returns Arraylist<StudentCourseGrade(already in pojos, see the class to determine select query)>  
	 * add to session the returned data
	 * 
	 * 
	 * */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		User user = null;
		HttpSession session = req.getSession();
		
		if (!SecurityController.studentRequired(session, req, resp)) {
			return;
		}
		try {
			user = (User)session.getAttribute("user");
			
			StudentDaoImp studentDaoImp = new StudentDaoImp();
			
			ArrayList<StudentCourseGrade> studentCourseGrades = studentDaoImp.getStudentCourseGrades(user.getSchoolID());
			
			
			session.setAttribute("studentCourseGrades", studentCourseGrades);
			
		}
		catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect((String)session.getAttribute("lastPath"));
			return;
		}
		
		session.setAttribute("lastPath", req.getRequestURI());
		RequestDispatcher dispatcher = req.getRequestDispatcher("/student/grades.jsp");
		dispatcher.forward(req, resp);
	}

}
