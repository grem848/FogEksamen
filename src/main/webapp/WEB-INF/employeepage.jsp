<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>

<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee home page</title>
    </head>
    <body>
        <% User user = (User) session.getAttribute("user"); %>
        <h1>Hello <%=user.getEmail()%> </h1>
        You are now logged in as a EMPLOYEE of our wonderful site.


    </form>
    <form name="Building" action="FrontController" method="POST">
        <input type="hidden" name="command" value="employeeOrderList" />
        <input type="submit" value="Customer Order List" />
    </form>
    <form name="Building" action="FrontController" method="POST">
        <input type="hidden" name="command" value="logout" />
        <input type="submit" value="Logout" />
    </form>
</body>
</html>
