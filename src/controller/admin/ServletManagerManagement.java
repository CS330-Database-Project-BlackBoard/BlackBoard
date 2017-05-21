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
import interfaceImp.ManagerDaoImp;
import pojos.Manager;
import pojos.User;

@WebServlet(name="ServletManagerManagement", urlPatterns={"/admin/managers"})
public class ServletManagerManagement extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		if(!SecurityController.adminRequired(session, req, resp)){
			return;
		}
		
		

		ManagerDaoImp managerDaoImp = new ManagerDaoImp();
		
		ArrayList<Manager> managers = managerDaoImp.getAllManagers();
		session.setAttribute("managers", managers);
		session.setAttribute("roles", managerDaoImp.getAdminRoles());

		session.setAttribute("lastPath", req.getRequestURI());

		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/bb-user-management.jsp");
		dispatcher.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		if(!SecurityController.signinRequired(session, req,resp) && !SecurityController.adminRequired(session, req, resp)){
			return;
		}
		
		int schoolID = Integer.parseInt(req.getParameter("schoolID"));
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		String surname = req.getParameter("surname");
		int role = Integer.parseInt(req.getParameter("role"));
		System.out.println("role: " + role);
		
		Manager manager = new Manager(schoolID, email, password, name, surname, role);
		String message = "";
		
		ManagerDaoImp managerDaoImp = new ManagerDaoImp();
		if(managerDaoImp.createNewManager(manager)) {
			message = "Manager is created successfully";
		}
		else {
			message = "Manager is not created";
		}
		session.setAttribute("manager.message", message);
		
		
		resp.sendRedirect(req.getContextPath() + "/admin/managers");
		
		
	}

}
