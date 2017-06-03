package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.User;



/*
 * This servlet for signing out the user.
 * 
 * */

@WebServlet(name="ServletSignout", urlPatterns= {"/signout"})
public class ServletSignout extends HttpServlet{

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(); // get session
		User user = null;
		
		try {
			user = (User) session.getAttribute("user"); // get user from session
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		if (user != null) { // if it is exit
			session.setAttribute("user", null); // set null the user in session, this will cause the redirect to signin page always
			resp.sendRedirect("signin");
		}
		
	}
}
