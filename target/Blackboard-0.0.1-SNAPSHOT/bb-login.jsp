<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title></title>
		<%@include file="style.jsp" %>
   
    </head>
    <body>
        <form class="" action="" method="post">
            <div class="row">
              <div class="col-md-4 col-md-offset-4">
                  <div class="row">
                      <div class="col-md-12 form-group">
                          <input class="form-control" type="text" name="email" value="" placeholder="E-Mail">
                      </div>
                    </div>
                <div class="row">
                    <div class="col-md-12 form-group">
                        <input class="form-control" type="password" name="password" value="" placeholder="Password">
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col-md-12">
                        <button class="btn btn-success btn-block" type="submit" name="button">Sign In</button>
                    </div>
                </div>
            </div>
        </div>
        </form>

    </body>
    <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>
    <script src="./assets/js/bootstrap.min.js"></script>

</html>
