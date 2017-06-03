
<%@page import="pojos.Anouncment"%>
<%@page import="pojos.LectureDashboard"%>
<% LectureDashboard lectureDashboard = (LectureDashboard) session.getAttribute("lectureDashboard"); %>

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
                        <a class="active-menu" href="${pageContext.request.contextPath}/admin/courses"><i class="fa fa-book"></i> Course Management</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/students"><i class="fa fa-graduation-cap"></i> Student Management</a>
                    </li>

                    <li>
                        <a  class="" href="${pageContext.request.contextPath}/admin/lecturers"><i class="fa fa-users"></i> Lecturer Management</a>
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
                            <%= lectureDashboard.getCourse().getName() %> Course Detail
                        </h1>
                    </div>
                </div>
                <!-- /. ROW  -->

                <div class="row">
                    <div class="col-md-10 col-md-offset-1">
                        <div class="row">
                            <div class="col-md-6 col-sm-6 col-xs-6">
                                <div class="panel panel-primary text-center no-boder bg-color-dgray">
                                    <div class="panel-body">
                                        <i class="fa fa-pencil-square-o fa-5x"></i>
                                        <h3><%= lectureDashboard.getGradeCount() %></h3>
                                    </div>
                                    <div class="panel-footer back-footer-dgray">
                                        <a class="white-link" href="${pageContext.request.contextPath}/admin/lecture/<%=lectureDashboard.getLectureID()%>/grades"> Grades</a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 col-sm-6 col-xs-6">
                                <div class="panel panel-primary text-center no-boder bg-color-dblue">
                                    <div class="panel-body">
                                        <i class="fa fa-mortar-board fa-5x"></i>
                                        <h3><%= lectureDashboard.getEnrolledStudentCount() %></h3>
                                    </div>
                                    <div class="panel-footer back-footer-dblue">
                                        <a class="white-link" href="${pageContext.request.contextPath}/admin/lecture/<%=lectureDashboard.getLectureID()%>/students">Students</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                          <div class="panel-heading">
                            <h3 class="panel-title">Course Anouncments</h3>
                          </div>
                          <div class="panel-body">
                            <div class="list-group">
                            <%for(Anouncment anouncment: lectureDashboard.getAnouncments()){ %>
                            
                                <a href="${pageContext.request.contextPath}/admin/anouncment/<%=anouncment.getAnouncmentID() %>" class="list-group-item"><%= anouncment.getTitle() %>
                                    <span class="badge">yesterday</span>
                                </a>
                                <%} %>
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
