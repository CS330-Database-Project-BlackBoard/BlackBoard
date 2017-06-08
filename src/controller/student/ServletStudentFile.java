package controller.student;

import controller.SecurityController;
import helper.TimeZone;
import interfaceImp.AssignmentDaoImp;
import pojos.Assignment;
import pojos.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet(name = "ServletStudentFile", urlPatterns = {"/student/upload"})
@MultipartConfig
public class ServletStudentFile extends HttpServlet {

    private static final String DATA_DIRECTORY = "/home/koryozyurt/student-files";
    private static final int MAX_MEMORY_SIZE = 1024 * 1024 * 2;
    private static final int MAX_REQUEST_SIZE = 1024 * 1024;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        final PrintWriter writer = resp.getWriter();

        final Part filePart = req.getPart("file");
        String fileName = getFileName(filePart);

        HttpSession session = req.getSession();

        User user = (User) session.getAttribute("user");
        fileName = user.getSchoolID() + TimeZone.getDateTime() + fileName;

        OutputStream outputStream = null;
        InputStream fileContent = null;

        try {
            String filePath = DATA_DIRECTORY + File.separator + fileName;
            outputStream = new FileOutputStream(new File(filePath));
            fileContent = filePart.getInputStream();
            int read = 0;
            final byte[] bytes = new byte[1024];
            while ((read = fileContent.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }

            AssignmentDaoImp assignmentDaoImp = new AssignmentDaoImp();
            Assignment assignment  = (Assignment) session.getAttribute("uploadedAssignment");
            assignmentDaoImp.uploadFile(filePath,assignment.getName(),assignment.getLectureID(),assignment.getAssignmentID(), user.getSchoolID());


        }catch (FileNotFoundException e){
            writer.println("Missing file or no insufficient permissions.");
            writer.println(" ERROR: " + e.getMessage());
            return;
        } finally {
            if(outputStream != null){
                outputStream.close();
            }
        }if(fileContent != null){
            fileContent.close();
        }if(writer != null){
            writer.close();
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/student/upload.jsp");
        dispatcher.forward(req, resp);
    }


    private String getFileName(Part filePart){
        String header = filePart.getHeader("content-disposition");
        String name = header.substring(header.indexOf("filename=\"")+10);
        return name.substring(0, name.indexOf("\""));
    }
}
