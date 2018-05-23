

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Edited Page</title>
    </head>
    <body>
         <%@include file="../includes/menu.jsp" %>

        <h1>Order has been edited</h1>
        <br>
        <form name="Building" action="FrontController" method="POST">
            <input type="hidden" name="command" value="employeeorderlist" />
            <input type="submit" value="Go back to Order List" />
        </form>

    </body>
     <%@include file="../includes/footer.jsp" %>

</html>
