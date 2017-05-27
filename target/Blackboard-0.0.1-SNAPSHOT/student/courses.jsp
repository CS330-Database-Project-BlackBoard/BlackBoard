<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Blackboard - Courses</title>
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
                   		 <a class="active-menu" href="${pageContext.request.contextPath}/student/courses"><i class="fa fa-book"></i> Courses</a>
                    </li>
                    <li>
                    	<a href="${pageContext.request.contextPath}/student/grades"><i class="fa fa-table"></i> Grades</a>
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
                          Course Details <small> LMS Blackboard Of AIU</small>
                      </h1>
                  </div>
              </div>
              <ul class="nav nav-pills nav-stacked col-md-4">
                <li class="active"><a href="#CS330" data-toggle="pill"><strong>CS 330 - </strong>Into. to Database System</a></li>
                <li><a href="#CS306" data-toggle="pill"><strong>CS 306 - </strong>Software Engineering</a></li>
              </ul>
              <div class="tab-content">
                <div class="tab-pane active" id="CS330">
                  <div class="col-md-4">
                    <div class="panel panel-danger">
                      <div class="panel-heading">Introduction to Database System</div>
                      <div class="panel-body">
                        <table class="table table-responsive">
                          <tbody>
                            <tr>
                              <td><label class="text-muted">Course Code: </label></td>
                              <td><label class="text-muted text">CS 330</label></td>
                            </tr>
                            <tr>
                              <td><label class="text-muted">Lecturer: </label></td>
                              <td><label class="text-muted">Joseph Ledet</label></td>
                            </tr>
                            <tr>
                              <td><label class="text-muted">Assistant: </label></td>
                              <td><label class="text-muted">Serhan Aksoy</label></td>
                            </tr>
                            <tr>
                              <td><label class="text-muted">Section: </label></td>
                              <td><label class="text-muted">Lecture1</label></td>
                            </tr>
                            <tr>
                              <td><label class="text-muted">Term: </label></td>
                              <td><label class="text-muted">Spring - 2017</label></td>
                            </tr>
                            <tr>
                              <td><label class="text-muted">Syllabus : </label></td>
                              <td><label class="text-muted"><a href="bb.png" download><i class="fa fa-cloud-download fa-2x"></a></label></td>
                            </tr>
                          </tbody>
                        </table>
                      </div>
                    </div>
                  </div>
                  <div class="col-md-4">
                    <div class="panel panel-danger">
                      <div class="panel-heading">Course Members</div>
                      <div class="panel-body">
                        <div class="scroll">
                          <table class="table table-hover table-responsive">
                            <tbody>
                              <tr>
                                <td><img style="max-height: 30px; max-width: 50px;" src="assets/user.png" alt="" class="circle"></td>
                                <td><strong>Mehmet Arici</strong></td>
                              </tr>
                              <tr>
                                <td><img style="max-height: 30px; max-width: 50px;" src="assets/user.png" alt="" class="circle"></td>
                                <td><strong>Murat Dogan</strong></td>
                              </tr>
                              <tr>
                                <td><img style="max-height: 30px; max-width: 50px;" src="assets/user.png" alt="" class="circle"></td>
                                <td><strong>Ümit Kas</strong></td>
                              </tr>
                              <tr>
                                <td><img style="max-height: 30px; max-width: 50px;" src="assets/user.png" alt="" class="circle"></td>
                                <td><strong>Cok Yakısıklı Koray Ozyurt</strong></td>
                              </tr>
                              <tr>
                                <td><img style="max-height: 30px; max-width: 50px;" src="assets/user.png" alt="" class="circle"></td>
                                <td><strong>Ertugrul Celik</strong></td>
                              </tr>
                              </tbody>
                            </table>
                          </div>
                        </div>
                      </div>
                  </div>
                </div>
                <div class="tab-pane" id="CS306">
                  <div class="col-md-4">
                    <div class="panel panel-danger">
                      <div class="panel-heading">Software</div>
                      <div class="panel-body">
                        <table class="table table-responsive">
                          <tbody>
                            <tr>
                              <td><label class="text-muted">Course Code: </label></td>
                              <td><label class="text-muted"> CS 330</label></td>
                            </tr>
                            <tr>
                              <td><label class="text-muted"> Lecturer : </label></td>
                              <td><label class="text-muted"> Joseph Ledet</label></td>
                            </tr>
                            <tr>
                              <td><label class="text-muted"> Assistant : </label></td>
                              <td><label class="text-muted"> Serhan Aksoy</label></td>
                            </tr>
                            <tr>
                              <td><label class="text-muted"> Section : </label></td>
                              <td><label class="text-muted"> Lecture1</label></td>
                            </tr>
                            <tr>
                              <td><label class="text-muted"> Term : </label></td>
                              <td><label class="text-muted"> Spring - 2017</label></td>
                            </tr>
                            <tr>
                              <td><label class="text-muted"> Syllabus : </label></td>
                              <td><label class="text-muted"><a href="bb.png" download><i class="fa fa-cloud-download fa-2x"></a></label></td>
                            </tr>
                          </tbody>
                        </table>
                      </div>
                    </div>
                  </div>
                  <div class="col-md-4">
                    <div class="panel panel-danger">
                      <div class="panel-heading">Course Members</div>
                      <div class="panel-body">
                        <div class="scroll">
                          <table class="table table-hover table-responsive">
                            <tbody>
                              <tr>
                                <td><img style="max-height: 30px; max-width: 50px;" src="assets/user.png" alt="" class="circle"></td>
                                <td><strong>Mehmet Arici</strong></td>
                              </tr>
                              <tr>
                                <td><img style="max-height: 30px; max-width: 50px;" src="assets/user.png" alt="" class="circle"></td>
                                <td><strong>Murat Dogan</strong></td>
                              </tr>
                              <tr>
                                <td><img style="max-height: 30px; max-width: 50px;" src="assets/user.png" alt="" class="circle"></td>
                                <td><strong>Ümit Kas</strong></td>
                              </tr>
                              <tr>
                                <td><img style="max-height: 30px; max-width: 50px;" src="assets/user.png" alt="" class="circle"></td>
                                <td><strong>Cok Yakısıklı Koray Ozyurt</strong></td>
                              </tr>
                              <tr>
                                <td><img style="max-height: 30px; max-width: 50px;" src="assets/user.png" alt="" class="circle"></td>
                                <td><strong>Ertugrul Celik</strong></td>
                              </tr>
                              </tbody>
                            </table>
                          </div>
                        </div>
                      </div>
                  </div>
                </div>
              </div><!-- tab content -->
            </div><!-- /row -->
          </div>
        <hr>
      </div>

		<%@include file="script.jsp" %>

    </body>
</html>
