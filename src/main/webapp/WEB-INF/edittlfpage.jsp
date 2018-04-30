<%-- 
    Document   : edittlfpage
    Created on : 29-04-2018, 00:18:51
    Author     : mohammahomarhariri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>telefone have been changed </h1>
        <br>
        <form name="Building" action="FrontController" method="POST">
            <input type="hidden" name="command" value="employeeorderlist" />
            <input type="submit" value="Go back to Order List" />
        </form>

    </body>
</html>
