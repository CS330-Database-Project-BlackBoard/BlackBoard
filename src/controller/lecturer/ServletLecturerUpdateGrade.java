package controller.lecturer;

import controller.SecurityController;
import enums.AppPath;
import interfaceImp.CourseDaoImp;
import interfaceImp.LecturerDaoImp;
import interfaceImp.StudentDaoImp;
import pojos.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by MONSTER on 5.06.2017.
 */

@WebServlet(name = "ServletLecturerUpdateGrade", urlPatterns = {"/lecturer/grade/*"})
public class ServletLecturerUpdateGrade extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        if(!SecurityController.lecturerRequired(session, req, resp)){
            return;
        }

        try {

            String path = req.getPathInfo();
            String[] paths = path.split("/");

            if(path.contains(AppPath.LECTURE) ) {
                int lectureID = Integer.parseInt(paths[3]);
                int gradeID = Integer.parseInt(paths[1]);

                CourseDaoImp courseDaoImp = new CourseDaoImp();

                ArrayList<StudentGradeView> grades = courseDaoImp.getStudentListofGradeByGradeID(gradeID);

                SimpleGrade gradeName = courseDaoImp.getGradeName(lectureID, gradeID);

                session.setAttribute("gradeView", grades);
                session.setAttribute("grade", gradeName);

                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/lecturer/student-list.jsp");
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HttpSession session = req.getSession();

        User user = null;

        if (!SecurityController.lecturerRequired(session, req, resp)){
            return;
        }

        try {

            String path = req.getPathInfo();
            String[] paths = path.split("/");

            if (path.contains(AppPath.LECTURE)){

                int lectureID = Integer.parseInt(paths[3]);
                int gradeID = Integer.parseInt(paths[1]);

                StudentDaoImp studentDaoImp = new StudentDaoImp();

                ArrayList<Student> students = studentDaoImp.getStudentsByLectureID(lectureID);

                HashMap<Integer, Float> gradeOfStudent = new HashMap<>();

                float grade = 0;

                for (Student student : students){
                    if(req.getParameter(""+student.getSchoolID()) == null){

                        continue;
                    }

                    grade = Float.parseFloat(req.getParameter(""+student.getSchoolID())); // the input names are the student ids, because of uniquness
                    grade = grade < 0 ? 0 : grade;

                    gradeOfStudent.put(student.getSchoolID(), grade);

                }

                LecturerDaoImp lecturerDaoImp = new LecturerDaoImp();

                if (!lecturerDaoImp.updateStudentGrades(gradeID, gradeOfStudent))
                    throw new Exception("Error When updating");
            }

        }catch (Exception e){
            e.printStackTrace();
            resp.sendRedirect((String) session.getAttribute("lastPath"));
            return;
        }

        resp.sendRedirect(req.getContextPath() + "/lecturer/grades");



    }
}
