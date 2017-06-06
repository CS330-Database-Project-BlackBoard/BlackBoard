<%@ page import="pojos.StudentGradeView" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="pojos.SimpleGrade" %>

<% ArrayList<StudentGradeView> gradeView = (ArrayList<StudentGradeView>) session.getAttribute("gradeView");%>
<% SimpleGrade gradeName = (SimpleGrade) session.getAttribute("grade"); %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Blackboard - Grades</title>
    <%@ include file="style.jsp" %>

</head>
<body>
<div id="wrapper">
    <%@ include file="bb-head.jsp" %>
    <!--/. NAV TOP  -->
    <nav class="navbar-default navbar-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">
                <li>
                    <a href="${pageContext.request.contextPath}/lecturer/dashboard"><i class="fa fa-dashboard"></i> Dashboard</a>
                </li>
                <li>
                    <a  href="${pageContext.request.contextPath}/lecturer/courses"><i class="fa fa-user"></i> Courses</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/lecturer/course-materials"><i class="fa fa-book"></i> Course Materials</a>
                </li>
                <li>
                    <a class="active-menu" href="${pageContext.request.contextPath}/lecturer/grades"><i class="fa fa-graduation-cap"></i> Grades</a>
                </li>

                <li>
                    <a class="" href="${pageContext.request.contextPath}/lecturer/assignments"><i class="fa fa-users"></i> Assignments</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/lecturer/settings"><i class="fa fa-edit"></i> Settings</a>
                </li>
            </ul>
        </div>
    </nav>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper">
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-header">Grades Of Students <small> <%= gradeName.getName() %></small></h1>
                </div>
            </div>
            <!-- /. ROW  -->
            <div class="row">
                <div class="col-md-12">
                    <form class="" action="" method="post">
                        <div class="panel panel-danger">
                            <div class="panel-heading">
                                <h3 class="panel-title">Student List</h3>
                            </div>
                            <div class="panel-body">
                                <table class="table table-responsive">
                                    <thead>
                                    <th class="text-center">Student ID</th>
                                    <th class="text-center">Student Name</th>
                                    <th class="text-center">Grade</th>
                                    </thead>
                                    <tbody>
                                    <% for (StudentGradeView grade : gradeView){ %>
                                    <tr class="text-center">
                                        <td class="text-center"><%= grade.getStudentID() %></td>
                                        <td class="text-center"><%= grade.getNameSurname() %></td>
                                        <td class="text-center"><input type="text" size="4" name="<%= grade.getStudentID() %>" class="form-control grade-text" value="<%= grade.getGrade() %>"></td>
                                    </tr>
                                    <% } %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <button type="submit" name="button" class="btn btn-success pull-right"> Save </button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <%@ include file="script.jsp" %>

</body>

</html>
