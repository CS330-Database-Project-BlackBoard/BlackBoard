package controller.admin;

import controller.SecurityController;
import interfaceImp.StudentDaoImp;
import pojos.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by koryozyurt on 09.05.2017.
 */
@WebServlet(name = "ServletStudentManagement", urlPatterns = {"/admin/students"})
public class ServletStudentManagement extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        HttpSession session = req.getSession();

    	if(!SecurityController.adminRequired(session, req, resp)){
			return;
		}
		
		
        StudentDaoImp studentDaoImp = new StudentDaoImp();

        ArrayList<Student> students =studentDaoImp.getAllStudents();
        session.setAttribute("students",students);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/bb-student-management.jsp");
        dispatcher.forward(req, resp);

    }
}
