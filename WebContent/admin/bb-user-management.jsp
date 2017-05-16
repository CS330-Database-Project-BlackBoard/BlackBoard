<%@page import="pojos.Role"%>
<%@page import="pojos.Manager"%>
<%@page import="java.util.ArrayList"%>
<% ArrayList<Manager> managers = (ArrayList<Manager>) session.getAttribute("managers"); %>
<% ArrayList<Role> roles = (ArrayList<Role>) session.getAttribute("roles"); %>


<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Blackboard - Dashboard</title>
	<%@include file="style.jsp" %>
</head>

<body>
    <div id="wrapper">
              <%@ include file="bb-head.jsp" %>

        <!--/. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
        		<ul class="nav" id="main-menu">
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/dashboard"><i class="fa fa-dashboard"></i> Dashboard</a>
                    </li>
                    <li>
                        <a class="active-menu"  href="${pageContext.request.contextPath}/admin/managers"><i class="fa fa-user"></i> User Management</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/courses"><i class="fa fa-book"></i> Course Management</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/students"><i class="fa fa-graduation-cap"></i> Student Management</a>
                    </li>

                    <li>
                        <a class="" href="${pageContext.request.contextPath}/admin/lecturers"><i class="fa fa-users"></i> Lecturer Management</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/settings"><i class="fa fa-edit"></i> Settings</a>
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
                                        <th class="text-center">Name</th>
                                        <th  class="text-center">Surname</th>
                                        <th class="text-center">Authorization</th>
                                        <th></th>
                                    </thead>
                                    <tbody>
                                    	<% for(Manager manager : managers){ %>
                                        <tr class="text-center">
                                            <td><%= manager.getEmail() %></td>
                                            <td><%= manager.getName() %></td>
                                            <td><%= manager.getSurname() %></td>
                                            <td><%= manager.getRoleDescription() %></td>
                                            <td><a href="#"><i class="fa fa-gear fa-2x"></i></a></td>
                                        </tr>

                                   		<% } %>
                                    	
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
	        <form action="" method="post">
	          
	          <div class="modal-body">
	              <div class="row">
	                  <div class="col-md-8">
	                      <div class="form-group">
	                          <input type="text" class="form-control" name="email" value="" placeholder="E-Mail">
	                      </div>
	                  </div>
	                  <div class="col-md-4">
	                      <div class="form-group">
	                          <input type="text" class="form-control" name="schoolID" value="" placeholder="School ID">
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
	                          <input type="text" id="password" class="form-control" name="password" value="" placeholder="Password" readonly>
	                      </div>
	                  </div>
	
	                  <div class="col-md-4">
	                      <div class="form-group">
	                          <button id="generate-password" type="button" class="btn btn-warning" name="button">Generate Password</button>
	                      </div>
	                  </div>
	              </div>
	              <div class="row">
	                  <div class="col-md-6">
	                      <div class="form-group">
	                          <div class="form-group">
	                              <label>Authorization</label>
	                              <select name="role" class="form-control">
	                              		<% for(Role role: roles){%>
	                                  		<option value="<%= role.getLevel()%>"><%= role.getDescription() %></option>
	                                  <%} %>
	                              </select>
	                          </div>
	                      </div>
	                  </div>
	          	 </div>
	          </div>
	          	
	          <div class="modal-footer">
	            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
	            <button type="submit" class="btn btn-primary">Save</button>
	          </div>
			</form>
	        </div><!-- /.modal-content -->
	      </div><!-- /.modal-dialog -->
	    </div><!-- /.modal -->
	  </div>


	<%@include file="script.jsp" %>
</body>

</html>
