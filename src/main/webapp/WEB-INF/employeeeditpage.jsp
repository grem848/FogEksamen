

<%@page import="FunctionLayer.Product"%>
<%@page import="java.util.List"%>
<%@page import="FunctionLayer.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>edit page</title>


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
            padding: 2px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }

    </style>
    <body>
        <h1>Edit Order</h1>




        <table class="table table-striped">
            <% Order order = (Order) request.getAttribute("order");%>
            <tr> 

                <th>OrderID</th>
                <th>Tel.</th>
                <th>Email</th> 
                <th>Length</th>
                <th>Height</th>
                <th>Width</th>
                <th>Shed Length</th>
                <th>Shed Width</th>  
                <th>Price</th>  
                <th>Sloped Roof</th>
            </tr>

            <tr>
                <td><%= order.getId()%></td>
                <td><%= order.getTlf()%></td>
                <td><%= order.getEmail()%></td>
                <td><%= order.getLength()%></td>
                <td><%= order.getHeight()%></td>
                <td><%= order.getWidth()%></td>
                <td><%= order.getShedLength()%></td>
                <td><%= order.getShedWidth()%></td>
                <td><%= order.getPrice()%></td>
                <td><%= order.getSlopedRoof()%></td>

            </tr>

            <tr>
                <td>
                    <form action="FrontController">
                        <input type="submit" value="Update Order">
                        </td>
                        <td>
                            <input type="number" name="tlf" placeholder="12345678" value="<%= order.getTlf()%>" required>
                            <input type="hidden" name="command" value="editorderpage">
                            <input type="hidden" name="id" value="<%= order.getId()%>">
                        </td>
                        <td>
                            <input type="text" name="email" placeholder="something@something.dk" value="<%= order.getEmail()%>" required>
                            <input type="hidden" name="id" value="<%= order.getId()%>">

                        </td>
                        <td>
                            <input type="number" name="length" placeholder="30" value="<%= order.getLength()%>" required>
                            <input type="hidden" name="id" value="<%= order.getId()%>">
                        </td>
                        <td>
                            <input type="number" name="height" placeholder="10" value="<%= order.getHeight()%>" required>
                            <input type="hidden" name="id" value="<%= order.getId()%>">
                        </td>                
                        <td>
                            <input type="number" name="width" placeholder="20" value="<%= order.getWidth()%>" required>
                            <input type="hidden" name="id" value="<%= order.getId()%>">
                        </td>
                        <td>
                            <input type="number" name="shedLength" placeholder="5" value="<%= order.getShedLength()%>" required>
                            <input type="hidden" name="id" value="<%= order.getId()%>">
                        </td>
                        <td>
                            <input type="number" name="shedWidth" placeholder="10" value="<%= order.getShedWidth()%>" required>
                            <input type="hidden" name="id" value="<%= order.getId()%>"> 
                        </td>
                        <td>
                            <input type="number" name="price" placeholder="10,000" value="<%= order.getPrice()%>" required>
                            <input type="hidden" name="id" value="<%= order.getPrice()%>">
                        </td>
                        <td>
                            <input type="number" name="slope" placeholder="10" value="<%= order.getSlopedRoof()%>" required>
                            <input type="hidden" name="id" value="<%= order.getId()%>">
                        </td>
                    </form>    

            </tr>
        </table>
        <br>

        <h3>Bill of Materials</h3>
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
        <br>

        <form name="Building" action="FrontController" method="POST">
            <input type="hidden" name="command" value="employeeorderlist" />
            <input type="submit" value="Go back to Order List" />
        </form>

        <br>
    </body>
</html>
