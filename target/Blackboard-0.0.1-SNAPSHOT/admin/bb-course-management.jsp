
<%@page import="pojos.Course"%>
<%@page import="pojos.CourseDashboard"%>
<% CourseDashboard courseDashboard = (CourseDashboard) session.getAttribute("courseDashboard"); %>

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
                        <a   href="${pageContext.request.contextPath}/admin/managers"><i class="fa fa-user"></i> User Management</a>
                    </li>
                    <li>
                        <a class="active-menu" href="${pageContext.request.contextPath}/admin/courses"><i class="fa fa-book"></i> Course Management</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/students/departments"><i class="fa fa-graduation-cap"></i> Student Management</a>
                    </li>

                    <li>
                        <a class="" href="${pageContext.request.contextPath}/admin/lecturers/"><i class="fa fa-users"></i> Lecturer Management</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/settings"><i class="fa fa-edit"></i> Settings</a>
                    </li>

            </div>

        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
            <div id="page-inner">


                <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">
                            Course Management
                        </h1>
                    </div>
                </div>
                <!-- /. ROW  -->

                <div class="row">
                    <div class="col-md-10 col-md-offset-1 col-sm-12 col-xs-12">
                        <div class="row">
                            <div class="col-md-6 col-sm-6 col-xs-6">
                                <div class="panel panel-primary text-center no-boder bg-color-dblue">
                                    <div class="panel-body">
                                        <i class="fa fa-book fa-5x"></i>
                                        <%= courseDashboard.getActiveCourseCount() %>
                                    </div>
                                    <div class="panel-footer back-footer-dblue">
                                        Active Courses
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 col-sm-6 col-xs-6">
                                <div class="panel panel-primary text-center no-boder bg-color-dred">
                                    <div class="panel-body">
                                        <i class="fa fa-history fa-5x"></i>
                                        <%= courseDashboard.getInactiveCourseCount() %>

                                    </div>
                                    <div class="panel-footer back-footer-dred">
                                        Inactive Courses
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>

                <hr>

                <div class="row bottom-space">
                    <div class="col-md-12">
                        <button class="btn btn-success" type="button" name="button" data-toggle="modal" data-target="#new-manager"><i class="fa fa-plus fa"></i> New Course</button>
                    </div>
                </div>

                <div class="panel panel-default">
                    <div class="panel-heading">
                            Active Courses
                    </div>
                    <div class="panel-body">
                        <table class="table table-responsive">
                            <thead>
                                <th class="text-center">Course Code</th>
                                <th class="text-center">Course Title</th>
                                <th class="text-center">Lecture</th>
                                <th class="text-center">Lecturer</th>
                                <th class="text-center"></th>
                            </thead>
                            <tbody>
                            	<% for(Course course : courseDashboard.getCourses()){ %>
                            	
                                <tr class="text-center">
                                    <td><%= course.getCode() %></td>
                                    <td><%= course.getName() %></td>
                                    <td><%= course.getLectureName() %></td>
                                    <td><%= course.getLecturerInf() %></td>
                                    <td>
                                        <button type="button" class="btn btn-success" name="button">Manage</button>
                                    </td>
                                </tr>
								<% } %>
                                
                            </tbody>
                        </table>
                    </div>
                </div>


            </div><!-- /. PAGE INNER  -->
        </div><!-- /. WRAPPER  -->
	<form action="" method="post" id="new-course">
		
        <div id="new-manager" class="modal fade" tabindex="-1" role="dialog">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">New Course</h4>
              </div>
              <div class="modal-body">
                  <div class="row">
                      <div class="col-md-3">
                          <div class="form-group">
                          	   <div class="">
                              		<input type="text" class="form-control capital" name="course-code" value="" placeholder="Code" id="search-course-code">
                          		</div>
                          </div>
                      </div>
                      <div class="col-md-3">
                          <div class="form-group">
                              <input type="text" class="form-control capital" name="course-lecture" value="" placeholder="Lecture">
                          </div>
                      </div>
                      <div class="col-md-6">
                          <div class="form-group">
                              <input type="text" class="form-control" name="course-name" value="" placeholder="Course Name" id="search-course-name" readonly>
                          </div>
                      </div>
                  </div>
                  <div class="row">
                      <div class="col-md-6">
                          <div class="form-group">
                              <input type="text" class="form-control capital" name="lecturer" value="" placeholder="Lecturer" id="search-lecturer">
                          </div>
                      </div>
                      <div class="col-md-6">
                          <div class="form-group">
                              <input type="text" class="form-control capital" name="lecturer-email" value="" placeholder="Lecturer E-MAIL" id="search-lecturer-email">
                          </div>
                     </div>
                  </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <button type="button" class="btn btn-primary" id="save-course">Save</button>
              </div>
            </div><!-- /.modal-content -->
          </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
    </div>

	</form>>
	

	<%@include file="script.jsp" %>
</body>

</html>
