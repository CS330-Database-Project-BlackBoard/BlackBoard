<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Blackboard - Courses</title>
	
	<%@ include file="style.jsp" %>

	
    <style>
    div.scroll {
      height: 280px;
      overflow: auto;
    }
    </style>
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
                    <a class="active-menu" href="${pageContext.request.contextPath}/lecturer/courses"><i class="fa fa-user"></i> Courses</a>
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
                      <h1 class="page-header">
                          Course Details <small> LMS Blackboard Of AIU</small>
                      </h1>
                  </div>
              </div>
              <ul class="nav nav-pills nav-stacked col-md-4">
                <li class="active"><a href="#CS330" data-toggle="pill"><strong>CS 330 - </strong>Into. to Database System</a></li>
              </ul>
              <div class="tab-content">
                <div class="tab-pane active" id="CS330">
                  <div class="col-md-4">
                    <div class="panel panel-danger">
                      <div class="panel-heading"><a href="course-details.html">Introduction to Database System</a></div>
                      <div class="panel-body">
                        <table class="table table-responsive">
                          <tbody>
                            <tr>
                              <td><label class="text-muted">Course Code : </label></td>
                              <td><label class="text-muted text">CS 330</label></td>
                            </tr>
                            <tr>
                              <td><label class="text-muted">Lecturer : </label></td>
                              <td><label class="text-muted">Joseph Ledet</label></td>
                            </tr>
                            <tr>
                              <td><label class="text-muted">Assistant : </label></td>
                              <td><label class="text-muted">Serhan Aksoy</label></td>
                            </tr>
                            <tr>
                              <td><label class="text-muted">Section : </label></td>
                              <td><label class="text-muted">Lecture1</label></td>
                            </tr>
                            <tr>
                              <td><label class="text-muted">Term : </label></td>
                              <td><label class="text-muted">Spring - 2017</label></td>
                            </tr>
                            <tr>
                              <td><label class="text-muted">Syllabus : </label></td>
                              <td><label class="text-muted"><a href="bb.png" upload><i class="fa fa-cloud-upload fa-2x"></a></label></td>
                            </tr>
                          </tbody>
                        </table>
                      </div>
                    </div>
                  </div>
                  <div class="col-md-4">
                    <div class="panel panel-danger">
                      <div class="panel-heading"><a href="course-students.html">Course Members</a></div>
                      <div class="panel-body">
                        <div class="scroll">
                          <table class="table table-hover table-responsive">
                            <tbody>
                              <tr>
                                <td><img style="max-height: 25px; max-width: 50px;" src="assets/user.png" alt="" class="circle"></td>
                                <td><strong>Mehmet Arici</strong></td>
                              </tr>
                              <tr>
                                <td><img style="max-height: 25px; max-width: 50px;" src="assets/user.png" alt="" class="circle"></td>
                                <td><strong>Murat Dogan</strong></td>
                              </tr>
                              <tr>
                                <td><img style="max-height: 25px; max-width: 50px;" src="assets/user.png" alt="" class="circle"></td>
                                <td><strong>Ümit Kas</strong></td>
                              </tr>
                              <tr>
                                <td><img style="max-height: 25px; max-width: 50px;" src="assets/user.png" alt="" class="circle"></td>
                                <td><strong>Koray Ozyurt</strong></td>
                              </tr>
                              <tr>
                                <td><img style="max-height: 25px; max-width: 50px;" src="assets/user.png" alt="" class="circle"></td>
                                <td><strong>Ertugrul Celik</strong></td>
                              </tr>
                              <tr>
                                <td><img style="max-height: 25px; max-width: 50px;" src="assets/user.png" alt="" class="circle"></td>
                                <td><strong>Mehmet Arici</strong></td>
                              </tr>
                              <tr>
                                <td><img style="max-height: 25px; max-width: 50px;" src="assets/user.png" alt="" class="circle"></td>
                                <td><strong>Murat Dogan</strong></td>
                              </tr>
                              <tr>
                                <td><img style="max-height: 25px; max-width: 50px;" src="assets/user.png" alt="" class="circle"></td>
                                <td><strong>Ümit Kas</strong></td>
                              </tr>
                              <tr>
                                <td><img style="max-height: 25px; max-width: 50px;" src="assets/user.png" alt="" class="circle"></td>
                                <td><strong>Koray Ozyurt</strong></td>
                              </tr>
                              <tr>
                                <td><img style="max-height: 25px; max-width: 50px;" src="assets/user.png" alt="" class="circle"></td>
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

	<%@ include file="script.jsp" %>

    </body>
</html>
