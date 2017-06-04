package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import controller.SecurityController;
import enums.AppForm;
import interfaceImp.LecturerDaoImp;
import pojos.Lecturer;

/*
 * This servlet renders lecturer names and email address
 * Jquery send post request which contains part of lecturer name, and servlet renders related outputs
 * 
 * */


@WebServlet(name="ServletSearchLecturer", urlPatterns= {"/admin/search/lecturer"})
public class ServletSearchLecturer extends HttpServlet{
	
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		HttpSession session = req.getSession();
		
		if(!SecurityController.adminRequired(session, req, resp)){
			return;
		}
		
		
		String lecturerName = (String) req.getParameter(AppForm.LECTURER); // get parameter
		LecturerDaoImp lecturerDaoImp = new LecturerDaoImp();
		
		ArrayList<Lecturer> lecturers = lecturerDaoImp.getLecturersByName(lecturerName); // get lecturer
		
		
		JSONObject response = new JSONObject();
		
		
		for (Lecturer lecturer : lecturers) {
			response.put(lecturer.getEmail(), lecturer.getNameSurname()); // put lecturer data in json object
		}
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");
		
		PrintWriter printWriter = resp.getWriter();
		
		printWriter.print(response.toString()); // write the object
		
		
		
		
		
		
	}
}
