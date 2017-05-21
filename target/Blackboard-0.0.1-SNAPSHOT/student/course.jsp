<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Blackboard - Dashboard</title>
    <!-- Bootstrap Styles-->
			<%@include file="style.jsp" %>
	
</head>

<body>
    <div id="wrapper">
             	<%@include file="head.jsp" %>
       
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
                        <a class="active-menu" href="bb-student-management.html"><i class="fa fa-graduation-cap"></i> Student Management</a>
                    </li>

                    <li>
                        <a href="bb-lecturer-management.html"><i class="fa fa-table"></i> Lecturer Management</a>
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
                            Student Management
                        </h1>
                    </div>
                </div>
                <!-- /. ROW  -->

                <div class="row">
                    <div class="col-md-12 col-xs-12 col-sm-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Departments
                            </div>
                            <div class="panel-body">
                                <div class="list-group">

                                    <a href="bb-student-management-faculty.html" class="list-group-item">
                                        <span class="badge">150 students</span>
                                        <i class="fa fa-fw fa-graduation-cap"></i> Law School
                                    </a>

                                    <a href="bb-student-management-faculty.html" class="list-group-item">
                                        <span class="badge">300 students</span>
                                        <i class="fa fa-fw fa-graduation-cap"></i> Engineering Faculty
                                    </a>

                                    <a href="bb-student-management-faculty.html" class="list-group-item">
                                        <span class="badge">150 students</span>
                                        <i class="fa fa-fw fa-graduation-cap"></i> School of Fine arts Architecture
                                    </a>

                                    <a href="bb-student-management-faculty.html" class="list-group-item">
                                        <span class="badge">600 students</span>
                                        <i class="fa fa-fw fa-graduation-cap"></i> School of Foreign Languages
                                    </a>

                                    <a href="bb-student-management-faculty.html" class="list-group-item">
                                        <span class="badge">150 students</span>
                                        <i class="fa fa-fw fa-graduation-cap"></i> Law Faculty
                                    </a>


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
