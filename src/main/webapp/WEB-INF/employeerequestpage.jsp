
<%@page import="FunctionLayer.Order"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Orders Page</title>
    </head>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #333333;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }

    </style>
    <body>
        <h1>Customer Request</h1>

        <table class="table table-striped">
            <tr> 

                <th>OrderID</th>
                <th>Tel.</th>
                <th>Email</th> 
                <th>Length</th>
                <th>Height</th>
                <th>Width</th>
                <th>Shed Length</th>
                <th>Shed Width</th>  
                <th>Sloped Roof</th>
                <th>Price</th>
                <th>Status</th>
                <th>Options</th>
            </tr>
            <%

                List<Order> userOrders = (List<Order>) request.getAttribute("allOrders");
                for (Order order : userOrders)
                {
            %>
            <tr>
                <td><%= order.getId()%></td>
                <td><%= order.getTlf()%></td>
                <td><%= order.getEmail()%></td>
                <td><%= order.getLength()%></td>
                <td><%= order.getHeight()%></td>
                <td><%= order.getWidth()%></td>
                <td><%= order.getShedLength()%></td>
                <td><%= order.getShedWidth()%></td>
                <td><%= order.getSlopedRoof()%></td>
                <td><%= order.getPrice()%></td>
                <td><%= order.getStatus()%></td>
                <td>
                    <form name="orderdetails" action="FrontController" method="Post">
                        <input type="hidden" name="command" value="orderremovedpage">
                        <input type="hidden" name="id" value="<%= order.getId()%>">
                        <input class="btn btn-primary" type="submit" name="order" value="Delete Request" onclick="return confirm('Are you sure you want to delete this order, this action cant be reversed')" >
                    </form>
                    <div class="form-group">
                        <form name="orderdetails" action="FrontController" method="Post">
                            <input type="hidden" name="command" value="ordersent">
                            <input type="hidden" name="id" value="<%= order.getId()%>">
                            <input class="btn btn-primary" type="submit" name="order" value="Change to Order">
                        </form>
                    </div>
                </td>
            </tr>
            <%
                }%>
        </table>
    </body>
    <br>
    <form>
        <form name="Building" action="FrontController" method="POST">
            <input type="hidden" name="command" value="employee" />
            <input type="submit" value="Back to Employee Page" />
        </form>
</html>
