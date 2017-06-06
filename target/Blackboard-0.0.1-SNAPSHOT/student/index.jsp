<%@ page import="pojos.Announcement" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="pojos.Course" %>

<% ArrayList<Announcement> Announcements = (ArrayList<Announcement>) session.getAttribute("Announcements"); %>
<% ArrayList<Course> courses = (ArrayList<Course>) session.getAttribute("courses"); %>
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
    <%@include file="head.jsp" %>

    <!--/. NAV TOP  -->
    <nav class="navbar-default navbar-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">
                <li>
                    <a class="active-menu" href="${pageContext.request.contextPath}/student/dashboard"><i class="fa fa-tachometer"></i> Dashboard</a>
                </li>
                <li>
                    <a  href="${pageContext.request.contextPath}/student/courses"><i class="fa fa-book"></i> Courses</a>
                </li>
                <li>
                    <a  href="${pageContext.request.contextPath}/student/grades"><i class="fa fa-table"></i> Grades</a>
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
                    <h1 class="page-header">Dashboard <small> LMS Blackboard Of AIU</small></h1>
                </div>
            </div>
            <!-- /. ROW  -->
            <div class="row">
                <div class="col-md-7 col-sm-12 col-xs-12">
                    <div class="panel panel-danger">
                        <div class="panel-heading">System Announcements</div>
                        <div class="panel-body">
                            <div class="list-group">

                                <% int var = 0; %>
                                <% for(Announcement Announcement : Announcements){ %>
                                <% if(var == 7){
                                    break;
                                } %>
                                <a class="list-group-item">
                                    <span class="badge"><%=Announcement.getPostedAt()%></span>
                                    <%=Announcement.getContent()%>
                                </a>
                                <% var++; %>
                                <% } %>

                                <span class="badge">yesterday</span>
                                <i class="fa fa-fw fa-globe"></i>no real data
                                </a>
                            </div>
                            <div class="text-right">
                                <a href="announcment.html">More Announcments <i class="fa fa-arrow-circle-right"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-5 col-sm-12 col-xs-12">
                    <div class="panel panel-danger">
                        <div class="panel-heading">Courses</div>
                        <div class="panel-body">
                            <div class="list-group">

                                <% var = 0; %>
                                <%for(Course course: courses){ %>
                                <% if(var ==7){
                                    break;
                                } %>
                                <a href="#" class="list-group-item">
                                    <i class="fa fa-fw fa-bookmark"></i> <%=course.getName()%>
                                </a>
                                <% var++; %>
                                <% } %>

                            </div>
                            <div class="text-right">
                                <a href="courses.html">View Courses <i class="fa fa-arrow-circle-right"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- /. WRAPPER  -->
<%@include file="script.jsp" %>

</body>
</html>