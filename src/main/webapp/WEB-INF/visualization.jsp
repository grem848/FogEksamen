

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
        <form name="Building" action="FrontController" method="POST">
            <input type="hidden" name="command" value="result"/>
            <input type="hidden" name="carportWidth" value="<%=request.getParameter("carportWidth")%>">
            <input type="hidden" name="carportLength" value="<%=request.getParameter("carportLength")%>">
            <input type="hidden" name="shedWidth" value="<%=request.getParameter("shedWidth")%>">
            <input type="hidden" name="shedLength" value="<%=request.getParameter("shedLength")%>">
            <input type="submit" value="Result"/>
        </form>
        <form>
            <input type="button" value="Back to Customer Page" onclick="history.back()">
        </form>
    </body>
</html>
