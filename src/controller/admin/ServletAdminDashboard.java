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

		if(!SecurityController.signinRequired(session, req,resp) && !SecurityController.adminRequired(session, req, resp)){
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

}
