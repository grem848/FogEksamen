<%-- 
    Document   : ordersentpage
    Created on : 24-03-2018, 17:44:57
    Author     : Andreas Heick Laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Finished Page</title>
    </head>
    <body>
        <h1>Order is Finished and shipped!</h1>
        <br>
        <form name="Building" action="FrontController" method="POST">
            <input type="hidden" name="command" value="employee" />
            <input type="submit" value="Back to Employee Page" />
        </form>

        <form action="FrontController" method="POST">
            <input type="hidden" name="command" value="employeeorderlist">
            <input type="submit" value="Back to OrderLists">            
        </form>
       
    </body>
</html