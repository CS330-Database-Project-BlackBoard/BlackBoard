<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Blackboard - Assignments</title>
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
                   		 <a href="${pageContext.request.contextPath}/student/dashboard"><i class="fa fa-tachometer"></i> Dashboard</a>
                    </li>
                    <li>
                   		 <a href="${pageContext.request.contextPath}/student/courses"><i class="fa fa-book"></i> Courses</a>
                    </li>
                    <li>
                    	<a href="${pageContext.request.contextPath}/student/grades"><i class="fa fa-table"></i> Grades</a>
                    </li>
                    <li>
                   		 <a class="active-menu" href="${pageContext.request.contextPath}/student/assignments"><i class="fa fa-pencil-square-o"></i> Assignments</a>
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
                          Assignments <small> Assignments at Spring - 2017</small>
                      </h1>
                  </div>
              </div>
              <ul class="nav nav-pills nav-stacked col-md-4">
                <li class="active"><a href="#tab_all" data-toggle="pill"><strong>All Assignments   </strong><i class="fa fa-bell-o"></i></a></li>
                <li><a href="#tab_a" data-toggle="pill"><strong>CS 330 - </strong>Into. to Database System  <i class="fa fa-bell-o"></i></a></li>
                <li><a href="#tab_b" data-toggle="pill"><strong>CS 306 - </strong>Software Engineering</a></li>
              </ul>
              <div class="tab-content col-md-8">
                <div class="tab-pane active" id="tab_all">
                  <div class="panel panel-default">
                    <div class="panel-body">
                      <div class="row">
                        <table class="table table-hover">
                          <tbody>
                            <tr>
                              <td>
                                <label><strong>CS 330 - Intro. to Database System</strong></label>
                                <br>
                                <small class="text-muted">Assignment 1</small>
                                <br>
                                <small class="text-muted">Due Date</small>
                                <br>
                                <small class="text-muted">Submission</small>

                              </td>
                              <td class=" text-right">
                                <br>
                                <br>
                                <small class="text-info">04/22/17</small>
                                <br>
                                <strong><i class="fa fa-check-circle fa-lg icongreencolor"></i></strong>
                                <br>
                                <a class="" href="#">assignment1.pdf</a>
                              </td>
                            </tr>
                            <tr>
                              <td>
                                <label><strong>CS 306 - Software Engineering</strong></label>
                                <br>
                                <small class="text-muted">Assignment 2</small>
                                <br>
                                <small class="text-muted">Due Date</small>
                                <br>
                                <small class="text-muted">Submission</small>
                              </td>
                              <td class=" text-right">
                                <br>
                                <br>
                                <small>05/22/17</small>
                                <br>
                                <strong><i class="fa fa-times-circle fa-lg iconredcolor"></i></strong>
                              </td>
                            </tr>
                          </tbody>
                        </table>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="tab-pane" id="tab_a">
                  <div class="panel panel-default">
                    <div class="panel-body">
                      <div class="row">
                        <table class="table table-hover">
                          <tbody>
                            <tr>
                              <td>
                                <label><strong>Assignment 1</strong></label>
                                <br>
                                <small class="text-muted">Due Date</small>
                                <br><br>
                                <small class="text-muted">Assignment File</small>
                                <br><br>
                                <small class="text-muted">Submitted File</small>
                              </td>
                              <td class=" text-right">
                                <br>
                                <small>04/22/17</small>
                                <br><br>
                                <a href="bb.png" download type="button" class="btn btn-success btn-sm"><i class="fa fa-cloud-download"></i></a>
                                <br><br>
                                <a href="upload.html" type="button" class="btn btn-danger btn-sm"><i class="fa fa-cloud-upload"></i></a>
                              </td>
                            </tr>
                          </tbody>
                        </table>
                      </div>
                    </div>
                  </div>
                </div>
                  <div class="tab-pane" id="tab_b">
                    <div class="panel panel-default">
                      <div class="panel-body">
                        <div class="row">
                          <table class="table table-hover">
                            <tbody>
                              <tr>
                                <td>
                                  <label><strong>Assignment 2</strong></label>
                                  <br>
                                  <small class="text-muted">Due Date</small>
                                  <br><br>
                                  <small class="text-muted">Assignment File</small>
                                  <br><br>
                                  <small class="text-muted">Submitted File</small>
                                </td>
                                <td class=" text-right">
                                  <br>
                                  <small>05/15/17</small>
                                  <br><br>
                                  <a href="bb.png" download type="button" class="btn btn-success btn-sm"><i class="fa fa-cloud-download"></i></a>
                                  <br><br>
                                  <a type="button" class="btn btn-danger btn-sm"><i class="fa fa-cloud-upload"></i></a>
                                </td>
                              </tr>
                            </tbody>
                          </table>
                        </div>
                      </div>
                    </div>
                  </div>
              </div><!-- tab content -->
            </div>
        </div>
    </div>

	<%@include file="script.jsp" %>



</body>

</html>
