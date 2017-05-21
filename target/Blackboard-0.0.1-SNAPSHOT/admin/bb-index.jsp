<!DOCTYPE html>
<%@page import="pojos.Anouncment"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="pojos.Dashboard"%>
<html xmlns="http://www.w3.org/1999/xhtml">

<% Dashboard dashboard = (Dashboard) session.getAttribute("dashboard"); %>

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
                        <a class="active-menu" href="${pageContext.request.contextPath}/admin/dashboard"><i class="fa fa-dashboard"></i> Dashboard</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/managers"><i class="fa fa-user"></i> User Management</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/courses"><i class="fa fa-book"></i> Course Management</a>
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
                            Dashboard <small>Summary of Blackboard System</small>
                        </h1>
                    </div>
                </div>
                <!-- /. ROW  -->

                <div class="row">
                    <div class="col-md-3 col-sm-12 col-xs-12">
                        <div class="panel panel-primary text-center no-boder bg-color-dgray">
                            <div class="panel-body">
                                <i class="fa fa-user fa-5x"></i>
                                <h3><%= dashboard.getManagerCount() %></h3>
                            </div>
                            <div class="panel-footer back-footer-dgray">
                                <a class="white-link" href="${pageContext.request.contextPath}/admin/managers"> Blackboard Managers</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-12 col-xs-12">
                        <div class="panel panel-primary text-center no-boder bg-color-dblue">
                            <div class="panel-body">
                                <i class="fa fa-book fa-5x"></i>
                                <h3><%= dashboard.getCourseCount() %></h3>
                            </div>
                            <div class="panel-footer back-footer-dblue">
                                <a class="white-link" href="${pageContext.request.contextPath}/admin/courses">Courses</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-12 col-xs-12">
                        <div class="panel panel-primary text-center no-boder bg-color-dred">
                            <div class="panel-body">
                                <i class="fa fa-users fa-5x"></i>
                                <h3><%= dashboard.getLecturerCount() %></h3>
                            </div>
                            <div class="panel-footer back-footer-dred">
                                <a class="white-link" href="${pageContext.request.contextPath}/admin/lecturers">Lecturers</a>


                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-12 col-xs-12">
                        <div class="panel panel-primary text-center no-boder bg-color-dbrown">
                            <div class="panel-body">
                                <i class="fa fa-graduation-cap fa-5x" aria-hidden="true"></i>

                                <h3><%= dashboard.getStudentCount() %> </h3>
                            </div>
                            <div class="panel-footer back-footer-dbrown">
                                <a class="white-link" href="${pageContext.request.contextPath}/admin/students">Students</a>


                            </div>
                        </div>
                    </div>
                </div>


                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                System Anouncments
                            </div>
                            <div class="panel-body">
                                <div class="list-group">
									<% for(Anouncment anouncment : dashboard.getAnouncments()){ %>
                                    <a href="#" class="list-group-item">
                                        <span class="badge">7 minutes ago</span>
                                        <i class="fa fa-fw fa-comment"></i> <%= anouncment.getTitle() %>
                                    </a>
                                	<% } %>
                                </div>
                                <div class="text-right">
                                    <a href="#">More Anouncments <i class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <!-- /. ROW  -->
            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>

		<%@include file="script.jsp" %>
	


</body>

</html>
