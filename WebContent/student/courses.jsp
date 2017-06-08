<%@page import="pojos.StudentCourse"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pojos.Student" %>

<% ArrayList<StudentCourse> studentCourses = (ArrayList<StudentCourse>)session.getAttribute("studentCourses"); %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Blackboard - Courses</title>
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
                        <a  href="${pageContext.request.contextPath}/student/dashboard"><i class="fa fa-tachometer"></i> Dashboard</a>
                    </li>
                    <li>
                        <a class="active-menu"  href="${pageContext.request.contextPath}/student/courses"><i class="fa fa-book"></i> Courses</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/student/course-materials"><i class="fa fa-book"></i> Course Materials</a>
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
                      <h1 class="page-header">
                          Course Details <small> LMS Blackboard Of AIU</small>
                      </h1>
                  </div>
              </div>
              <ul class="nav nav-pills nav-stacked col-md-4">

                <%
                  int ind = 0;
                  for(StudentCourse studentCourse: studentCourses){  %>
                      <% if(ind ==0){ %>
                          <li class="active"><a href="#<%=studentCourse.getCourse().getCourseID()%>" data-toggle="pill"> <Strong><%=studentCourse.getCourse().getCode()%> - </Strong> <%=studentCourse.getCourse().getName()%> <i class="fa fa-bell-o"></i></a></li>
                      <% } %>
                      <% if(ind > 0){ %>
                      <li><a href="#<%=studentCourse.getCourse().getCourseID()%>" data-toggle="pill"> <Strong><%=studentCourse.getCourse().getCode()%> - </Strong> <%=studentCourse.getCourse().getName()%> <i class="fa fa-bell-o"></i></a></li>
                      <% } %>
                  <%
                    ind += 1;
                  } %>
              </ul>


              <div class="tab-content">

              <%
                int var = 0;
                for(StudentCourse studentCourse: studentCourses){ %>
                    <% if(var == 0){ %>
                        <div class="tab-pane active" id="<%=studentCourse.getCourse().getCourseID() %>">
                    <% } %>
                    <% if(var > 0){ %>
                          <div class="tab-pane" id="<%=studentCourse.getCourse().getCourseID()%>">
                     <% } %>

                  <div class="col-md-4">
                    <div class="panel panel-danger">

                      <div class="panel-heading"><%=studentCourse.getCourse().getName()%></div>
                      <div class="panel-body">
                        <table class="table table-responsive">
                          <tbody>
                            <tr>
                              <td><label class="text-muted">Course Code: </label></td>
                              <td><label class="text-muted text"><%=studentCourse.getCourse().getCode()%></label></td>
                            </tr>
                            <tr>
                              <td><label class="text-muted">Lecturer: </label></td>
                              <td><label class="text-muted"><%=studentCourse.getCourse().getLecturerName()%> <%=studentCourse.getCourse().getLecturerSurname()%></label></td>
                            </tr>
                            <tr>
                              <td><label class="text-muted">Assistant: </label></td>
                              <td><label class="text-muted">Serhan Aksoy</label></td>
                            </tr>
                            <tr>
                              <td><label class="text-muted">Section: </label></td>
                              <td><label class="text-muted"><%=studentCourse.getCourse().getLectureName()%></label></td>
                            </tr>
                            <tr>
                              <td><label class="text-muted">Term: </label></td>
                              <td><label class="text-muted"><%=studentCourse.getCourse().getSemesterID()%></label></td>
                            </tr>
                            <tr>
                              <td><label class="text-muted">Syllabus : </label></td>
                              <td><label class="text-muted"><a href="bb.png" download><i class="fa fa-cloud-download fa-2x"></i></a></label></td>
                            </tr>
                          </tbody>
                        </table>
                      </div>
                    </div>
                  </div>
                  <div class="col-md-4">
                    <div class="panel panel-danger">
                      <div class="panel-heading">Course Members</div>
                      <div class="panel-body">
                        <div class="scroll">
                          <table class="table table-hover table-responsive">
                            <tbody>

                              <% for(Student student : studentCourse.getStudents()){ %>
                              <tr>
                                <td>
                                    <td><img style="max-height: 30px; max-width: 50px;" src="https://png.icons8.com/student-male/dusk/64/" alt="" class="circle"></td>
                                    <td><strong><%=student.getName() + " " + student.getSurname()%></strong>
                                </td>
                              </tr>
                              <% } %>

                              </tbody>
                            </table>
                          </div>
                        </div>
                      </div>
                  </div>
                </div>
                  <%
                    var += 1;
                    }
                  %>
              </div><!-- tab content -->
            </div><!-- /row -->
          </div>
        <hr>
      </div>

		<%@include file="script.jsp" %>

    </body>
</html>
