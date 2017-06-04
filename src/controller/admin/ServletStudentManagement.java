package controller.admin;

import controller.SecurityController;
import enums.AppPath;
import interfaceImp.CourseDaoImp;
import interfaceImp.StudentDaoImp;
import pojos.Course;
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


/*
 * 
 * Renders students, student courses, add new course for student and remove it
 * 
 * 
 * */

@WebServlet(name = "ServletStudentManagement", urlPatterns = {"/admin/students", "/admin/student/*"})
public class ServletStudentManagement extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        HttpSession session = req.getSession();

    	if(!SecurityController.adminRequired(session, req, resp)){
			return;
		}
		
		String pathInfo = req.getPathInfo();
		StudentDaoImp studentDaoImp = new StudentDaoImp();

		 if(pathInfo != null && pathInfo.contains(AppPath.COURSES)){ ///admin/student/130201004/courses
				String[] path = pathInfo.split("/");
				int schoolID = Integer.parseInt(path[1]); // get id in path
				
				
				
				Student student = studentDaoImp.getStudent(schoolID); // get student
		        ArrayList<Course> studentCourses =studentDaoImp.getStudentCourse(schoolID); // get student courses
		              
		        session.setAttribute("studentCourses", studentCourses);
		        session.setAttribute("student", student);
		       
		        
		        CourseDaoImp courseDaoImp = new CourseDaoImp();
		        
		        ArrayList<Course> availableCourses = courseDaoImp.getAllCoursesNotTakenByStudent(schoolID); // get not taken courses 
		        
		        
		        session.setAttribute("availableCourses", availableCourses);
		        
		        
		        
				session.setAttribute("lastPath", req.getRequestURI());
		        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/bb-student-course-list.jsp");
		        dispatcher.forward(req, resp);
		        return;
			}
		 else if(pathInfo != null && pathInfo.contains(AppPath.DELETE)) { // /admin/student/130201004/delete/18
			 
			 String[] path = pathInfo.split("/");
			 int schoolID = Integer.parseInt(path[1]); // student
			 int lectureID = Integer.parseInt(path[3]); // lecture
			 
			 if (studentDaoImp.deleteStudentCourse(schoolID, lectureID)) { // delete lecture from student courses
				 resp.sendRedirect((String) session.getAttribute("lastPath"));
				 return;
			}	
			 
			 
		 }
		 else if(pathInfo != null && pathInfo.contains(AppPath.ADD)) { // /admin/student/130201004/add/17
			 
			 String[] path = pathInfo.split("/");
			 int schoolID = Integer.parseInt(path[1]);
			 int lectureID = Integer.parseInt(path[3]);
			 
			 if (studentDaoImp.addStudentCourse(schoolID, lectureID)) { // add course to student courses
				 resp.sendRedirect((String) session.getAttribute("lastPath")); 
				 return;
			}
			 
		 }
		 
		 else { // /admin/students
			 session.setAttribute("lastPath", req.getRequestURI());
			 ArrayList<Student> students =studentDaoImp.getAllStudents();
		     session.setAttribute("students",students);
		     
		     RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/bb-student-management.jsp");
		     dispatcher.forward(req, resp);
		     return;
			 
		 }
	        
		
		
		
    	


    }
}
