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
	                    <a class="active-menu" href="${pageContext.request.contextPath}/lecturer/dashboard"><i class="fa fa-dashboard"></i> Dashboard</a>
	                </li>
	                <li>
	                    <a  href="${pageContext.request.contextPath}/lecturer/courses"><i class="fa fa-user"></i> Courses</a>
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
                        <h1 class="page-header">Grades Of Students <small> Quiz 1 </small></h1>
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
                                          <tr class="text-center">
                                              <td>130201024</td>
                                              <td>Umit Kas</td>
                                              <td><input type="text" name="" class="form-control grade-text" value="35"></td>
                                          </tr>
                                          <tr class="text-center">
                                              <td>130201004</td>
                                              <td>Mehmet Arici</td>
                                              <td><input type="text" name="" class="form-control grade-text" value="85"></td>
                                          </tr>
                                          <tr class="text-center">
                                              <td>130201026</td>
                                              <td>Murat Dogan</td>
                                              <td><input type="text" name="" class="form-control grade-text" value="56"></td>
                                          </tr>
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

        <div id="update-grade" class="modal fade" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <div class="modal-title"><strong>Update Grade</strong></div>
                    </div>
                    <div class="modal-body">
                        <form method="post">
                            <div class="row">
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="" value="" placeholder="Student Id" readonly>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="" value="" placeholder="Course Name" readonly>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="" value="" placeholder="Grade Name" readonly>
                                    </div>
                                </div>
                                <div class="col-md-2">
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="" value="" placeholder="Grade">
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

	   	<%@ include file="script.jsp" %>
	
    </body>

</html>
