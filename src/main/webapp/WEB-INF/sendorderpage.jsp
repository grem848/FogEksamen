

<%@page import="FunctionLayer.Product"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Finished Page</title>


        <style>

            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            td, th {
                border: 1px solid #333333;
                text-align: left;
                padding: 2px;
            }

            tr:nth-child(even) {
                background-color: #dddddd;
            }

        </style>

    </head>
    <body>
        <%@include file="../includes/menu.jsp" %>
        <h1>Order is Finished and shipped!</h1>
        <h3>These informations are sent to email: <%=request.getAttribute("email")%></h3>
        <br>
        
        <%int totalPrice = (int) request.getAttribute("totalPrice");%>
        <h3>Price for your carport: <%= (int) (Math.ceil((totalPrice * 1.30) / 100.0)) * 100 - 1%> DKK </h3>
        <br>
        <h3>Bill of Materials</h3>
        <table>
            <tr>
                <th>Brackets and Screws</
            </tr>
            <tr>
                <th>Product</th>
                <th>Amount</th> 
                <th>Price</th>
                <th></th>
            </tr>

            <%
                request.getParameter("shedLength");
                if (request.getAttribute("res") != null) {

                    List<Product> res = (List<Product>) request.getAttribute("res");

                    for (Product product : res) {
            %>
            <tr>
                <td><%= product.getName()%></td>
                <td><%= product.getAmount()%></td>
                <td><%= product.getPrice()%> DKK</td>
                <td>

                </td>
            </tr>
            <% }
                }%>
        </table>
        <br>
        <table>
            <tr>
                <th>Wood & Eaves</
            </tr>
            <tr>
                <th>Product</th>
                <th>Amount</th> 
                <th>Price</th>
                <th></th>
            </tr>

            <%
                request.getParameter("shedLength");
                if (request.getAttribute("res2") != null) {

                    List<Product> res2 = (List<Product>) request.getAttribute("res2");

                    for (Product product : res2) {
            %>
            <tr>
                <td><%= product.getName()%></td>
                <td><%= product.getAmount()%></td>
                <td><%= product.getPrice()%> DKK</td>
                <td>

                </td>
            </tr>
            <% }
                }%>
        </table>
        <br>
        <%= request.getAttribute("virtual")%>
        <br>
        <br>
        <br>
        <form action="FrontController" method="POST">
            <input type="hidden" name="command" value="employeeorderlist">
            <input type="submit" value="Back to OrderList">            
        </form>
        <%@include file="../includes/footer.jsp" %>
    </body>
</html