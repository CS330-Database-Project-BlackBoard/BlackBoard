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
import enums.AppPath;
import interfaceImp.LecturerDaoImp;
import pojos.CourseMaterial;
import pojos.Lecturer;
import pojos.User;


@WebServlet(name="ServletLecturerCourseMaterial", urlPatterns= {"/lecturer/course-materials", "/lecturer/course-material/*"})
public class ServletLecturerCourseMaterial extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		if (!SecurityController.lecturerRequired(session, req, resp)) {
			return;
		}
		
	
		
		try {
			
			
			User user = (User) session.getAttribute("user");
			
			Lecturer lecturer = new Lecturer(user.getSchoolID(), user.getEmail(),user.getName(), user.getSurname(), user.getRole());
			
			String path = req.getPathInfo();
			
			
			
			
			if (path != null && path.contains(AppPath.LECTURE) && path.contains(AppPath.NEW)) {
				String paths[] = path.split("/");
				
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("/lecturer/new-course-material.jsp");
				requestDispatcher.forward(req, resp);
				return;
				
				
			}
			else {
				LecturerDaoImp lecturerDaoImp = new LecturerDaoImp();
				
				ArrayList<CourseMaterial> courseMaterials = lecturerDaoImp.getCourseMaterialsOfLecturer(lecturer);
				
				session.setAttribute("courseMaterials", courseMaterials);
				
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("/lecturer/course-materials.jsp");
				requestDispatcher.forward(req, resp);
				return;
			}
			
			
		


		}
		catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect((String) session.getAttribute("lastPath"));
			return;
		}

		
	
		
	}
		
		


}
