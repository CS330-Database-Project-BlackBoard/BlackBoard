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
                        <a  href="bb-index.html"><i class="fa fa-dashboard"></i> Dashboard</a>
                    </li>
                    <li>
                        <a href="bb-user-management.html"><i class="fa fa-user"></i> User Management</a>
                    </li>
                    <li>
                        <a href="bb-course-management.html"><i class="fa fa-book"></i> Course Management</a>
                    </li>
                    <li>
                        <a href="bb-student-management.html"><i class="fa fa-graduation-cap"></i> Student Management</a>
                    </li>

                    <li>
                        <a class="active-menu" href="bb-lecturer-management.html"><i class="fa fa-users"></i> Lecturer Management</a>
                    </li>
                    <li>
                        <a href="bb-settings.html"><i class="fa fa-edit"></i> Settings</a>
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
                            Software Engineering Course Student List
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
                                          <tr class="text-center">
                                              <td>130201005</td>
                                              <td>Ahmet Kurt</td>
                                              <td>98</td>
                                              <td><a href="bb-student-course-grade.html"><i class="fa fa-chevron-right"></i></a></td>
                                          </tr>

                                          <tr class="text-center">
                                              <td>130201005</td>
                                              <td>Kamil Yunuz Ozkaya</td>
                                              <td>97.8</td>
                                              <td><a href="bb-student-course-grade.html"><i class="fa fa-chevron-right"></i></a></td>
                                          </tr>

                                          <tr class="text-center">
                                              <td>130201025</td>
                                              <td>Koray Ozyurt</td>
                                              <td>96.00</td>
                                              <td><a href="bb-student-course-grade.html"><i class="fa fa-chevron-right"></i></a></td>
                                          </tr>
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
