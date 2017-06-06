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
                        <a class="active-menu" href="${pageContext.request.contextPath}/student/dashboard"><i class="fa fa-tachometer"></i> Dashboard</a>
                    </li>
                    <li>
                        <a  href="${pageContext.request.contextPath}/student/courses"><i class="fa fa-book"></i> Courses</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/student/course-materials"><i class="fa fa-book"></i> Course Materials</a>
                    </li>

                    <li>
                        <a  href="${pageContext.request.contextPath}/student/grades"><i class="fa fa-table"></i> Grades</a>
                    </li>
                    <li>
                        <a  href="${pageContext.request.contextPath}/student/assignments"><i class="fa fa-pencil-square-o"></i> Assignments</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/student/settings"><i class="fa fa-cog"></i> Settings</a>
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
