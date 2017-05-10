package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enums.AppRole;
import pojos.User;

public class SigninController {
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
	
	
	public static boolean adminRequired(User user, HttpServletRequest req, HttpServletResponse resp) {
		try {
			if (user != null) {
				if(user.getRole() != AppRole.SUPER_ADMIN  &&  user.getRole() != AppRole.ADMIN) {
					redirectToUserByRole(user, resp);
					return false;
				}
			}
			else {
				
				resp.sendRedirect(req.getContextPath() + "/signin");
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
		
		
	}
	

	
	

}
