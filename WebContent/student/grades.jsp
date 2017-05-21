<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Blackboard - Grades</title>
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
                   		 <a  href="${pageContext.request.contextPath}/student/courses"><i class="fa fa-book"></i> Courses</a>
                    </li>
                    <li>
                    	<a class="active-menu" href="${pageContext.request.contextPath}/student/grades"><i class="fa fa-table"></i> Grades</a>
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
                          Grades <small> My All Grades at Spring - 2017</small>
                      </h1>
                  </div>
              </div>
              <ul class="nav nav-pills nav-stacked col-md-4">
                <li class="active"><a href="#tab_all" data-toggle="pill"><strong>All Average Grades   </strong><i class="fa fa-bell-o"></i></a></li>
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
                                <small class="text-muted">Average</small>
                              </td>
                              <td class=" text-right">
                                <br>
                                <strong>60</strong>
                              </td>
                            </tr>
                            <tr>
                              <td>
                                <label><strong>CS 306 - Software Engineering</strong></label>
                                <br>
                                <small class="text-muted">Average</small>
                              </td>
                              <td class=" text-right">
                                <br>
                                <strong>75</strong>
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
                                <label><strong>Quiz 1</strong></label>
                                <br>
                                <small class="text-muted">Average</small>
                                <br>
                                <small class="text-muted">Affect</small>
                              </td>
                              <td class=" text-right">
                                <strong>88</strong>
                                <br>
                                <small class="text-muted">22</small>
                                <br>
                                <small class="text-muted">%20</small>
                                </td>
                              </tr>
                              <tr>
                                <td>
                                  <label><strong>Midterm 2</strong></label>
                                  <br>
                                  <small class="text-muted">Average</small>
                                  <br>
                                  <small class="text-muted">Affect</small>
                                </td>
                                <td class=" text-right">
                                  <strong>45</strong>
                                  <br>
                                  <small class="text-muted">63</small>
                                  <br>
                                  <small class="text-muted">%30</small>
                                </td>
                                </tr>
                              <tr>
                                <td>
                                  <label><strong>Quiz 2</strong></label>
                                  <br>
                                  <small class="text-muted">Average</small>
                                  <br>
                                  <small class="text-muted">Affect</small>
                                </td>
                                <td class=" text-right">
                                  <strong>56</strong>
                                  <br>
                                  <small class="text-muted">45</small>
                                  <br>
                                  <small class="text-muted">%10</small>
                                </td>
                              </tr>
                              <tr>
                                <td>
                                  <label class="text-primary"><strong>My General Average</strong></label>
                                  <br>
                                  <small class="text-muted">Course General Average</small>
                                  <br>
                                </td>
                                <td class=" text-right">
                                  <strong class="text-primary">56</strong>
                                  <br>
                                  <small class="text-muted">45</small>
                                  <br>
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
                                    <label><strong>Midterm</strong></label>
                                    <br>
                                    <small class="text-muted">Average</small>
                                    <br>
                                    <small class="text-muted">Affect</small>
                                  </td>
                                  <td class=" text-right">
                                    <strong>56</strong>
                                    <br>
                                    <small class="text-muted">28</small>
                                    <br>
                                    <small class="text-muted">%25</small>
                                  </td>
                                </tr>
                                <tr>
                                  <td>
                                    <label><strong>Assignment 1</strong></label>
                                    <br>
                                    <small class="text-muted">Average</small>
                                    <br>
                                    <small class="text-muted">Affect</small>
                                  </td>
                                  <td class=" text-right">
                                    <strong>95</strong>
                                    <br>
                                    <small class="text-muted">63</small>
                                    <br>
                                    <small class="text-muted">%15</small>
                                  </td>
                                </tr>
                                <tr>
                                  <td>
                                    <label><strong>Quiz 2</strong></label>
                                    <br>
                                    <small class="text-muted">Average</small>
                                    <br>
                                    <small class="text-muted">Affect</small>
                                  </td>
                                  <td class=" text-right">
                                    <strong>76</strong>
                                    <br>
                                    <small class="text-muted">50</small>
                                    <br>
                                    <small class="text-muted">%10</small>
                                  </td>
                                </tr>
                                <tr>
                                  <td>
                                    <label class="text-primary"><strong>My General Average</strong></label>
                                    <br>
                                    <small class="text-muted">Course General Average</small>
                                    <br>
                                  </td>
                                  <td class=" text-right">
                                    <strong class="text-primary">74</strong>
                                    <br>
                                    <small class="text-muted">59</small>
                                    <br>
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
