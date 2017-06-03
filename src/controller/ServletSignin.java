package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import enums.AppRole;
import interfaceImp.UserDaoImpl;
import pojos.User;

/*
 * This servlet is for signing in 
 * 
 * */

@WebServlet(name="ServletLogin", urlPatterns={"/signin"})
public class ServletSignin extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/bb-login.jsp"); // render login jsp
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		User user = null;
		HttpSession session = req.getSession(); // get session 
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");		
		
		UserDaoImpl userDaoImplementation = new UserDaoImpl(); 
		
		if(userDaoImplementation.signIn(email, password)) // check is signed in
		{
			user = userDaoImplementation.getUser();
			session.setAttribute("user", user);
			
			
			SecurityController.redirectToUserByRole(user, req, resp); // redirect to 
			return;
			
		}
		
		resp.sendRedirect("login"); // if no user, redirect login page
	}

}
