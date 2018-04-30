

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmed</title>
    </head>
    <body>
        <h1>Order Creation have been Confirmed!</h1>
    </body>
        <form name="Building" action="FrontController" method="POST">
            <input type="hidden" name="command" value="employee" />
            <input type="submit" value="Back to Employee Page" />
        </form>
        <form action="FrontController" action="FrontController" method="POST">
            <input type="hidden" name="command" value="createorderpage">
            <input type="submit" value="Back To Create Order Page">
        </form>
</html>
