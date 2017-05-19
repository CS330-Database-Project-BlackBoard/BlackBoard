package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.SecurityController;
import enums.AppPath;

@WebServlet(name="ServletGradeManagement", urlPatterns= {"/grade/*"})
public class ServletGradeManagement extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		if(!SecurityController.adminRequired(session, req, resp)){
			return;
		}
		
		
		
		String pathInfo = req.getPathInfo();
		
		try {
			if (pathInfo.contains(AppPath.LECTURE) && pathInfo.contains(AppPath.STUDENTS)) {
				System.out.println(pathInfo);
				
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect((String) session.getAttribute("lastPath"));
			return;
		}
		
		
		
		
	}
	
}
