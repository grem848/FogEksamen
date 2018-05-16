

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Finished Page</title>
    </head>
    <body>
        <h1>Order is Finished and shipped!</h1>
        <h2>BOM here</h2>
        <h2>Sketch here</h2>
        <br>

        <form action="FrontController" method="POST">
            <input type="hidden" name="command" value="employeeorderlist">
            <input type="submit" value="Back to OrderList">            
        </form>
       
    </body>
</html