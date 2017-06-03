package controller.lecturer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.SecurityController;
import enums.AppPath;
import interfaceImp.CourseDaoImp;
import interfaceImp.LecturerDaoImp;
import interfaceImp.StudentDaoImp;
import pojos.Course;
import pojos.LectureDashboard;
import pojos.Lecturer;
import pojos.LecturerCourseGrade;
import pojos.Student;
import pojos.User;

@WebServlet(name = "ServletLecturerNewGrade", urlPatterns = {"/lecturer/new-grade/*"})
public class ServletLecturerNewGrade extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		User user = null;
		
		if (!SecurityController.lecturerRequired(session, req, resp)) {
			return;
		}
		
		try {
			
			user = (User) session.getAttribute("user");
			Lecturer lecturer = new Lecturer(user.getSchoolID(), user.getEmail(), user.getName(), user.getSurname(), user.getRole());
			
		
			
			String path = req.getPathInfo(); // get the path
			String[] paths = path.split("/"); // parse the path to get the lecture id

			if(path.contains(AppPath.LECTURE)) { 
				
				int lectureID = Integer.parseInt(paths[2]); // get lectureID
				
				CourseDaoImp courseDaoImp = new CourseDaoImp();
				StudentDaoImp studentDaoImp = new StudentDaoImp();
				
				ArrayList<Student> students = studentDaoImp.getStudentsByLectureID(lectureID); // get students
				Course course = courseDaoImp.getCourseByLectureID(lectureID); // get course
				
				
				session.setAttribute("students", students); // add to session
				session.setAttribute("course", course);
			}
			
			
					
		}
		catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect((String) session.getAttribute("lastPath"));
			return;
		}

		session.setAttribute("lastPath", req.getRequestURI()); // get last path
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/lecturer/new-grade.jsp"); // render the jsp file
		requestDispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// when new grades are wanted to insert
		
		HttpSession session = req.getSession();
		User user = null;
		
		if (!SecurityController.lecturerRequired(session, req, resp)) {
			return;
		}
		
		try {
			
			user = (User) session.getAttribute("user");
			Lecturer lecturer = new Lecturer(user.getSchoolID(), user.getEmail(), user.getName(), user.getSurname(), user.getRole());
			
		
			
			String path = req.getPathInfo();
			String[] paths = path.split("/");
			System.out.println(Arrays.toString(paths));
			
			if(path.contains(AppPath.LECTURE)) {
				
				int lectureID = Integer.parseInt(paths[2]);
				
				
				StudentDaoImp studentDaoImp = new StudentDaoImp();				
				
				ArrayList<Student> students = studentDaoImp.getStudentsByLectureID(lectureID); // get students 
				
				
				
				float grade = 0;
				String gradeName = req.getParameter("grade-name"); // get form datas and parse them
				float gradeAffect = Float.parseFloat(req.getParameter("grade-affect"));
	
				HashMap<Integer, Float> gradeOfStudents = new HashMap<>(); // student grades and ids will be stored in a hashmap as key value
				
				
				for (Student student : students) {
					
					grade = Float.parseFloat(req.getParameter(""+student.getSchoolID())); // the input names are the student ids, because of uniquness
					grade = grade < 0 ? 0 : grade; // eger 0 dan kucukse notu 0 yapas
					
					gradeOfStudents.put(student.getSchoolID(), grade); // put id and grade in map
					
				}
				
				LecturerDaoImp lecturerDaoImp = new LecturerDaoImp();
				
				if (!lecturerDaoImp.saveStudentGrades(lecturer, lectureID, gradeName, gradeAffect, gradeOfStudents)) { // insert the grades
					throw new Exception("Error when insertig grades");
				}
				
			}
			
			
				
		}
		catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect((String) session.getAttribute("lastPath"));
			return;
		}

		resp.sendRedirect(req.getContextPath() + "/lecturer/grades");
	}

}
