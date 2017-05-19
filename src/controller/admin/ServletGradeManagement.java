package controller.admin;

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
import pojos.LectureDashboard;
import pojos.Student;
import pojos.StudentGrade;


@WebServlet(name="ServletGradeManagement", urlPatterns= {"/admin/grade/*"})
public class ServletGradeManagement extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		if(!SecurityController.adminRequired(session, req, resp)){
			return;
		}
		
		
		
		String pathInfo = req.getPathInfo();
		System.out.println(pathInfo);
		try {
			if (pathInfo.contains(AppPath.LECTURE) && pathInfo.contains(AppPath.STUDENT)) {
				
				String[] url = req.getPathInfo().split("/");
				int lectureID = Integer.parseInt(url[2]);
				int schoolID = Integer.parseInt(url[4]);
				
				StudentDaoImp studentDaoImp = new StudentDaoImp();
				CourseDaoImp courseDaoImp = new CourseDaoImp();
				
				
				Student student = studentDaoImp.getStudent(schoolID);
				ArrayList<StudentGrade> lectureStudentGrades = studentDaoImp.getStudentGradesByLecture(schoolID, lectureID); 
				LectureDashboard lectureDashboard = courseDaoImp.getLectureDashboard(lectureID);
				
				
				session.setAttribute("student", student);
				session.setAttribute("lectureStudentGrades", lectureStudentGrades);
				session.setAttribute("lectureDashboard", lectureDashboard);
				
				
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/bb-student-course-grade.jsp");
				requestDispatcher.forward(req, resp);
				return;
			} 
			else if(pathInfo.contains(AppPath.LECTURE) && pathInfo.contains(AppPath.GRADES)) {
				
				
			}
			
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect((String) session.getAttribute("lastPath"));
			return;
		}
		
		
		
		
	}
	
}
