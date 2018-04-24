<%-- 
    Document   : ordercreatedpage
    Created on : 22-03-2018, 15:38:38
    Author     : Andreas Heick Laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Created Page</title>
    </head>
    <body>
        <h1>Order created!</h1>
    </body>
    <br>
    <form name="Building" action="FrontController" method="POST">
        <input type="hidden" name="command" value="customer" />
        <input type="submit" value="Back to Customer Page" />
    </form>
</html>
