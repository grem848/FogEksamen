<%-- 
    Document   : employeeOrderList
    Created on : 24-03-2018, 17:31:05
    Author     : Andreas Heick Laptop
--%>

<%@page import="PresentationLayer.Order"%>
<%@page import="java.util.List"%>
<%@page import="FunctionLayer.OrderBOM"%>
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
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }

    </style>
    <body>
        <h1>Customer Orders</h1>

        <table class="table table-striped">
            <tr>
                <th>OrderID</th>
                <th>UserID</th>
                <th>Length</th> 
                <th>Width</th>
                <th>Height</th>
                <th>Status</th>
                <th>Order details</th>
            </tr>
            <%

                if (request.getAttribute("allOrders") != null)
                {
                    String status;
                    List<OrderBOM> orderlist = (List<OrderBOM>) request.getAttribute("allOrders");

                    for (OrderBOM orderBOM : orderlist)
                    {
                        if (orderBOM.isSent() == true)
                        {
                            status = "Sent";
                        } else
                        {
                            status = "Pending";
                        }
            %>
            <tr>
                <td><%= orderBOM.getOrderid()%></td>
                <td><%= orderBOM.getId()%></td>
                <td><%= orderBOM.getLength()%></td>
                <td><%= orderBOM.getWidth()%></td>
                <td><%= orderBOM.getHeight()%></td>
                <td><%=status%></td>
                <td>
                    <div class="form-group">
                        <form name="orderdetails" action="FrontController" method="Post">
                            <input type="hidden" name="command" value="orderSent">
                            <input type="hidden" name="id" value="<%= orderBOM.getOrderid()%>">
                            <input class="btn btn-primary" type="submit" name="order" value="Ship Order">
                        </form>
                    </div>
                </td>
            </tr>
            <% }
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
