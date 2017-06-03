package controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.SecurityController;
import enums.AppForm;
import interfaceImp.AnnouncementDaoImp;
import interfaceImp.DashboardDaoImp;
import pojos.Dashboard;
import pojos.User;


/*
 * This servlets manages admin dashboad 
 * */


@WebServlet(name="ServletAdminDashboard", urlPatterns={"/admin/dashboard"})
public class ServletAdminDashboard extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();

		User user = null;

		if(!SecurityController.adminRequired(session, req, resp)){
			return;
		}
		
		user = (User)session.getAttribute("user");
		
		DashboardDaoImp dashboardDaoImp = new DashboardDaoImp();
		
		Dashboard dashboard = dashboardDaoImp.getDashboard(user); // get dashboard object which contains data from database
		
		
		session.setAttribute("dashboard", dashboard); // put it in session
		
		session.setAttribute("lastPath", req.getRequestURI()); // keep last path for errors

		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/bb-index.jsp"); // render index jsp which contains dashboard design
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/*
		 * for publishing anouncment
		 * */
		
		HttpSession session = req.getSession();

		User user = null;

		if(!SecurityController.adminRequired(session, req, resp)){
			return;
		}
		
		// 
		user = (User)session.getAttribute("user");
		String title = req.getParameter(AppForm.ANNOUNCEMENT_TITLE);
		String content = req.getParameter(AppForm.ANNOUNCEMENT_CONTENT);
		String toWho = req.getParameter(AppForm.ANNOUNCEMENT_POSTED_TO);
	
		if (title != null && !title.isEmpty() && content != null && !content.isEmpty() && toWho != null && !toWho.isEmpty()) {
			AnnouncementDaoImp anouncmentDaoImp = new AnnouncementDaoImp();
			anouncmentDaoImp.sendAnnouncement(title, content, toWho, user.getSchoolID());
		}
		
		resp.sendRedirect(req.getContextPath() + "/admin/dashboad");
		
	}

}
