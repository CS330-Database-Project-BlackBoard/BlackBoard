<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Blackboard - Assignments</title>
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
                      <h1 class="page-header">Assignments</h1>
                  </div>
              </div>
              <ul class="nav nav-pills nav-stacked col-md-4">
                <li class="active"><a href="#tab_a" data-toggle="pill"><strong>CS 330 - </strong>Into. to Database System </a></li>
              </ul>
                <div class="tab-content col-md-8">
                    <div class="tab-pane active" id="CS330">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-md-12 bottom-space">
                                        <a href="new-grade.html">
                                            <button type="button" name="button" class="btn btn-success"><span class="glyphicon glyphicon-plus"></span> New Assignment</button>
                                        </a>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-12 col-xs-12 col-sm-12">
                                        <div class="panel panel-default">
                                            <div class="panel-body">
                                                <table class="table table-responsive">
                                                    <thead>
                                                    <th class="text-center">Assignment</th>
                                                    <th class="text-center">Posted Date </th>
                                                    <th class="text-center">Due Date</th>
                                                    <th></th>
                                                    </thead>
                                                    <tbody>
                                                    <tr class="text-center">
                                                        <td>Quiz 2</td>
                                                        <td>15</td>
                                                        <td>23/04/2017</td>
                                                        <td>
                                                            <a data-toggle="modal" href="#update-grade-detail" class="table-col-space-right">
                                                                <i class="fa fa-pencil"></i>
                                                            </a>
                                                            <a href="student-list.html"><i class="fa fa-eye"></i></a>
                                                        </td>
                                                    </tr>

                                                    <tr class="text-center">
                                                        <td>Quiz 1</td>
                                                        <td>67.1</td>
                                                        <td>15</td>
                                                        <td>15/04/2017</td>
                                                        <td>
                                                            <a data-toggle="modal" href="#update-grade-detail" class="table-col-space-right">
                                                                <i class="fa fa-pencil"></i>
                                                            </a>
                                                            <a href="student-list.html"><i class="fa fa-eye"></i></a>
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div><!-- tab content -->
            </div>
        </div>
    </div>

		<%@ include file="script.jsp" %>



</body>

</html>
