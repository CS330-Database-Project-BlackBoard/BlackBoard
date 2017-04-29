<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Blackboard - Dashboard</title>
    <!-- Bootstrap Styles-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" type="text/css">

    <!-- Morris Chart Styles-->
    <link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
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
                <a class="navbar-brand" href="bb-index.html">BlackBoard</a>
            </div>

            <ul class="nav navbar-top-links navbar-right">

                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <!-- <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i> -->
                        <span> umit.kas &nbsp<i class="fa fa-caret-down"></i></span>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="#"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
        </nav>
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
                        <a  href="bb-student-management.html"><i class="fa fa-graduation-cap"></i> Student Management</a>
                    </li>

                    <li>
                        <a class="active-menu" href="bb-lecturer-management.html"><i class="fa fa-users"></i> Lecturer Management</a>
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
                            Lecturer Management
                        </h1>
                    </div>
                </div>
                <!-- /. ROW  -->
                <div class="row bottom-space">
                    <div class="col-md-12">
                        <button type="button" name="button" class="btn btn-success" data-toggle="modal" data-target="#add-new-course"><span class=" glyphicon glyphicon-plus"></span> Add New Course</button>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 col-xs-12 col-sm-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Lecturer Course List
                            </div>
                            <div class="panel-body">
                                <table class="table table-responsive">
                                    <thead>
                                        <th class="text-center">Course Code</th>
                                        <th class="text-center">Course Name</th>
                                        <th class="text-center">Enrolled Student</th>
                                        <th></th>
                                    </thead>
                                    <tbody>
                                        <tr class="text-center">
                                            <td>CS306</td>
                                            <td>Software Engineering</td>
                                            <td>35</td>
                                            <td>
                                                <a href="#" class="table-col-space-right">
                                                    <i class="fa fa-trash-o"></i>
                                                </a>
                                                <a href="bb-course-detail.html">
                                                    <i class="glyphicon glyphicon-chevron-right"></i>
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="text-center">
                                            <td>CS330</td>
                                            <td>Database Systems</td>
                                            <td>13</td>
                                            <td>
                                                <a href="#" class="table-col-space-right">
                                                    <i class="fa fa-trash-o"></i>
                                                </a>
                                                <a href="bb-course-detail.html">
                                                    <i class="glyphicon glyphicon-chevron-right"></i>
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="text-center">
                                            <td>CS303</td>
                                            <td>Formal Languages and Automata Theory</td>
                                            <td>65</td>
                                            <td>
                                                <a href="#" class="table-col-space-right">
                                                    <i class="fa fa-trash-o"></i>
                                                </a>
                                                <a href="bb-course-detail.html">
                                                    <i class="glyphicon glyphicon-chevron-right"></i>
                                                </a>
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
        <div class="modal fade" id="add-new-course" tabindex="-1" role="dialog" aria-labelledby="" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <div class="modal-title">
                    Add New Course
                </div>
              </div>
              <div class="modal-body">
                  <form class="" action="index.html" method="post">
                      <div class="row">
                          <div class="col-md-3">
                                  <div class="form-group">
                                      <select class="form-control">
                                          <option>Class 1</option>
                                          <option>Class 2</option>
                                          <option>Class 3</option>
                                          <option>Class 4</option>
                                      </select>
                                  </div>
                          </div>
                          <div class="col-md-5">
                              <div class="form-group">
                                  <select class="form-control">
                                      <option>Engineering Faculty</option>
                                      <option>Law School</option>
                                      <option>Foreign Languages School</option>
                                      <option>Fine Art Faculty</option>
                                  </select>
                              </div>
                          </div>
                          <div class="col-md-4">
                              <div class="form-group">
                                  <select class="form-control">
                                      <option>Computer Engineering</option>
                                      <option>Electirical Engineering</option>
                                      <option>Civil Engineering</option>
                                      <option>Industrial Engineering</option>
                                  </select>
                              </div>
                          </div>
                      </div>
                  </form>

                  <div class="row">
                    <div class="col-md-12">
                        <table class="table table-responsive">
                            <thead>
                                <td class="text-center">Course Code</td>
                                <td class="text-center">Course Name</td>
                                <td class="text-center">Lecturer</td>
                                <td class="text-center"></td>
                            </thead>
                            <tbody>
                                <tr class="text-center">
                                    <td>CS101</td>
                                    <td>Introduction to Programing</td>
                                    <td>Faradah Bilmemne</td>
                                    <td>
                                        <a href="bb-course-detail.html"><span class="glyphicon glyphicon-plus"></span></a>
                                    </td>
                                </tr>
                                <tr class="text-center">
                                    <td>CS404</td>
                                    <td>Microprocessors</td>
                                    <td>Tarek Ummumi</td>
                                    <td>
                                        <a href="bb-course-detail.html"><span class="glyphicon glyphicon-plus"></span></a>
                                    </td>
                                </tr>
                                <tr class="text-center">
                                    <td>CS201</td>
                                    <td>Data Structures</td>
                                    <td>Cesim Erten</td>
                                    <td>
                                        <a href="bb-course-detail.html"><span class="glyphicon glyphicon-plus"></span></a>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                  </div>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-success">Save</button>
              </div>
            </div>
          </div>
        </div>

    <!-- /. WRAPPER  -->
    <!-- JS Scripts-->
    <!-- jQuery Js -->
    <script src="assets/js/jquery-1.10.2.js"></script>
    <!-- Bootstrap Js -->
    <script src="assets/js/bootstrap.min.js"></script>
    <!-- Metis Menu Js -->
    <script src="assets/js/jquery.metisMenu.js"></script>
    <!-- Morris Chart Js -->
    <script src="assets/js/morris/raphael-2.1.0.min.js"></script>
    <script src="assets/js/morris/morris.js"></script>
    <!-- Custom Js -->
    <script src="assets/js/custom-scripts.js"></script>


</body>

</html>
