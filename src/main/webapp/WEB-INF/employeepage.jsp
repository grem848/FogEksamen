

<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee home page</title>
    </head>
    <body>
        <% User user = (User) session.getAttribute("user");%>
        <h1>Hello <%=user.getEmail()%> </h1>
        You are now logged in as a EMPLOYEE of our wonderful site.

        <form name="Building" action="FrontController" method="POST">
            <input type="hidden" name="command" value="createorderpage">
            <input type="submit" value="Go to Create Order Page">
        </form>
        <form name="Building" action="FrontController" method="POST">
            <input type="hidden" name="command" value="employeeorderlist" />
            <input type="submit" value="Customer Order List" />
        </form>
        <form name="Building" action="FrontController" method="POST">
            <input type="hidden" name="command" value="employeerequestpage" />
            <input type="submit" value="Customer request List" />
        </form>
        <br>
    <td>Register Admin</td>
    <td>
        <form name="register" action="FrontController" method="POST">
            <input type="hidden" name="command" value="register">
            Email:<br>
            <input type="text" name="email" placeholder="Type an email">
            <br>
            Password:<br>
            <input type="password" name="password1" placeholder="Type password">
            <br>
            Retype Password:<br>
            <input type="password" name="password2" placeholder="Retype password">
            <br>
            <input type="submit" value="Submit">
        </form>
    </td>
    <br>
    <form name="Building" action="FrontController" method="POST">
        <input type="hidden" name="command" value="logout" />
        <input type="submit" value="Logout" />
    </form>
</body>
</html>
