<%@page import="pojos.CourseOfLecturer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pojos.Lecturer"%>


<% Lecturer lecturer = (Lecturer) session.getAttribute("lecturer"); %>
<% ArrayList<CourseOfLecturer> coursesOfLecturer = (ArrayList<CourseOfLecturer>) session.getAttribute("coursesOfLecturer");%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Blackboard - Dashboard</title>

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
                        <a href="${pageContext.request.contextPath}/admin/courses"><i class="fa fa-book"></i> Course Management</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/students/departments"><i class="fa fa-graduation-cap"></i> Student Management</a>
                    </li>

                    <li>
                        <a class="active-menu" class="" href="${pageContext.request.contextPath}/admin/lecturers"><i class="fa fa-users"></i> Lecturer Management</a>
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
                            Course List Of <%= lecturer.getNameSurname() %>
                        </h1>
                    </div>
                </div>
                <!-- /. ROW  -->

                <div class="row">
                    <div class="col-md-12 col-xs-12 col-sm-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Lecturer Course List
                            </div>
                            <div class="panel-body">
                                <table class="table table-responsive">
                                    <thead>
                                        <th class="text-center">Course Code</th>
                                        <th class="text-center">Course Name</th>
										<th class="text-center">Lecture</th>
                                        <th class="text-center">Enrolled Student</th>
                                        <th></th>
                                    </thead>
                                    <tbody>
                                    <% for(CourseOfLecturer course: coursesOfLecturer){ %>
                                        <tr class="text-center">
                                            <td><%= course.getCode() %></td>
                                            <td><%= course.getName() %></td>
                                            <td><%= course.getLectureName() %></td>
                                            <td><%= course.getEnrolledStudent() %></td>
                                            <td>
                                                <a href="#" class="table-col-space-right">
                                                    <i class="fa fa-trash-o"></i>
                                                </a>
                                                <a href="${pageContext.request.contextPath}/admin/lecture/<%= course.getLectureID()%>/dashboard">
                                                    <i class="glyphicon glyphicon-chevron-right"></i>
                                                </a>
                                            </td>
                                        </tr>
                                        <% } %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

	 </div>
	
		<%@include file="script.jsp" %>
	


</body>

</html>
