<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Blackboard - Dashboard</title>
	
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
                    <a  href="${pageContext.request.contextPath}/lecturer/courses"><i class="fa fa-user"></i> Courses</a>
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
                        <h1 class="page-header">New Material <small> </small></h1>
                    </div>
                </div>
            	<div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                        	<input type="input" class="form-control" name="announcement-title" placeholder="Title"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
  							<textarea class="form-control" rows="9" name="announcement-content" placeholder="Content"></textarea>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
   						  <input type="file" class="file-loading" name="course-material-file">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
   

		<%@ include file="script.jsp" %>
	
  </body>
</html>
