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
                        <a class="active-menu" href="bb-user-management.html"><i class="fa fa-user"></i> User Management</a>
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
                            User Management
                        </h1>
                    </div>

                </div>
                <!-- /. ROW  -->



                <div class="row bottom-space">
                    <div class="col-md-12">
                        <button class="btn btn-success" type="button" name="button" data-toggle="modal" data-target="#new-manager"><i class="fa fa-plus fa"></i> New Manager</button>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                System Managers
                            </div>
                            <div class="panel-body">
                                <table class="table table-responsive">
                                    <thead >
                                        <th class="text-center">E-Mail</th>
                                        <th class="text-center">Username</th>
                                        <th class="text-center">Name</th>
                                        <th  class="text-center">Surname</th>
                                        <th class="text-center">Authorization</th>
                                        <th></th>
                                    </thead>
                                    <tbody>
                                        <tr class="text-center">
                                            <td>umit.kas@std.antalya.edu.tr</td>
                                            <td>umit.kas</td>
                                            <td>Umit</td>
                                            <td>Kas</td>
                                            <td>Super Admin</td>
                                            <td><a href="#"><i class="fa fa-gear fa-2x"></i></a></td>
                                        </tr>

                                        <tr class="text-center">
                                            <td>mehmet.arici@std.antalya.edu.tr</td>
                                            <td>mehmet.arici</td>
                                            <td>Mehmet</td>
                                            <td>Arici</td>
                                            <td>Super Admin</td>
                                            <td><a href="#"><i class="fa fa-gear fa-2x"></i></a></td>
                                        </tr>
                                    </tbody>

                                </table>
                            </div>
                        </div>

                    </div>
                </div>
                <!-- /. ROW  -->
            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>
    <!-- /. WRAPPER  -->
    <!-- JS Scripts-->
    <!-- jQuery Js -->

    <div id="new-manager" class="modal fade" tabindex="-1" role="dialog">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title">New Blackboard Manager</h4>
          </div>
          <div class="modal-body">
              <div class="row">
                  <div class="col-md-8">
                      <div class="form-group">
                          <input type="text" class="form-control" name="email" value="" placeholder="E-Mail">
                      </div>
                  </div>
                  <div class="col-md-4">
                      <div class="form-group">
                          <input type="text" class="form-control" name="username " value="" placeholder="Username" readonly>
                      </div>
                  </div>
              </div>
              <div class="row">
                  <div class="col-md-6">
                      <div class="form-group">
                          <input type="text" class="form-control" name="name" value="" placeholder="Name">
                      </div>
                  </div>

                  <div class="col-md-6">
                      <div class="form-group">
                          <input type="text" class="form-control" name="surname" value="" placeholder="Surname">
                      </div>
                  </div>
              </div>

              <div class="row">
                  <div class="col-md-8">
                      <div class="form-group">
                          <input type="text" class="form-control" name="password" value="" placeholder="Password" readonly>
                      </div>
                  </div>

                  <div class="col-md-4">
                      <div class="form-group">
                          <button type="button" class="btn btn-warning" name="button">Generate Password</button>
                      </div>
                  </div>
              </div>
              <div class="row">
                  <div class="col-md-6">
                      <div class="form-group">
                          <div class="form-group">
                              <label>Authorization</label>
                              <select class="form-control">
                                  <option>Super Admin</option>
                                  <option>Admin</option>
                              </select>
                          </div>
                      </div>
                  </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
            <button type="button" class="btn btn-primary" data-dismiss="modal">Save</button>
          </div>
        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->


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
