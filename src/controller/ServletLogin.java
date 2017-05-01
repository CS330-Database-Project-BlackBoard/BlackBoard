package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import interfaceImp.UserDaoImpl;
import pojos.User;

@WebServlet(name="ServletLogin", urlPatterns={"/login"})
public class ServletLogin extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/bb-login.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		User user = null;
		HttpSession session = req.getSession();
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");		
		UserDaoImpl userDaoImplementation = new UserDaoImpl();
		boolean isSignedIn = userDaoImplementation.signIn(email, password);
		if(isSignedIn)
		{
			user = userDaoImplementation.getUser();
			session.setAttribute("user", user);
			// redirection
			
			switch (user.getRole()) {
			case 1:
				resp.sendRedirect("admin/dashboard");
				return;

			default:
				break;
			}
			
		}
		
		resp.sendRedirect("login");
	}

}
