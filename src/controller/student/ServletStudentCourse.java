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
import pojos.StudentCourse;
import pojos.User;

@WebServlet(name="ServletStudentCourse", urlPatterns= {"/student/courses"})
public class ServletStudentCourse extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		User user = null;
		HttpSession session = req.getSession();
		
		if (!SecurityController.studentRequired(session, req, resp)) {
			return;
		}

		try{
			user = (User) session.getAttribute("user");
			StudentDaoImp studentDaoImp = new StudentDaoImp();
			ArrayList<StudentCourse> studentCourses = studentDaoImp.getStudentCourseAndClassMates(user.getSchoolID());

			session.setAttribute("studentCourses",studentCourses);

		}catch (Exception e){
			e.printStackTrace();
			resp.sendRedirect((String)session.getAttribute("lastPath"));
			return;
		}

		session.setAttribute("lastPath", req.getRequestURI());
		RequestDispatcher dispatcher = req.getRequestDispatcher("/student/courses.jsp");
		dispatcher.forward(req, resp);
	}
}

