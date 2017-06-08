<%@ page import="pojos.Assignment" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Assignment assignment = (Assignment)session.getAttribute("uploadedAssignment"); %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Blackboard - Assignments</title>
        <%@include file="style.jsp" %>

</head>

<body>
<%@include file="head.jsp" %>

<div class="container">
    <div class="row text-center">
        <div class="col-sm-6 col-sm-offset-3">
            <br><br> <h2 style="color:#0fad00">Success</h2>
            <img src="http://osmhotels.com//assets/check-true.jpg">
            <h3>Dear, <%=user.getNameSurname()%></h3>
            <p style="font-size:20px;color:#5C5C5C;">Your file is uploaded successfully for <%=assignment.getCourse().getName()%><br>The page is redirecting...</p>
        </div>

        <script>
            setTimeout(function () {
                window.location.href = "${pageContext.request.contextPath}/student/assignments";
            },2000)
        </script>

    </div>
</div>
</body>
</html>
