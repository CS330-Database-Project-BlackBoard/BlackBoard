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

import controller.SigninController;
import interfaceImp.LecturerDaoImp;
import pojos.Lecturer;


@WebServlet(name="ServletLecturerManagement", urlPatterns= {"/admin/lecturers"})
public class ServletLecturerManagement extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();

		if(!SigninController.signinRequired(session, req,resp)){
			return;
		}
		
		LecturerDaoImp lecturerDaoImp = new LecturerDaoImp();
		
		ArrayList<Lecturer> lecturers = lecturerDaoImp.getAllLecturers();
		
		
		session.setAttribute("lecturers", lecturers);
		
		session.setAttribute("lastPath", req.getRequestURI());

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/bb-lecturer-management.jsp");
		requestDispatcher.forward(req, resp);
		
	}

}
