
<%@page import="pojos.StudentGradeView"%>
<%@page import="java.util.ArrayList"%>


<% ArrayList<StudentGradeView> lectureGradeView = (ArrayList<StudentGradeView>) session.getAttribute("lectureGradeView");%>

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
                        <a   href="${pageContext.request.contextPath}/admin/courses"><i class="fa fa-book"></i> Course Management</a>
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
							Class List
                        </h1>
                    </div>
                </div>
                <!-- /. ROW  -->

                <div class="row">
                    <div class="col-md-12 col-xs-12 col-sm-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Grades
                            </div>
                            <div class="panel-body">
                                <table class="table table-responsive">
                                    <thead>
                                        <th class="text-center">Grade Name</th>
                                        <th class="text-center">Grade</th>
                                        <th class="text-center">Average</th>
                                        <th></th>
                                    </thead>
                                    <tbody>
 									<% for(StudentGradeView grade : lectureGradeView){ %>
                                        <tr class="text-center">
                                            <td><%= grade.getStudentID() %></td>
                                            <td><%= grade.getNameSurname() %></td>
                                            <td><%= grade.getGrade() %></td>
                                            <td>
                                                <a data-toggle="modal" href="#update-grade" class="">
                                                    <i class="fa fa-pencil"></i>
                                                </a>
                                            </td>
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


    <div id="update-grade" class="modal fade" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <div class="modal-title">
                        Update Grade
                    </div>
                </div>
                <div class="modal-body">
                    <form class="" action="" method="post">
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <input type="text" class="form-control" name="" value="" placeholder="Student Id" readonly>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <input type="text" class="form-control" name="" value="" placeholder="Course Name" readonly>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <div class="form-group">
                                    <input type="text" class="form-control" name="" value="75">
                                </div>
                            </div>
                        </div>

                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-dismiss="modal" name="button">Cancel</button>
                    <button type="button" class="btn btn-success" data-dismiss="modal" name="button">Save</button>
                </div>

            </div>

        </div>
    </div>

	<%@include file="script.jsp" %>



</body>

</html>
