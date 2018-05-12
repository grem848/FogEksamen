

<%@page import="FunctionLayer.VirtualCalculator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Visualization of your carport!</h1>

        <%= request.getAttribute("virtual")%>

        </SVG>
        
        <form>
            <input type="button" value="Back to Customer Page" onclick="history.back()">
        </form>
    </body>
</html>
