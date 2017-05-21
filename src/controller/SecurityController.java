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
	
	
	public static void redirectToUserByRole(User user,HttpServletRequest req, HttpServletResponse resp) {
		
		try {
			switch (user.getRole()) {
			case 1:
				resp.sendRedirect(req.getContextPath() + "/admin/dashboard");
				break;
			case 2:
				resp.sendRedirect(req.getContextPath() + "/admin/dashboard");
				break;
			case 5:
				resp.sendRedirect(req.getContextPath() + "/student/dashboard");
			default:
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public static boolean studentRequired(HttpSession session, HttpServletRequest req, HttpServletResponse resp) {
		User user = null;
		
		if(signinRequired(session, req, resp)) {
			try {
				user = (User) session.getAttribute("user");
				if (user != null) {
					if (user.getRole() !=  AppRole.STUDENT) {
						redirectToUserByRole(user, req, resp);
						return false;
					}
					else {
						return true;
					}
				}
				else {
					 resp.sendRedirect(req.getContextPath() + "/signin");
					 return false;
				}
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
		
	}
	
	public static boolean adminRequired(HttpSession session, HttpServletRequest req, HttpServletResponse resp) {
		User user = null;
		if (signinRequired(session, req, resp)) {
			try {
				 user = (User) session.getAttribute("user");
				 
				 if (user != null) {
						if(user.getRole() != AppRole.SUPER_ADMIN  &&  user.getRole() != AppRole.ADMIN) {
							redirectToUserByRole(user, req, resp);
							return false;
						}
						else {
							return true;
						}
						
				 }
				 else {
					 resp.sendRedirect(req.getContextPath() + "/signin");
					 return false;
				 }	 
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
		
	}



	public static boolean signinRequired(HttpSession session, HttpServletRequest req, HttpServletResponse resp){
		User user = null;
		try {
			user = (User) session.getAttribute("user");
			if (user == null) {
					resp.sendRedirect(req.getContextPath() + "/signin");
					return false;
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
			
			try {
				resp.sendRedirect(req.getContextPath() + "/signin");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
		}
		
	
		return true;
		
	}	

}
