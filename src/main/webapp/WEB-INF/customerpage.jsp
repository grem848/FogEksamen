

<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>
    </head>
    <body>
        <% User user = (User) session.getAttribute("user"); %>
        <h1>Hello <%=user.getEmail()%> </h1>
        You are now logged in as a customer of our wonderful site.
        <br>
        <br>
        <form name="Building" action="FrontController" method="POST">
            <input type="hidden" name="command" value="products" />
            <input type="submit" value="Lego House Builder" />
        </form>
        <form name="Building" action="FrontController" method="POST">
            <input type="hidden" name="command" value="orderlist" />
            <input type="submit" value="Order History" />
        </form>
        <form name="Building" action="FrontController" method="POST">
            <input type="hidden" name="command" value="logout" />
            <input type="submit" value="Logout" />
        </form>
    </body>
</html>
