

<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee home page</title>
    </head>
    
    
    
    <style>
    input[type=submit] {
    float: center;
    margin-center: 10px;
    margin-top: 10px;
    width: 150px;
    height: 30px;
}

    </style>
    <body>
         <%@include file="../includes/menu.jsp" %>
 
    <center>
        <% User user = (User) session.getAttribute("user");%>
        <h1>Hello <%=user.getEmail()%> </h1>
        You are now logged in as a EMPLOYEE of our wonderful site.

        <form name="Building" action="FrontController" method="POST">
            <input type="hidden" name="command" value="createorderpage">
            <input type="submit" value="Create Request Page">
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
    <td>Register a new Admin</td>
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
    </center>
     <%@include file="../includes/footer.jsp" %>
</body>
</html>
