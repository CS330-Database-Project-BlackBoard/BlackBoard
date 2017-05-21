<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Blackboard - Announcments</title>
    
	<%@include file="style.jsp" %>
	
  </head>

  <body>
    <div id="wrapper">
      	<%@include file="head.jsp" %>
      
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">All Announcments</h1>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <table id="dataTables-example" class="table table-responsive">
                                    <thead >
                                        <th class="text-center">Announcment</th>
                                        <th class="text-center">Course</th>
                                        <th class="text-center">Posted By</th>
                                        <th  class="text-center">Posted At</th>
                                    </thead>
                                    <tbody>
                                        <tr class="text-center">
                                            <td><a data-toggle="modal" data-target="#announcments">Assignment 1 is posted</a></td>
                                            <td>CS - 330</td>
                                            <td>Joseph Ledet</td>
                                            <td><span class="badge">1 hour ago</span></td>
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

    <div id="announcments" class="modal fade" tabindex="-1" role="dialog">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title">Content</h4>
          </div>
          <div class="modal-body">
              <div class="row">
                <div class="col-md-12">
                    <div class="form-group">
                        <p>Assignment 1 is posted and the questions attached the file.</p>
                        <a href="bb.png" download>Assignment 1</a><br>
                        <a href="bb.png" download>Lab Solutions</a>
                    </div>
                </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
          </div>
        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
	
	
	<%@include file="script.jsp" %>

        <script>
            $(document).ready(function () {
                $('#dataTables-example').dataTable();
            });
    </script>
</body>

</html>
