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
    </head>
    <body>
        <h1>view the producs!</h1>
        
                <table class="table table-striped">
            <tr>
                <th>Product</th>
                <th>Amount</th> 
                <th>Price</th>
            </tr>
            <%

                if (request.getAttribute("res") != null) {

                    List<Product> res = (List<Product>) request.getAttribute("res");

                    for (Product product : res) {
            %>
            <tr>
                <td><%= product.getName()%></td>
                <td><%= product.getAmount()%></td>
                <td><%= product.getPrice()%></td>
                <td>

                </td>
            </tr>
            <% }
                }%>
        </table>
        
    </body>
</html>
