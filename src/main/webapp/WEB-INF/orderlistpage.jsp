<%@page import="java.util.List"%>
<%@page import="FunctionLayer.OrderBOM"%>
<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order History Page</title>
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
        <%
            User user = (User) session.getAttribute("user");
        %>
        <h1>Order History</h1>
        <h2>Hello
            <% out.println(user.getEmail());%>
        </h2>
        <table class="table table-striped">
            <tr>
                <th>OrderID</th>
                <th>Length</th> 
                <th>Width</th>
                <th>Height</th>
                <th>Status</th>
            </tr>
            <%

                if (request.getAttribute("orders") != null) {
                    String status;
                    List<OrderBOM> orderlist = (List<OrderBOM>) request.getAttribute("orders");

                    for (OrderBOM orderBOM : orderlist) {
                        if (orderBOM.isSent() == true) {
                            status = "Sent";
                        } else {
                            status = "Pending";
                        }
            %>
            <tr>
                <td><%= orderBOM.getOrderid()%></td>
                <td><%= orderBOM.getLength()%></td>
                <td><%= orderBOM.getWidth()%></td>
                <td><%= orderBOM.getHeight()%></td>
                <td><%=status%></td>
                <td>

                </td>
            </tr>
            <% }
                }%>
        </table>
    </body>
    <br>
    <form name="Building" action="FrontController" method="POST">
        <input type="hidden" name="command" value="customer" />
        <input type="submit" value="Back to Customer Page" />
    </form>
</html>
