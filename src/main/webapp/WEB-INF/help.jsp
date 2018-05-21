
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Help Page</title>
    </head>
    <body>
         <%@include file="../includes/menu.jsp" %>
        <h1>Help is on the way!</h1>
        <%@include file="../includes/footer.jsp" %>
    </body>
    <form>
        <input type="button" value="Go back!" onclick="history.back()">
    </form>
</html>