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
        <nav class="navbar navbar-default top-navbar" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">BlackBoard</a>
            </div>
            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <span>Joseph Ledet &nbsp<i class="fa fa-caret-down"></i></span>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="settings.html"><i class="fa fa-user fa-fw"></i> Profile</a></li>
                        <li><a href="courses.html"><i class="fa fa-book fa-fw"></i> Courses</a></li>
                        <li><a href="enroll.html"><i class="fa fa-plus-square fa-fw"></i> Enrollment</a></li>
                        <li class="divider"></li>
                        <li><a href="#"><i class="fa fa-sign-out fa-fw"></i> Logout</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
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
	                    <a class="active-menu" href="${pageContext.request.contextPath}/lecturer/course-materials"><i class="fa fa-book"></i> Course Materials</a>
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
                        <h1 class="page-header"> Create New Grade <small>CS - 330 Intro. to Database System</small></h1>
                    </div>
                </div>
                <!-- /. ROW  -->
                <div class="row">
                  <div class="col-md-12">
                    <form class="" action="" method="post">
                        <div class="row">
                            <div class="col-md-3">
                                <div class="form-group">
                                    <input type="text" name="" value="" class="form-control" placeholder="Grade Name">
                                </div>
                            </div>
                            <div class="col-md-2">
                                <div class="input-group">
                                    <input type="text" name="" class="form-control" value="" placeholder="Affect">
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
                                            <tr>
                                                <td class="text-center">130201024</td>
                                                <td class="text-center">Umit Kas</td>
                                                <td class="text-right"><input type="text" name="" class="form-control grade-text" value="0"></td>
                                            </tr>
                                            <tr class="text-center new-grade-row">
                                                <td>130201004</td>
                                                <td>Mehmet Arici</td>
                                                <td class="text-right"><input type="text" name="" class="form-control grade-text" value="0"></td>
                                            </tr>
                                            <tr class="text-center new-grade-row">
                                                <td>130201026</td>
                                                <td>Murat Dogan</td>
                                                <td class="text-right"><input type="text" name="" class="form-control grade-text" value="0"></td>
                                            </tr>
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
