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
 * 
 *  This is the main servlet, checks if user is exist in session redirect to related dashboard, else redirect to sign in page
 * 
 * */

@WebServlet(name="ServletIndex", urlPatterns= {"/"})
public class ServletIndex extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = null;
		HttpSession session = req.getSession();
		
		try {
			user = (User) session.getAttribute("user");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			SecurityController.isSignedIn(user,req, resp); // check is signed in
		}
		
		SecurityController.redirectToUserByRole(user,req, resp); // if it is redirect to dashboard
		
	
	}
}
