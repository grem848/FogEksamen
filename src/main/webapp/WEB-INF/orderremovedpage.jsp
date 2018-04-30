<%-- 
    Document   : orderRemoved
    Created on : 27-04-2018, 18:10:12
    Author     : mohammahomarhariri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>orderRemoved.jsp</title>
    </head>
    <body>
        <h1>Order removed!</h1>

        <p>Order have been removed succesfully!</p>
        <br>
        
        <form action="FrontController" method="Post">
            <input type="hidden" name="command" value="employeeorderlist">
            <input type="submit" value="back to OrderList">
        </form>
    </body>
</html>
