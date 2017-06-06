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
import interfaceImp.CourseDaoImp;
import pojos.Course;
import pojos.Lecturer;
import pojos.User;

@WebServlet(name="ServletLecturerCourses", urlPatterns= {"/lecturer/courses"})
public class ServletLecturerCourses extends HttpServlet{
	
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

			CourseDaoImp courseDaoImp = new CourseDaoImp();

			ArrayList<Course> courses = courseDaoImp.getCoursesByLecturerID(lecturer.getSchoolID());

			session.setAttribute("courseInformation", courses);

			session.setAttribute("lastPath", req.getRequestURI());


		}
		catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect((String) session.getAttribute("lastPath"));
			return;
		}

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/lecturer/courses.jsp");
		requestDispatcher.forward(req, resp);
		
	
		
	}
	
}
