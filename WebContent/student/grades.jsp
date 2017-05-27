

<%@page import="pojos.StudentGrade"%>
<%@page import="pojos.StudentCourseGrade"%>
<%@page import="java.util.ArrayList"%>
<% ArrayList<StudentCourseGrade> studentCourseGrades = (ArrayList<StudentCourseGrade>) session.getAttribute("studentCourseGrades");%>
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
                        
                <% 
             	int ind = 0;
                for(StudentCourseGrade studentCourseGrade: studentCourseGrades){ %>
                	<% if(ind == 0){ %>
                		<li class="active"><a href="#<%= studentCourseGrade.getCourse().getCourseID()%>" data-toggle="pill"><strong><%= studentCourseGrade.getCourse().getCode() %> - </strong>  <%= studentCourseGrade.getCourse().getName() %> <i class="fa fa-bell-o"></i></a></li>
                	<%} %>
	                <%if(ind > 0){ %>
                		<li><a href="#<%= studentCourseGrade.getCourse().getCourseID()%>" data-toggle="pill"><strong><%= studentCourseGrade.getCourse().getCode() %> - </strong>  <%= studentCourseGrade.getCourse().getName() %> <i class="fa fa-bell-o"></i></a></li>
                    <%} %>
              			
              	<%
              	ind += 1;
                } %>
              </ul>
              
              <div class="tab-content col-md-8">
                
                <%
             	int var = 0;
                for(StudentCourseGrade studentCourseGrade : studentCourseGrades){ %>
                    <% if(var == 0){ %>
		           		 <div class="tab-pane active" id="<%= studentCourseGrade.getCourse().getCourseID()%>">
	                  <%} %>
	                  <%if(var > 0){ %>
	               		<div class="tab-pane" id="<%= studentCourseGrade.getCourse().getCourseID()%>">
	                  	
	                  <%} %>
	                  <div class="panel panel-default">
	                    <div class="panel-body">
	                      <div class="row">
	                        <table class="table table-hover">
	                          <tbody>
	                          <% for(StudentGrade studentGrade : studentCourseGrade.getGrades()) {%>
	                            <tr>
	                              <td>
	                                <label><strong><%= studentGrade.getName() %></strong></label>
	                                <br>
	                                <small class="text-muted">Average</small>
	                                <br>
	                                <small class="text-muted">Affect</small>
	                              </td>
	                              <td class=" text-right">
	                                <strong><%= studentGrade.getGrade() %></strong>
	                                <br>
	                                <small class="text-muted"><%= studentGrade.getAverage() %></small>
	                                <br>
	                                <small class="text-muted">%<%=studentGrade.getAffect() %></small>
	                                </td>
	                              </tr>
	                           <% } %>
	                            </tbody>
	                          </table>
	                        </div>
	                      </div>
	                    </div>
	                  </div>
               <%
               	var += 1;
                }
                %>
          
              </div><!-- tab content -->
            </div>
        </div>
    </div>

		<%@include file="script.jsp" %>



</body>

</html>
