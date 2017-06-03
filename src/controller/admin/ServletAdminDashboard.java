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
import interfaceImp.AnouncmentDaoImp;
import interfaceImp.DashboardDaoImp;
import pojos.Dashboard;
import pojos.User;



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
		Dashboard dashboard = dashboardDaoImp.getDashboard(user);
		
		
		session.setAttribute("dashboard", dashboard);
		
		session.setAttribute("lastPath", req.getRequestURI());

		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/bb-index.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();

		User user = null;

		if(!SecurityController.adminRequired(session, req, resp)){
			return;
		}
		
		user = (User)session.getAttribute("user");
		String title = req.getParameter("anouncment-title");
		String content = req.getParameter("anouncment-content");
		String toWho = req.getParameter("anouncment-postTo");
	
		if (title != null && !title.isEmpty() && content != null && !content.isEmpty() && toWho != null && !toWho.isEmpty()) {
			AnouncmentDaoImp anouncmentDaoImp = new AnouncmentDaoImp();
			anouncmentDaoImp.sendAnouncment(title, content, toWho, user.getSchoolID());
		}
		
		resp.sendRedirect(req.getContextPath() + "/admin/dashboad");
		
	}

}
