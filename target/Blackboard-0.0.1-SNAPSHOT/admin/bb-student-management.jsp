<%@page import="pojos.Role"%>
<%@page import="pojos.Student"%>
<%@page import="java.util.ArrayList"%>
<% ArrayList<Student> students = (ArrayList<Student>) session.getAttribute("students"); %>


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
                    <a href="${pageContext.request.contextPath}/admin/dashboard"><i class="fa fa-dashboard"></i> Dashboard</a>
                </li>
                <li>
                    <a  href="${pageContext.request.contextPath}/admin/managers"><i class="fa fa-user"></i> User Management</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/admin/courses"><i class="fa fa-book"></i> Course Management</a>
                </li>
                <li>
                    <a class="active-menu" href="${pageContext.request.contextPath}/admin/students"><i class="fa fa-graduation-cap"></i> Student Management</a>
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
                        Students
                    </h1>
                </div>

            </div>
            <!-- /. ROW  -->

            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Students
                        </div>
                        <div class="panel-body">
                            <table class="table table-responsive">
                                <thead >
                                <th class="text-center">E-Mail</th>
                                <th class="text-center">Name Surname</th>
                                <th></th>
                                </thead>
                                <tbody>
                                <% for(Student student : students){ %>
                                <tr class="text-center">
                                    <td><%= student.getEmail() %></td>
                                    <td><%= student.getNameSurname() %></td>
                                </tr>

                                <% } %>

                                </tbody>

                            </table>
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
</div>


<%@include file="script.jsp" %>
</body>

</html>
