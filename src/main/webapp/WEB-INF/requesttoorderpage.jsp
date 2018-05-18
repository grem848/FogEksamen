

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Sent Page</title>
    </head>
    <body>
        <h1>Request has been made an Order!</h1>
        <br>
        <form name="Building" action="FrontController" method="POST">
            <input type="hidden" name="command" value="employee" />
            <input type="submit" value="Back to Employee Page" />
        </form>

        <form action="FrontController" method="POST">
            <input type="hidden" name="command" value="employeeorderlist">
            <input type="submit" value="Back to Order List">            
        </form>
        <form name="Building" action="FrontController" method="POST">
            <input type="hidden" name="command" value="employeerequestpage" />
            <input type="submit" value="Back to Request List" />
        </form>
    </body>
</html>
