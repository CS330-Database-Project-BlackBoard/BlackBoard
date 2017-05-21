package controller.student;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.SecurityController;
import pojos.User;


@WebServlet(name="ServletStudentAssignment", urlPatterns= {"/student/assignments"})
public class ServletStudentAssignment extends HttpServlet{
	
	/*
	 * Need new table called Assignment (AssignmentID, lectureID, FileID, Title, Detail, PostedAT, DueDate)
	 * 
	 * need add new function CourseDao ->  getCourseAssingments(int lectureID) get the assignment according to lectureID return arraylist<Anouncment(already in pojos)>
	 * need new function StudentDao -> getSubmittedAssigment(int schoolID) return arraylist<AssignmentStd(already in pojos)>
	 * 
	 * ! design should be change
	 * 
	 * add returned arraylists to session
	 * dispatcher -> /student/assignment.jsp
	 * */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User user = null;
		HttpSession session = req.getSession();
		
		if (!SecurityController.studentRequired(session, req, resp)) {
			return;
		}
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/student/assignments.jsp");
		dispatcher.forward(req, resp);
	
	}
	
}
