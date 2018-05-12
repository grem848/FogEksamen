<%-- 
    Document   : Result
    Created on : 08-05-2018, 13:43:09
    Author     : mohammahomarhariri
--%>

<%@page import="FunctionLayer.Product"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table, th, td {
                border: 1px solid black;
            }

        </style>
    </head>
    <body>
        <h1>Bill of Materials!</h1>
        <table>
            <tr>
                <th>Beslag & Skruer</
            </tr>
            <tr>
                <th>Product</th>
                <th>Amount</th> 
                <th>Price</th>
                <th></th>
            </tr>

            <%
                request.getParameter("shedLength");
                if (request.getAttribute("res") != null)
                {

                    List<Product> res = (List<Product>) request.getAttribute("res");

                    for (Product product : res)
                    {
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
        <table>
            <tr>
                <th>Træ & Tagplader</
            </tr>
            <tr>
                <th>Product</th>
                <th>Amount</th> 
                <th>Price</th>
                <th></th>
            </tr>

            <%
                request.getParameter("shedLength");
                if (request.getAttribute("res2") != null)
                {

                    List<Product> res2 = (List<Product>) request.getAttribute("res2");

                    for (Product product : res2)
                    {
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

    </body>
</html>
