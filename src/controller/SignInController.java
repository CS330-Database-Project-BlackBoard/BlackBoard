package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import enums.AppRole;
import pojos.User;

public class SignInController {
	public static void isSignedIn(User user, HttpServletResponse resp) {
		try {
			if(user == null) {
				resp.sendRedirect("login");
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

			default:
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	public static void adminRequired(User user, HttpServletResponse resp) {
		if(user.getRole() != AppRole.SUPER_ADMIN  || user.getRole() != AppRole.ADMIN) {
			redirectToUserByRole(user, resp);
		}
		
	}
	
	
	

}
