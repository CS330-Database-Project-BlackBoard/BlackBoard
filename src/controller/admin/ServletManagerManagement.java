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
import enums.AppForm;
import interfaceImp.ManagerDaoImp;
import pojos.Manager;
import pojos.User;

/*
 * 
 * This servlet renders all managers and save new manager
 * 
 * */


@WebServlet(name="ServletManagerManagement", urlPatterns={"/admin/managers"})
public class ServletManagerManagement extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// render 
		HttpSession session = req.getSession();

		if(!SecurityController.adminRequired(session, req, resp)){
			return;
		}
		
		

		ManagerDaoImp managerDaoImp = new ManagerDaoImp();
		
		ArrayList<Manager> managers = managerDaoImp.getAllManagers(); // get all managers
		session.setAttribute("managers", managers);
		session.setAttribute("roles", managerDaoImp.getAdminRoles()); // get all role types

		session.setAttribute("lastPath", req.getRequestURI());
		
		// render
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/bb-user-management.jsp");
		dispatcher.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// save
		HttpSession session = req.getSession();

		if(!SecurityController.signinRequired(session, req,resp) && !SecurityController.adminRequired(session, req, resp)){
			return;
		}
		
		// get posted data from form
		
		int schoolID = Integer.parseInt(req.getParameter(AppForm.SCHOOL_ID));
		String email = req.getParameter(AppForm.EMAIL);
		String password = req.getParameter(AppForm.PASSWORD);
		String name = req.getParameter(AppForm.NAME);
		String surname = req.getParameter(AppForm.SURNAME);
		int role = Integer.parseInt(req.getParameter(AppForm.ROLE));
		
		Manager manager = new Manager(schoolID, email, password, name, surname, role);
		String message = "";
		
		ManagerDaoImp managerDaoImp = new ManagerDaoImp();
		if(managerDaoImp.createNewManager(manager)) { // save manager
			message = "Manager is created successfully";
		}
		else {
			message = "Manager is not created";
		}
		//session.setAttribute("manager.message", message);
		
		
		resp.sendRedirect(req.getContextPath() + "/admin/managers");
		
		
	}

}
