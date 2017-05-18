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


@WebServlet(name="ServletLecturerCourseDashboard", urlPatterns= {"/admin/lecture/*"})
public class ServletLectureManagement  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		HttpSession session = req.getSession();
		LectureDashboard lectureDashboard = null;

		if(!SecurityController.signinRequired(session, req,resp) && !SecurityController.adminRequired(session, req, resp)){
			return;
		}
		
		
		try {
			
			String pathInfo = req.getPathInfo();
			String[] path = req.getPathInfo().split("/");
			int lectureID = Integer.parseInt(path[1]);
			
			if (pathInfo.contains(AppPath.GRADES)) {
				
				CourseDaoImp courseDaoImp = new CourseDaoImp();
				LectureDetail courseGradeDetail = courseDaoImp.getLectureDetail(lectureID);

				session.setAttribute("lectureCourseGradeDetail", courseGradeDetail);
				session.setAttribute("lastPath", req.getRequestURI());
				
				
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/bb-course-grades.jsp");
				requestDispatcher.forward(req, resp);
				return;
				
			}
			else if(pathInfo.contains(AppPath.STUDENTS)) {
				
					StudentDaoImp studentDaoImp = new StudentDaoImp();
					ArrayList<Student> lectureStudents = studentDaoImp.getStudentsByLectureID(lectureID);
					
					session.setAttribute("lectureStudents", lectureStudents);
					session.setAttribute("lastPath", req.getRequestURI());

					RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/bb-course-students.jsp");
					requestDispatcher.forward(req, resp);
					return;
			}
			else {
				
				CourseDaoImp courseDaoImp = new CourseDaoImp();
				lectureDashboard = courseDaoImp.getLectureDashboard(lectureID);
				
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect((String)session.getAttribute("lastPath"));
			return;
		}
		
		session.setAttribute("lectureDashboard", lectureDashboard);
		session.setAttribute("lastPath", req.getRequestURI());
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/bb-course-detail.jsp");
		requestDispatcher.forward(req, resp);
	}

}
