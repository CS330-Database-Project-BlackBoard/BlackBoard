<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Blackboard - Dashboard</title>
	
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
                    <a class="active-menu" href="${pageContext.request.contextPath}/lecturer/dashboard"><i class="fa fa-dashboard"></i> Dashboard</a>
                </li>

                <li>
                    <a href="${pageContext.request.contextPath}/lecturer/course-materials"><i class="fa fa-book"></i> Course Materials</a>
                </li>
                <li>
                    <a  href="${pageContext.request.contextPath}/lecturer/grades"><i class="fa fa-graduation-cap"></i> Grades</a>
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
                        <h1 class="page-header">Dashboard <small> LMS Blackboard Of AIU</small></h1>
                    </div>
                </div>
                <!-- /. ROW  -->
                <div class="row">
                    <div class="col-md-7 col-sm-12 col-xs-12">
                        <div class="panel panel-danger">
                            <div class="panel-heading">System Announcements</div>
                            <div class="panel-body">
                                <div class="list-group">
                                    <a class="list-group-item">
                                      <span class="badge">7 minutes ago</span>
                                      <i class="fa fa-fw fa-comment"></i> Commented on a post
                                    </a>
                                    <a class="list-group-item">
                                        <span class="badge">16 minutes ago</span>
                                        <i class="fa fa-fw fa-truck"></i> Order 392 shipped
                                    </a>
                                    <a class="list-group-item">
                                        <span class="badge">36 minutes ago</span>
                                        <i class="fa fa-fw fa-globe"></i> Invoice 653 has paid
                                    </a>
                                    <a class="list-group-item">
                                        <span class="badge">1 hour ago</span>
                                        <i class="fa fa-fw fa-user"></i> A new user has been added
                                    </a>
                                    <a class="list-group-item">
                                        <span class="badge">1.23 hour ago</span>
                                        <i class="fa fa-fw fa-user"></i> A new user has added
                                    </a>
                                    <a class="list-group-item">
                                        <span class="badge">yesterday</span>
                                        <i class="fa fa-fw fa-globe"></i> Saved the world
                                    </a>
                                </div>
                                <div class="text-right">
                                    <a href="announcment.html">More Announcments <i class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-5 col-sm-12 col-xs-12">
                        <div class="panel panel-danger">
                            <div class="panel-heading">Courses</div>
                            <div class="panel-body">
                                <div class="list-group">
                                    <a href="course-details.html" class="list-group-item">
                                        <i class="fa fa-fw fa-bookmark"></i> CS 330 - Intro. to Database System
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <i class="fa fa-fw fa-bookmark"></i> CS 306 - Software Engineering
                                    </a>

                                </div>
                                <div class="text-right">
                                    <a href="courses.html">View Courses <i class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div>
                         </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

		<%@ include file="script.jsp" %>
	
  </body>
</html>
