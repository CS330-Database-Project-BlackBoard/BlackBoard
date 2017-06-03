package controller.lecturer;

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
import interfaceImp.CourseDaoImp;
import interfaceImp.LecturerDaoImp;
import interfaceImp.StudentDaoImp;
import pojos.Course;
import pojos.Lecturer;
import pojos.LecturerCourseGrade;
import pojos.Student;
import pojos.User;

@WebServlet(name = "ServletLecturerNewGrade", urlPatterns = {"/lecturer/new-grade/*"})
public class ServletLecturerNewGrade extends HttpServlet {
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
			
		
			
			String path = req.getPathInfo();
			String[] paths = path.split("/");
			System.out.println(Arrays.toString(paths));
			if(path.contains(AppPath.LECTURE)) {
				
				int lectureID = Integer.parseInt(paths[2]);
				
				CourseDaoImp courseDaoImp = new CourseDaoImp();
				StudentDaoImp studentDaoImp = new StudentDaoImp();
				
				ArrayList<Student> students = studentDaoImp.getStudentsByLectureID(lectureID);
				Course course = courseDaoImp.getCourseByLectureID(lectureID);
				
				
				session.setAttribute("students", students);
				session.setAttribute("course", course);
			}
			
			
					
		}
		catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect((String) session.getAttribute("lastPath"));
			return;
		}

		session.setAttribute("lastPath", req.getRequestURI());
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/lecturer/new-grade.jsp");
		requestDispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = null;
		
		if (!SecurityController.lecturerRequired(session, req, resp)) {
			return;
		}
		
		try {
			
			user = (User) session.getAttribute("user");
			Lecturer lecturer = new Lecturer(user.getSchoolID(), user.getEmail(), user.getName(), user.getSurname(), user.getRole());
			
		
			
			String path = req.getPathInfo();
			String[] paths = path.split("/");
			System.out.println(Arrays.toString(paths));
			
			if(path.contains(AppPath.LECTURE)) {
				
				int lectureID = Integer.parseInt(paths[2]);
				
				StudentDaoImp studentDaoImp = new StudentDaoImp();
				
				// insert grades
			}
			
			
				
		}
		catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect((String) session.getAttribute("lastPath"));
			return;
		}

		resp.sendRedirect("/lecturer/grades");
	}

}
