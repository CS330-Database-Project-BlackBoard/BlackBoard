
<%@page import="pojos.File"%>
<%@page import="pojos.Course"%>
<%@page import="pojos.CourseMaterial"%>
<%@page import="java.util.ArrayList"%>

<% ArrayList<CourseMaterial> courseMaterials = (ArrayList<CourseMaterial>) session.getAttribute("courseMaterials"); %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Blackboard - Grades</title>
	
			<%@ include file ="style.jsp" %>
	
	
  </head>

  <body>
    <div id="wrapper">
		<%@ include file ="bb-head.jsp" %>
        <!--/. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
					 <ul class="nav" id="main-menu">
                <li>
                    <a  href="${pageContext.request.contextPath}/lecturer/dashboard"><i class="fa fa-dashboard"></i> Dashboard</a>
                </li>
                <li>
                    <a  href="${pageContext.request.contextPath}/lecturer/courses"><i class="fa fa-user"></i> Courses</a>
                </li>
                <li>
                    <a class="active-menu" href="${pageContext.request.contextPath}/lecturer/course-materials"><i class="fa fa-book"></i> Course Materials</a>
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
                      <h1 class="page-header">
                          Grades
                      </h1>
                  </div>
              </div>
              <ul class="nav nav-pills nav-stacked col-md-4">
              	<%
              	int index = 0;
              	for(CourseMaterial courseMaterial : courseMaterials){ %>
              		<% if(index == 0){ %>
               		 <li class="active">
	               		 <a href="#lec<%= courseMaterial.getCourse().getLectureID() %>" data-toggle="pill">
	               		 	<strong><%= courseMaterial.getCourse().getCode() %> - </strong><%= courseMaterial.getCourse().getName() %>
	               		 </a>
               		 </li>
               		 <% } %>
              	    
              	    <% if(index > 0){ %>
               		 <li class="">
	               		 <a href="#lec<%= courseMaterial.getCourse().getLectureID() %>" data-toggle="pill">
	               		 	<strong><%= courseMaterial.getCourse().getCode() %> - </strong><%= courseMaterial.getCourse().getName() %>
	               		 </a>
               		 </li>
               		 <% } %>
              	    
              	
              	<%
              		index++;
              		} %>
              </ul>
              <div class="tab-content col-md-8">
              	
              	<% 
              	 int index2 = 0;
              	for(CourseMaterial courseMaterial : courseMaterials){ %>
              	   <% if(index2 == 0){ %>
              	     	
	                <div class="tab-pane active" id="lec<%= courseMaterial.getCourse().getLectureID()%>">
	                  <div class="panel panel-default">
	                    <div class="panel-body">
	                         <div class="row">
	                          <div class="col-md-12 bottom-space">
				               <a href="${pageContext.request.contextPath}/lecturer/course-material/lecture/<%= courseMaterial.getCourse().getLectureID()%>/new">
	                           	<button type="button" name="button" class="btn btn-success"><span class="glyphicon glyphicon-plus"></span> New Material</button>
	                           </a>
	                          </div>
	                      </div>
	                      <div class="row">
	                          <div class="col-md-12 col-xs-12 col-sm-12">
	                              <div class="panel panel-default">
	                                  <div class="panel-body">
	                                		<%for(File file : courseMaterial.getFiles()){ %>
	                                			<div class="panel-group">
												  <div class="panel panel-default">
												    <div class="panel-heading head" data-toggle="collapse" href="#<%= file.getAnnouncement().getAnnouncementID()%>">
												     	<div class="row">
												     		<div class="col-md-1">
												     			<i class="glyphicon glyphicon-chevron-down"></i>
												     		</div>
												     		<div class="col-md-11">
												        			<%= file.getAnnouncement().getTitle() %>
												     		</div>
												     	</div>
												    </div>
												    <div id="<%= file.getAnnouncement().getAnnouncementID()%>" class="panel-collapse collapse">
												      <div class="panel-body">
												      	<p><%= file.getAnnouncement().getContent() %></p>
												      	<a href="<%= file.getPath() %>"><%= file.getName() %></a>
														<p class="pull-right text-muted"><%= file.getPostedAT() %></p>
												      	
												      </div>

												    </div>
												  </div>
												</div>
	                                		<%}%>
	                                  </div>
	                              </div>
	                          </div>
	                      </div>
	                      </div>
	                    </div>
	                  </div>
            		<% } %>
              	     
              		 <% if(index2 > 0){ %>
              		       <div class="tab-pane" id="lec<%= courseMaterial.getCourse().getLectureID()%>">
			                  <div class="panel panel-default">
			                    <div class="panel-body">
			                         <div class="row">
	                        			  <div class="col-md-12 bottom-space">
				                           <a href="${pageContext.request.contextPath}/lecturer/course-material/lecture/<%= courseMaterial.getCourse().getLectureID()%>/new">
				                           		<button type="button" name="button" class="btn btn-success"><span class="glyphicon glyphicon-plus"></span> New Material</button>
				                           </a>
				                          </div>
	                  			    </div>
			                      <div class="row">
			                          <div class="col-md-12 col-xs-12 col-sm-12">
			                              <div class="panel panel-default">
			                                  <div class="panel-body">
			                                		<%for(File file : courseMaterial.getFiles()){ %>
			                                			<div class="panel-group">
														  <div class="panel panel-default">
														    <div class="panel-heading head" data-toggle="collapse" href="#<%= file.getAnnouncement().getAnnouncementID()%>">
														     	<div class="row">
														     		<div class="col-md-1">
														     			<i class="glyphicon glyphicon-chevron-down"></i>
														     		</div>
														     		<div class="col-md-11">
														        			<%= file.getAnnouncement().getTitle() %>
														     		</div>
														     	</div>
														    </div>
														    <div id="<%= file.getAnnouncement().getAnnouncementID()%>" class="panel-collapse collapse">
														      <div class="panel-body">
														      	<p><%= file.getAnnouncement().getContent() %></p>
														      	<a href="<%= file.getPath() %>"><%= file.getName() %></a>
																<p class="pull-right text-muted"><%= file.getPostedAT() %></p>
														      	
														      </div>
		
														    </div>
														  </div>
														</div>
			                                		<%}%>
			                                  </div>
			                              </div>
			                          </div>
			                      </div>
			                      </div>
			                    </div>
		                  </div>
              		<% } %>
              		              	    
             	<%
             	index2++;
              	} %>
              </div><!-- tab content -->
            </div>
        </div>
    </div>

    <div id="update-grade-detail" class="modal fade" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <div class="modal-title"><strong>Update Grade Detail</strong></div>
                </div>
                <div class="modal-body">
                    <form method="post">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <input type="text" class="form-control" name="" value="" placeholder="Grade Name">
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <input type="text" class="form-control" name="" value="" placeholder="Effect">
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

			<%@ include file ="script.jsp" %>



</body>

</html>
