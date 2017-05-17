package controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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


	/**
	 *
	 * @param session
	 * @param request
	 * @param response
	 * @return is the student signed in, we use the function every servlet class to check session.
	 */
	public static boolean signinRequired(HttpSession session, HttpServletRequest request, HttpServletResponse response){
		User user = null;
		try {
			user = (User) session.getAttribute("user");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (SigninController.adminRequired(user, request, response)) {
				return true;
			}else{
				return false;
			}
		}
	}
	

	
	

}
