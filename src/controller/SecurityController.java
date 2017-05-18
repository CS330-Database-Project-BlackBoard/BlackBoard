package controller;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import enums.AppRole;
import pojos.User;

public class SecurityController {
	public static void isSignedIn(User user, HttpServletRequest req, HttpServletResponse resp) {
		try {
			if(user == null) {
				resp.sendRedirect(req.getContextPath() + "/signin");
				return;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public static void redirectToUserByRole(User user, HttpServletResponse resp) {
		
		try {
			switch (user.getRole()) {
			case 1:
				resp.sendRedirect("admin/dashboard");
				break;
			case 2:
				resp.sendRedirect("admin/dashboard");
				break;

			default:
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	public static boolean adminRequired(HttpSession session, HttpServletRequest req, HttpServletResponse resp) {
		User user;
		try {
			 user = (User) session.getAttribute("user");
			 
		} catch (Exception e) {
			e.printStackTrace();
			try {
				resp.sendRedirect(req.getContextPath() + "/signin");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
		}
		
		if (user != null) {
			if(user.getRole() != AppRole.SUPER_ADMIN  &&  user.getRole() != AppRole.ADMIN) {
				redirectToUserByRole(user, resp);
				return false;
			}
		}
		else {
			
			try {
				resp.sendRedirect(req.getContextPath() + "/signin");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		return true;
	}



	public static boolean signinRequired(HttpSession session, HttpServletRequest req, HttpServletResponse resp){
		User user = null;
		try {
			user = (User) session.getAttribute("user");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				resp.sendRedirect(req.getContextPath() + "/signin");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
		}
		
		if (user == null) {
			try {
				resp.sendRedirect(req.getContextPath() + "/signin");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		return true;
		
	}
	

	
	

}
