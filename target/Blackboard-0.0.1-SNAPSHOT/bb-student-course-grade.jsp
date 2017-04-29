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
                        <a class="active-menu" href="bb-student-management.html"><i class="fa fa-graduation-cap"></i> Student Management</a>
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
                            Student Management
                        </h1>
                    </div>
                </div>
                <!-- /. ROW  -->

                <div class="row">
                    <div class="col-md-12 col-xs-12 col-sm-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Database Systems Course Grades
                            </div>
                            <div class="panel-body">
                                <table class="table table-responsive">
                                    <thead>
                                        <th class="text-center">Anouncment Date</th>
                                        <th class="text-center">Grade Name</th>
                                        <th class="text-center">Grade</th>
                                        <th class="text-center">Average</th>
                                        <th></th>
                                    </thead>
                                    <tbody>
                                        <tr class="text-center">
                                            <td>23/04/2017</td>
                                            <td>Quiz 2</td>
                                            <td>45</td>
                                            <td>37.6</td>
                                            <td>
                                                <a data-toggle="modal" href="#update-grade" class="">
                                                    <i class="fa fa-pencil"></i>
                                                </a>
                                            </td>
                                        </tr>

                                        <tr class="text-center">
                                            <td>15/04/2017</td>
                                            <td>Quiz 1</td>
                                            <td>75</td>
                                            <td>67.1</td>
                                            <td>
                                                <a href="#" class="">
                                                    <i class="fa fa-pencil"></i>
                                                </a>
                                            </td>
                                        </tr>

                                        <tr class="text-center">
                                            <td>05/04/2017</td>
                                            <td>Midterm 1</td>
                                            <td>65</td>
                                            <td>57.3</td>
                                            <td>
                                                <a href="#" class="">
                                                    <i class="fa fa-pencil"></i>
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


    <div id="update-grade" class="modal fade" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <div class="modal-title">
                        Update Grade
                    </div>
                </div>
                <div class="modal-body">
                    <form class="" action="" method="post">
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <input type="text" class="form-control" name="" value="" placeholder="Student Id" readonly>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <input type="text" class="form-control" name="" value="" placeholder="Course Name" readonly>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <div class="form-group">
                                    <input type="text" class="form-control" name="" value="75">
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
