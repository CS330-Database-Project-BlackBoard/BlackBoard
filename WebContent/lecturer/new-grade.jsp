
<%@page import="pojos.Course"%>
<%@page import="pojos.Student"%>
<%@page import="java.util.ArrayList"%>

<% Course course = (Course) session.getAttribute("course"); %>
<% ArrayList<Student> students = (ArrayList<Student>) session.getAttribute("students"); %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Blackboard - New Grade</title>
	
	<%@ include file ="style.jsp" %>
	

  </head>

  <body>
    <div id="wrapper">
       <%@ include file="bb-head.jsp" %>
        <!--/. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
	         	        
			 <ul class="nav" id="main-menu">
                <li>
                    <a  href="${pageContext.request.contextPath}/lecturer/dashboard"><i class="fa fa-dashboard"></i> Dashboard</a>
                </li>
                <li>
                    <a  href="${pageContext.request.contextPath}/lecturer/courses"><i class="fa fa-user"></i> Courses</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/lecturer/course-materials"><i class="fa fa-book"></i> Course Materials</a>
                </li>
                <li>
                    <a class="active-menu"  href="${pageContext.request.contextPath}/lecturer/grades"><i class="fa fa-graduation-cap"></i> Grades</a>
                </li>

                <li>
                    <a class="" href="${pageContext.request.contextPath}/lecturer/assignments"><i class="fa fa-users"></i> Assignments</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/lecturer/settings"><i class="fa fa-edit"></i> Settings</a>
                </li
            </div>
        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header"> Create New Grade <small><%= course.getCode() %> - <%= course.getName() %> </small></h1>
                    </div>
                </div>
                <!-- /. ROW  -->
                <div class="row">
                  <div class="col-md-12">
                    <form class="" action="" method="post">
                        <div class="row">
                            <div class="col-md-3">
                                <div class="form-group">
                                    <input type="text" name="grade-name" value="" class="form-control" placeholder="Grade Name" required>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <div class="input-group">
                                    <input type="text" name="grade-affect" class="form-control" value="" placeholder="Affect" required>
                                    <span class="input-group-addon">%</span>
                                </div>
                            </div>
                            <div class="col-md-7">
                                <button type="submit" name="button" class="btn btn-success pull-right"> Save </button>
                            </div>
                        </div>

                          <div class="panel panel-default">
                                <div class="panel-heading">
                                  <h3 class="panel-title">Student List</h3>
                                </div>
                                <div class="panel-body">
                                    <table class="table table-responsive">
                                        <thead>
                                            <th class="text-center">Student ID</th>
                                            <th class="text-center">Student Name</th>
                                            <th class="text-right">Grade</th>
                                        </thead>
                                        <tbody>
                                        	<% for(Student student : students){ %>
                                            <tr>
                                                <td class="text-center"><%= student.getSchoolID() %></td>
                                                <td class="text-center"><%= student.getNameSurname() %></td>
                                                <td class="text-right"><input type="text" name="<%= student.getSchoolID() %>" class="form-control grade-text" value="0" required></td>
                                            </tr>
                                           <%} %>
                                        </tbody>
                                    </table>
                                </div>
                          </div>
                      </form>
                  </div>
              </div>
          </div>
      </div>
	
	<%@ include file ="script.jsp" %>

  </body>

</html>
