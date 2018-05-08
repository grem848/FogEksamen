

<%@page import="FunctionLayer.VirtualCalculator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Visualisering!</h1>

        <%= request.getAttribute("virtual")%>

        </SVG>
        <form name="Building" action="FrontController" method="POST">
            <input type="hidden" name="command" value="logout" />
            <input type="submit" value="Back to Customer Page" />
        </form>
    </body>
</html>
