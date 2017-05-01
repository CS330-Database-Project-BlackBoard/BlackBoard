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
               <%@ include file="bb-head.jsp" %>

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
                        <a href="bb-student-management.html"><i class="fa fa-graduation-cap"></i> Student Management</a>
                    </li>

                    <li>
                        <a class="" href="bb-lecturer-management.html"><i class="fa fa-users"></i> Lecturer Management</a>
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
                            Database Systems New Grade
                        </h1>
                    </div>
                </div>
                <!-- /. ROW  -->
                <div class="row">
                  <div class="col-md-8">
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
                                <button type="button" name="button" class="btn btn-success pull-right"> Save </button>
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
                                                <td class="text-right">
                                                    <input type="text" name="" class="form-control grade-text" value="0">
                                                </td>
                                            </tr>
                                            <tr class="text-center new-grade-row">
                                                <td>130201004</td>
                                                <td>Mehmet Arici</td>
                                                <td class="text-right">
                                                    <input type="text" name="" class="form-control grade-text" value="0">
                                                </td>
                                            </tr>
                                            <tr class="text-center new-grade-row">
                                                <td>130201026</td>
                                                <td>Murat Dogan</td>
                                                <td class="text-right">
                                                    <input type="text" name="" class="form-control grade-text" value="0">
                                                </td>
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
