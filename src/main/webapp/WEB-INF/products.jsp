
<%@page import="FunctionLayer.LoginSampleException"%>
<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Page</title>
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
        <h1>Lego House Builder</h1>
        <% User user = (User) session.getAttribute("user"); %>
        <h2>Hello
            <%=user.getEmail()%>
        </h2>
        <table>
            <tr>
                <th>Brick Type</th>
                <th>Dots</th>
            </tr>
            <tr>
                <td>Small</td>
                <td>1x2</td>
            </tr>
            <tr>
                <td>Medium</td>
                <td>2x2</td>
            </tr>
            <tr>
                <td>Large</td>
                <td>2x4</td>
            </tr>
        </table>

        <form name="Building" action="FrontController" method="POST">
            <input type="hidden" name="command" value="bom">
            Length:<br>
            <input type="number" name="length" min="4" value="" placeholder="Type Length (dots)" required>
            <br>
            Width:<br>
            <input type="number" name="width" min="4" value="" placeholder="Type Width (dots)" required>
            <br>
            Height:<br>
            <input type="number" name="height" min="1" value="" placeholder="Type Height (bricks)" required>
            <br>
            <input type="submit" value="Submit">
            <input type="reset" value="Reset">
        </form>
        <br>
        <form name="Building" action="FrontController" method="POST">
            <input type="hidden" name="command" value="customer" />
            <input type="submit" value="Back to Customer Page" />
        </form>
    </body>
</html>
