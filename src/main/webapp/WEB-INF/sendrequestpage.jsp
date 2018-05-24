

<%@page import="FunctionLayer.VirtualCalculator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%@include file="../includes/menu.jsp" %>

        <h1>Request Sent</h1>
        A FOG employee will contact you soon.
        <br>

        <%= request.getAttribute("virtual")%>

        </SVG>
        
        <form name="Building" action="FrontController" method="POST">
            <input type="hidden" name="command" value="logout">
            <input type="submit" value="Back to Customer Page">
        </form>
    </body>
     <%@include file="../includes/footer.jsp" %>

</html>
