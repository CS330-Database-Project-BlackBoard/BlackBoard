package controller.lecturer;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.catalina.tribes.util.Arrays;

import controller.SecurityController;
import enums.AppForm;
import enums.AppPath;
import helper.Uploader;
import interfaceImp.CourseDaoImp;
import interfaceImp.LecturerDaoImp;
import pojos.CourseMaterial;
import pojos.Lecturer;
import pojos.SimpleFile;
import pojos.User;


@WebServlet(name="ServletLecturerCourseMaterial", urlPatterns= {"/lecturer/course-materials", "/lecturer/course-material/*"})
@MultipartConfig
public class ServletLecturerCourseMaterial extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		if (!SecurityController.lecturerRequired(session, req, resp)) {
			return;
		}
		
	
		
		try {
			
			
			User user = (User) session.getAttribute("user");
			
			Lecturer lecturer = new Lecturer(user.getSchoolID(), user.getEmail(),user.getName(), user.getSurname(), user.getRole());
			
			String path = req.getPathInfo();
			
			
			
			
			if (path != null && path.contains(AppPath.LECTURE) && path.contains(AppPath.NEW)) {
				String paths[] = path.split("/");
				
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("/lecturer/new-course-material.jsp");
				requestDispatcher.forward(req, resp);
				return;
				
				
			}
			else {
				LecturerDaoImp lecturerDaoImp = new LecturerDaoImp();
				
				ArrayList<CourseMaterial> courseMaterials = lecturerDaoImp.getCourseMaterialsOfLecturer(lecturer);
				
				session.setAttribute("courseMaterials", courseMaterials);
				
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("/lecturer/course-materials.jsp");
				requestDispatcher.forward(req, resp);
				return;
			}
			
			
		


		}
		catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect((String) session.getAttribute("lastPath"));
			return;
		}

		
	
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		HttpSession session = req.getSession();

		if (!SecurityController.lecturerRequired(session, req, resp)) {
			return;
		}
		String path = req.getPathInfo();
		
		if (path != null && path.contains(AppPath.LECTURE) && path.contains(AppPath.NEW)) {
			String paths[] = path.split("/");
			int lectureID = Integer.parseInt(paths[2]);
			
			
			
			User user = (User) session.getAttribute("user");
			
			
			String title = req.getParameter(AppForm.ANNOUNCEMENT_TITLE);
			String content = req.getParameter(AppForm.ANNOUNCEMENT_CONTENT);
			
	        Part filePart = req.getPart(AppForm.COURSE_MATERIAL_FILE);
	        
	        
	        if (filePart != null) {
	        	SimpleFile file = Uploader.uploadFile(user.getSchoolID(), filePart); // file is uploaded and returned a simple file object
	        	if (file != null) {
					CourseDaoImp courseDaoImp = new CourseDaoImp();
					courseDaoImp.saveCourseMaterial(file, user.getSchoolID(), lectureID, title, content);
				}
	        }
	        
	        

			
			
		}

        
        resp.sendRedirect(req.getContextPath() + "/lecturer/course-materials");
        
        
	}
		
		


}
