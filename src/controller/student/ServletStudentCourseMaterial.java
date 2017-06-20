package controller.student;

import controller.SecurityController;
import interfaceImp.LecturerDaoImp;
import interfaceImp.StudentDaoImp;
import pojos.CourseMaterial;
import pojos.Lecturer;
import pojos.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet(name="ServletStudentCourseMaterial", urlPatterns= {"/student/course-materials"})
public class ServletStudentCourseMaterial extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



		HttpSession session = req.getSession();
		
		if (!SecurityController.studentRequired(session, req, resp)) {
			return;
		}

		try {

			
			
			User user = (User) session.getAttribute("user");

			StudentDaoImp studentDaoImp = new StudentDaoImp();

			
			ArrayList<CourseMaterial> courseMaterials = studentDaoImp.getCourseMaterialsOfStudent(user.getSchoolID());
			
			session.setAttribute("courseMaterials", courseMaterials);


		}
		catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect((String) session.getAttribute("lastPath"));
			return;
		}

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/student/course-materials.jsp");
		requestDispatcher.forward(req, resp);
		
	
		
	}
		
		


}
