package controller.lecturer;

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
import interfaceImp.LecturerDaoImp;
import pojos.Lecturer;
import pojos.LecturerCourseGrade;
import pojos.User;


@WebServlet(name="ServletLecturerGrades", urlPatterns = {"/lecturer/grades"})
public class ServletLecturerGrades extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		User user = null;
		
		if (!SecurityController.lecturerRequired(session, req, resp)) {
			return;
		}
		try {
			user = (User) session.getAttribute("user");
			
			
			Lecturer lecturer = new Lecturer(user.getSchoolID(), user.getEmail(), user.getName(), user.getSurname(), user.getRole());
			
			
			LecturerDaoImp lecturerDaoImp = new LecturerDaoImp();
			
			ArrayList<LecturerCourseGrade> courseGradesOfLecturer = lecturerDaoImp.getCourseGradesOfLecturer(lecturer);
			
			session.setAttribute("courseGradesOfLecturer", courseGradesOfLecturer);
			
			session.setAttribute("lastPath", req.getRequestURI());
			
	
			
		}
		catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect((String) session.getAttribute("lastPath"));
			return;
		}
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/lecturer/grades.jsp");
		requestDispatcher.forward(req, resp);
	
	}
	

}
