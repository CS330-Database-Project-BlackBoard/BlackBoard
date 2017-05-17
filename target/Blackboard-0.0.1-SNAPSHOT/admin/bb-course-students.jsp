<%@page import="pojos.LectureDashboard"%>
<%@page import="pojos.Student"%>
<%@page import="java.util.ArrayList"%>


<%ArrayList<Student> students = (ArrayList<Student>) session.getAttribute("lectureStudents"); %>
<%LectureDashboard lectureDashboard = (LectureDashboard) session.getAttribute("lectureDashboard"); %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Lecture - Students</title>
		<%@include file="style.jsp" %>
	
</head>

<body>
    <div id="wrapper">
              <%@ include file="bb-head.jsp" %>

        <!--/. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                 <ul class="nav" id="main-menu">
         			 <li>
                        <a  href="${pageContext.request.contextPath}/admin/dashboard"><i class="fa fa-dashboard"></i> Dashboard</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/managers"><i class="fa fa-user"></i> User Management</a>
                    </li>
                    <li>
                        <a class="active-menu"  href="${pageContext.request.contextPath}/admin/courses"><i class="fa fa-book"></i> Course Management</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/students"><i class="fa fa-graduation-cap"></i> Student Management</a>
                    </li>

                    <li>
                        <a class="" href="${pageContext.request.contextPath}/admin/lecturers"><i class="fa fa-users"></i> Lecturer Management</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/settings"><i class="fa fa-edit"></i> Settings</a>
                    </li>
                </ul>

            </div>

        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
            <div id="page-inner">


                <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">
                            <%= lectureDashboard.getCourse().getName() %> Course Student List
                        </h1>
                    </div>
                </div>
                <!-- /. ROW  -->

                <div class="row">
                    <div class="col-md-12">

                            <div class="panel panel-default">
                              <div class="panel-heading">
                                <h3 class="panel-title">Student List</h3>
                              </div>
                              <div class="panel-body">
                                  <table class="table table-responsive">
                                      <thead>
                                          <th class="text-center">Student ID</th>
                                          <th class="text-center">Student Name</th>
                                          <th class="text-center">Student Course Average</th>
                                          <th class="text-center"></td>
                                      </thead>
                                      <tbody>
                                          <%  for(Student student: students){ %>
                                          
                                          <tr class="text-center">
                                              <td><%= student.getSchoolID() %></td>
                                              <td><%= student.getNameSurname() %></td>
                                              <td><%= student.getAverage() %></td>
                                              <td><a href="${pageContext.request.contextPath}/admin/grade/lecture/<%= lectureDashboard.getCourse().getLectureID() %>/ student/<%= student.getSchoolID() %>/"><i class="fa fa-chevron-right"></i></a></td>
                                          </tr>

                                          <%} %>
                                      </tbody>
                                  </table>
                              </div>
                            </div>
                    </div>
                </div>


            </div>
        </div>

		<%@include file="style.jsp" %>
	

</body>

</html>
