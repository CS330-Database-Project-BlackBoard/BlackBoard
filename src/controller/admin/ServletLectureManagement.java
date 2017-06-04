package controller.admin;

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
import enums.AppPath;
import interfaceImp.CourseDaoImp;
import interfaceImp.StudentDaoImp;
import pojos.LectureDetail;
import pojos.Student;
import pojos.LectureDashboard;


/*
 * This servlet helps to manage course lectures 
 * 
 * */

@WebServlet(name="ServletLecturerCourseDashboard", urlPatterns= {"/admin/lecture/*"})
public class ServletLectureManagement  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		HttpSession session = req.getSession();
		LectureDashboard lectureDashboard = null;
		
		if(!SecurityController.adminRequired(session, req, resp)){
			return;
		}
		
		
		
		try {
			
			String pathInfo = req.getPathInfo(); // get path
			String[] path = req.getPathInfo().split("/");
			int lectureID = Integer.parseInt(path[1]);
			
			
			if (pathInfo.contains(AppPath.GRADES)) { // /admin/lecture/13/grades
				
				CourseDaoImp courseDaoImp = new CourseDaoImp();
				LectureDetail courseGradeDetail = courseDaoImp.getLectureDetail(lectureID); // get lecture detail object that contains Course and CourseGrades for viewing

				session.setAttribute("lectureCourseGradeDetail", courseGradeDetail); // put the session
				session.setAttribute("lastPath", req.getRequestURI());
				
				
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/bb-course-grades.jsp"); // render
				requestDispatcher.forward(req, resp);
				return;
				
			}
			else if(pathInfo.contains(AppPath.STUDENTS)) { // /admin/lecture/13/students
					
				
					StudentDaoImp studentDaoImp = new StudentDaoImp();
					ArrayList<Student> lectureStudents = studentDaoImp.getStudentsByLectureID(lectureID); // get Student object, contains student detail and average of std
					
					session.setAttribute("lectureStudents", lectureStudents);
					session.setAttribute("lastPath", req.getRequestURI());

					RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/bb-course-students.jsp");
					requestDispatcher.forward(req, resp);
					return;
			}
			else { // /admin/lecture/13/dashboard
				
				CourseDaoImp courseDaoImp = new CourseDaoImp();
				lectureDashboard = courseDaoImp.getLectureDashboard(lectureID); // get lecture dashboad, contains grade count, student count and, anouncment
				
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect((String)session.getAttribute("lastPath"));
			return;
		}
		
		session.setAttribute("lectureDashboard", lectureDashboard); // put dashboard object to session
		session.setAttribute("lastPath", req.getRequestURI());
		// render the releted page
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/bb-course-detail.jsp");
		requestDispatcher.forward(req, resp);
	}

}
