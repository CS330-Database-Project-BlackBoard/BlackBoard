package controller.admin;

import controller.SigninController;
import interfaceImp.StudentDaoImp;
import pojos.Student;
import pojos.User;

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


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        User user = null;
        HttpSession session = request.getSession();

        try {
            user = (User) session.getAttribute("user");
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (!SigninController.adminRequired(user, request, response)) {
                return;
            }
        }

        StudentDaoImp studentDaoImp = new StudentDaoImp();

        ArrayList<Student> students =studentDaoImp.getAllStudents();
        session.setAttribute("students",students);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/bb-student-management.jsp");
        dispatcher.forward(request, response);

    }
}
