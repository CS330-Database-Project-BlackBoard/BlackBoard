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

@WebServlet(name="ServletStudentDashboard", urlPatterns= {"/student/dashboard"})
public class ServletStudentDashboard extends HttpServlet{
	
	 /* TODO
	  * student required (already in ScurityController)
	  * get anouncments according to schoolID -> AnouncmentDaoImp -> write new function for getting by schoolID for student where the anounments are posted 
	  * for student registered lecture
	  *	
	  *get courses according to schoolID -> StudentDaoImp -> getStudentCourse(int schoolID)
	  * add the courses and anouncments to session
	  * dispatcher -> /student/index.jsp
	  * 
	  * 
	  * 
	  * 
	  * */
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User user = null;
		HttpSession session = req.getSession();
		
		if (!SecurityController.studentRequired(session, req, resp)) {
			return;
		}
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/student/index.jsp");
		dispatcher.forward(req, resp);
	
	}
	

}
