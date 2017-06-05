
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Login</title>
	<%@ include file="style.jsp"%>
  </head>
  <body class="login-body">
  	<form action="" method="post">
	    <div class="container">
	      <div class="col-lg-6 col-lg-offset-3">
	        <div class="jumbotron login-form">
		      <div class="text-center">
	          </div>
		        
	        <h2><b class="blackboard">BLACKBOARD</b></h2></br>
	          <form>
	              <div class="form-group">
	                <input type="email" name="email" class="form-control" placeholder="E-Mail">
	              </div>
	              <div class="form-group">
	                <input type="password" name="password" class="form-control" placeholder="Password">
	              </div>
	              <button type="submit" class="btn btn-primary form-control" name="button">Sign In</button>
	          </form>
	        </div>
	      </div>
	    </div>
	</form>
	<%@ include file="script.jsp"%>

  </body>
</html>
