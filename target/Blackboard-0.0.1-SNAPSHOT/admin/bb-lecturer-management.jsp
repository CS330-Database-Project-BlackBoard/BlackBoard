
<%@page import="pojos.Lecturer"%>
<%@page import="java.util.ArrayList"%>
<% ArrayList<Lecturer> lecturers = (ArrayList<Lecturer>) session.getAttribute("lecturers"); %>

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
                        Lecturer Management
                        </h1>
                    </div>
                </div>
                <!-- /. ROW  -->

    

                <div class="row">
                    <div class="col-md-12">

                        <div class="panel panel-default">
                          <div class="panel-heading">
                              Lecturers
                              <form class="" action="" method="post">
                                  <div class="row">
                                      <div class="col-md-1 pull-right">
                                          <button type="button" name="button" class="btn btn-info">Filter</button>
                                      </div>
                                      <div class="col-md-3 pull-right">
                                          <div class="form-group">
                                              <input type="text" class="form-control" name="" value="" placeholder="Search">
                                          </div>
                                      </div>
                                  </div>

                              </form>
                          </div>
                          <div class="panel-body">

                              <table class="table table-responsive">
                                  <thead>
                                      <th class="text-center">Lecturer ID</th>
                                      <th class="text-center">Lecturer Name</th>
                                      <th class="text-center">Lecturer Email</th>
                                      <th></th>
                                  </thead>
                                  <tbody>
                                  <%for(Lecturer lecturer: lecturers){ %>
                                      <tr class="text-center">
                                          <td><%= lecturer.getSchoolID() %></td>
                                          <td><%= lecturer.getNameSurname()%></td>
                                          <td><%= lecturer.getEmail() %></td>
                                          <td>
                                              <a href="${pageContext.request.contextPath}/admin/lecturer/<%= lecturer.getSchoolID() %>"><i class="fa fa-chevron-right"></i></a>
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
    <!-- /. WRAPPER  -->
    
    <%@include file="script.jsp" %>


</body>

</html>
