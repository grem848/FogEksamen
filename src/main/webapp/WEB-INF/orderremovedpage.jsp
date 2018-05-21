

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>orderRemoved.jsp</title>
    </head>
    <body>
         <%@include file="../includes/menu.jsp" %>
        <h1>Order removed!</h1>

        <p>Order have been removed succesfully!</p>
        <br>
        
        <form name="Building" action="FrontController" method="POST">
            <input type="hidden" name="command" value="employeerequestpage" />
            <input type="submit" value="Customer request List" />
        </form>
        <%@include file="../includes/footer.jsp" %>
    </body>
</html>
