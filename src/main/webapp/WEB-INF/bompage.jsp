<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bill of Materials Page</title>
    </head>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
    <body>
        <% User user = (User) session.getAttribute("user"); %>
        <h1>Bill of Materials</h1>
        <h2>Hello
            <% out.println(user.getEmail());%>
        </h2>
    </body>
    Length:<br>
    <%=request.getParameter("length")%> 
    <br>
    Width:<br>
    <%=request.getParameter("width")%>
    <br>
    Height:<br>
    <%=request.getParameter("height")%>
    <br>
    Total Dots:<br>
    <%=request.getAttribute("totalDots")%>
    <br>
    <br>

    <table border="1">  
        <tr>
            <th>Brick Type</th>
            <th>Side 1:</th>
            <th>Side 2:</th>
            <th>Side 3:</th>
            <th>Side 4:</th>
            <th>Total Bricks</th>
        </tr>    
        <tr>
            <th>Large (2x4)</th>
            <th><%=request.getAttribute("largeTotalLength")%></th>
            <th><%=request.getAttribute("largeTotalWidth")%></th>
            <th><%=request.getAttribute("largeTotalLength")%></th>
            <th><%=request.getAttribute("largeTotalWidth")%></th>
            <th><%=request.getAttribute("totalLargeBricks")%></th>
        </tr> 
        <tr>
            <th>Medium (2x2)</th>
            <th><%=request.getAttribute("mediumTotalLength")%></th>
            <th><%=request.getAttribute("mediumTotalWidth")%></th>
            <th><%=request.getAttribute("mediumTotalLength")%></th>
            <th><%=request.getAttribute("mediumTotalWidth")%></th>
            <th><%=request.getAttribute("totalMediumBricks")%></th>
        </tr> 
        <tr>
            <th>Small (1x2)</th>
            <th><%=request.getAttribute("smallTotalLength")%></th>
            <th><%=request.getAttribute("smallTotalWidth")%></th>
            <th><%=request.getAttribute("smallTotalLength")%></th>
            <th><%=request.getAttribute("smallTotalWidth")%></th>
            <th><%=request.getAttribute("totalSmallBricks")%></th>
        </tr>
        <tr>
            <th>Total</th>
            <th><%=request.getAttribute("sideLengthTotal")%></th>
            <th><%=request.getAttribute("sideWidthTotal")%></th>
            <th><%=request.getAttribute("sideLengthTotal")%></th>
            <th><%=request.getAttribute("sideWidthTotal")%></th>
            <th><%=request.getAttribute("totalBricks")%></th>
        </tr>
    </table>
    <form name="Building" action="FrontController" method="POST">
        <input type="hidden" name="command" value="order">
        <input type="hidden" name="length" value="<%=request.getParameter("length")%>">
        <input type="hidden" name="width" value="<%=request.getParameter("width")%>">
        <input type="hidden" name="height" value="<%=request.getParameter("height")%>">
        <input type="submit" value="Confirm Order">
    </form>
    <form name="Building" action="FrontController" method="POST">
        <input type="hidden" name="command" value="products" />
        <input type="submit" value="Back to Lego House Builder" />
    </form>
    <form name="Building" action="FrontController" method="POST">
        <input type="hidden" name="command" value="customer" />
        <input type="submit" value="Back to Customer Page" />
    </form>
    <br>
</html>