package controller.student;

import java.io.Console;
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

import controller.SecurityController;
import enums.AppForm;
import helper.Uploader;
import interfaceImp.AssignmentDaoImp;
import pojos.Assignment;
import pojos.CourseAssignment;
import pojos.SimpleFile;
import pojos.User;


@WebServlet(name="ServletStudentAssignment", urlPatterns= {"/student/assignments"})
@MultipartConfig
public class ServletStudentAssignment extends HttpServlet{
	
	/*
	 * Need new table called Assignment (AssignmentID, lectureID, FileID, Title, Detail, PostedAT, DueDate)
	 * 
	 * need add new function CourseDao ->  getCourseAssingments(int lectureID) get the assignment according to lectureID return arraylist<Anouncment(already in pojos)>
	 * need new function StudentDao -> getSubmittedAssigment(int schoolID) return arraylist<AssignmentStd(already in pojos)>
	 * 
	 * ! design should be change
	 * 
	 * add returned arraylists to session
	 * dispatcher -> /student/assignment.jsp
	 * */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User user = null;
		HttpSession session = req.getSession();
		
		if (!SecurityController.studentRequired(session, req, resp)) {
			return;
		}

		try{
			user = (User) session.getAttribute("user");
			AssignmentDaoImp assignmentDaoImp = new AssignmentDaoImp();

			ArrayList<Assignment> assignments = assignmentDaoImp.getAllAssignmentByStudentID(user.getSchoolID());
			ArrayList<CourseAssignment> courseAssignments = assignmentDaoImp.getCourseAssignmentByStudentID(user.getSchoolID());

			session.setAttribute("courseAssignments", courseAssignments);
			session.setAttribute("assignments", assignments);
		}catch (Exception e){
			e.printStackTrace();
			resp.sendRedirect((String)session.getAttribute("lastPath"));
			return;
		}


		session.setAttribute("lastPath", req.getRequestURI());
		RequestDispatcher dispatcher = req.getRequestDispatcher("/student/assignments.jsp");
		dispatcher.forward(req, resp);
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User user = null;
		HttpSession session = req.getSession();
		
		if (!SecurityController.studentRequired(session, req, resp)) {
			return;
		}

		user = (User) session.getAttribute("user");
		
		
		int assignmentID = Integer.parseInt(req.getParameter(AppForm.ASSIGNMENT_ID));
		int announcementID = Integer.parseInt(req.getParameter(AppForm.ANNOUNCEMENT_ID));
		int lectureID = Integer.parseInt(req.getParameter(AppForm.LECTURE_ID));

		
        Part filePart = req.getPart(AppForm.COURSE_MATERIAL_FILE);
        
        
        if (filePart != null) {
        	SimpleFile file = Uploader.uploadFile(user.getSchoolID(), filePart); // file is uploaded and returned a simple file object
        	if (file != null) {
        		AssignmentDaoImp assignmentDaoImp = new AssignmentDaoImp();
        		
        		assignmentDaoImp.saveAssignmentofStudent(file, user.getSchoolID(), lectureID, assignmentID, announcementID);
        		
        	}
        }
        
		resp.sendRedirect(req.getContextPath() + "/student/assignments");
	
	}
}








