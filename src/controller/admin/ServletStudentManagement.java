package controller.admin;

import controller.SecurityController;
import enums.AppPath;
import interfaceImp.CourseDaoImp;
import interfaceImp.StudentDaoImp;
import pojos.Course;
import pojos.SimpleCourse;
import pojos.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


@WebServlet(name = "ServletStudentManagement", urlPatterns = {"/admin/students", "/admin/student/*"})
public class ServletStudentManagement extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        HttpSession session = req.getSession();

    	if(!SecurityController.adminRequired(session, req, resp)){
			return;
		}
		
		String pathInfo = req.getPathInfo();
		StudentDaoImp studentDaoImp = new StudentDaoImp();

		 if(pathInfo != null && pathInfo.contains(AppPath.COURSES)){
				String[] path = pathInfo.split("/");
				int schoolID = Integer.parseInt(path[1]);
				
				
				
				Student student = studentDaoImp.getStudent(schoolID);
		        ArrayList<Course> studentCourses =studentDaoImp.getStudentCourse(schoolID);
		              
		        session.setAttribute("studentCourses", studentCourses);
		        session.setAttribute("student", student);
		       
		        
		        CourseDaoImp courseDaoImp = new CourseDaoImp();
		        
		        ArrayList<Course> availableCourses = courseDaoImp.getAllCoursesNotTakenByStudent(schoolID);
		        
		        
		        session.setAttribute("availableCourses", availableCourses);
		        
		        
		        
				session.setAttribute("lastPath", req.getRequestURI());
		        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/bb-student-course-list.jsp");
		        dispatcher.forward(req, resp);
		        return;
			}
		 else if(pathInfo != null && pathInfo.contains(AppPath.DELETE)) {
			 String[] path = pathInfo.split("/");
			 int schoolID = Integer.parseInt(path[1]);
			 int lectureID = Integer.parseInt(path[3]);
			 
			 if (studentDaoImp.deleteStudentCourse(schoolID, lectureID)) {
				 resp.sendRedirect((String) session.getAttribute("lastPath"));
				 return;
			}	
			 
			 
		 }
		 else if(pathInfo != null && pathInfo.contains(AppPath.ADD)) {
			 
			 String[] path = pathInfo.split("/");
			 int schoolID = Integer.parseInt(path[1]);
			 int lectureID = Integer.parseInt(path[3]);
			 
			 if (studentDaoImp.addStudentCourse(schoolID, lectureID)) {
				 resp.sendRedirect((String) session.getAttribute("lastPath"));
				 return;
			}
			 
		 }
		 
		 else {
			 session.setAttribute("lastPath", req.getRequestURI());
			 ArrayList<Student> students =studentDaoImp.getAllStudents();
		     session.setAttribute("students",students);
		     
		     RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/bb-student-management.jsp");
		     dispatcher.forward(req, resp);
		     return;
			 
		 }
	        
		
		
		
    	


    }
}
