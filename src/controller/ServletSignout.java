package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.User;

@WebServlet(name="ServletSignout", urlPatterns= {"/signout"})
public class ServletSignout extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		User user = null;
		
		try {
			user = (User) session.getAttribute("user");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		if (user != null) {
			session.setAttribute("user", null);
			resp.sendRedirect("signin");
		}
		
	}
}
