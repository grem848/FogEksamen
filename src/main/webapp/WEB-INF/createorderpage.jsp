

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Order</title>
    </head>
    <body>
        <h1>Create Your Order!</h1>
        <form name="Building" action="FrontController" method="POST">
            <input type="hidden" name="command" value="orderconfirmed">    
            <br>
            <p>tlf:</p>
            <br>
            <input type="text" name="tlf" placeholder="12345678" value="1">
            <br>
            <p>Email:</p>
            <br>
            <input type="text" name="email" placeholder="something@nothing.dk" value="hej">
            <br>
            <p>Length:</p>
            <br>
            <input type="text" name="length" placeholder="0" value="1">
            <br>
            <p>Width:</p>
            <br>
            <input type="text" name="width" placeholder="0" value="1">
            <br>
            <p>height:</p>
            <br>
            <input type="text" name="height" placeholder="0" value="1">
            <br>
            <p>shedLength (Optional): </p>
            <br>
            <input type="text" name="shedLength" placeholder="0" value="1">
            <br>
            <p>shedWidth (Optional): </p>
            <br>
            <input type="text" name="shedWidth" placeholder="0" value="1">
            <br>
            <p>Slope</p>
            <br>
            <input type="text" name="slopedRoof" placeholder="0" value="1">

            <input type="submit" name="Submit">

        </form>
        <form name="Building" action="FrontController" method="POST">
            <input type="hidden" name="command" value="employee" />
            <input type="submit" value="Back to Employee Page" />
        </form>

    </body>
</html>

