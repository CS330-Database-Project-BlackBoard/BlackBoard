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

import controller.SigninController;
import interfaceImp.LecturerDaoImp;
import pojos.CourseOfLecturer;
import pojos.Lecturer;


@WebServlet(name="ServletLecturer", urlPatterns= {"/admin/lecturer/*"})
public class ServletLecturerCourses extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();


		if(!SigninController.signinRequired(session, req,resp)){
			return;
		}
		
		try {
			
			String pathInfo = req.getPathInfo();
			String[] path = pathInfo.split("/");
			System.out.println(Arrays.toString(path));
			
			int lecturerID = Integer.parseInt(path[1]);
			
	
			
			
			
			LecturerDaoImp lecturerDaoImp = new LecturerDaoImp();
			
			Lecturer lecturer = lecturerDaoImp.getLecturerBySchooID(lecturerID);
			
			if(lecturer == null) {
				throw new Exception("Lecturer is not found");
			}
			
			
			ArrayList<CourseOfLecturer> coursesOfLecturer = lecturerDaoImp.getCoursesOfLecturer(lecturer);
			
			session.setAttribute("lecturer", lecturer);
			session.setAttribute("coursesOfLecturer", coursesOfLecturer);
		
			
		}
		catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect((String)session.getAttribute("lastPath"));
			resp.sendRedirect(req.getContextPath() + "/admin/lecturer");
			return;
		}
		
		
	
		session.setAttribute("lastPath", req.getRequestURI());

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/bb-lecturer-management-course-list.jsp");
		requestDispatcher.forward(req, resp);
		
	}
	
}
