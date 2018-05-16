

<%@page import="FunctionLayer.Product"%>
<%@page import="java.util.List"%>
<%@page import="FunctionLayer.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Order page</title>

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

        <%int totalPrice = (int) request.getAttribute("totalPrice");%>

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
                <th>Price DKK</th>  
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
                            <input type="number" name="price" placeholder="10,000" value="<%= (int) (Math.ceil((totalPrice * 1.30) / 100.0)) * 100 - 1%>" required>
                            <input type="hidden" name="id" value="<%= order.getPrice()%>">
                        </td>
                        <td>
                            <input type="number" name="slope" placeholder="10" value="<%= order.getSlopedRoof()%>" required>
                            <input type="hidden" name="id" value="<%= order.getId()%>">
                        </td>
                    </form>    

            </tr>
        </table>
        <h3>Standard Dimensions</h3>             
        Carport Width
        <select name="carportWidth" title="Carport Width">
            <option value="240">240 cm</option>
            <option value="270">270 cm</option>
            <option value="300">300 cm</option>
            <option value="330">330 cm</option>
            <option value="360">360 cm</option>
            <option value="390">390 cm</option>
            <option value="420">420 cm</option>
            <option value="450">450 cm</option>
            <option value="480">480 cm</option>
            <option value="510">510 cm</option>
            <option value="540">540 cm</option>
            <option value="570">570 cm</option>
            <option value="600">600 cm</option>
            <option value="630">630 cm</option>
            <option value="660">660 cm</option>
            <option value="690">690 cm</option>
            <option value="720">720 cm</option>
            <option value="750">750 cm</option>
        </select>
        <br>
        <br>
        Carport Length
        <select name="carportLength" title="Carport Length">
            <option value="690">240 cm</option>
            <option value="675">270 cm</option>
            <option value="660">300 cm</option>
            <option value="645">330 cm</option>
            <option value="630">360 cm</option>
            <option value="615">390 cm</option>
            <option value="600">420 cm</option>
            <option value="585">450 cm</option>
            <option value="570">480 cm</option>
            <option value="555">510 cm</option>
            <option value="540">540 cm</option>
            <option value="525">570 cm</option>
            <option value="510">600 cm</option>
            <option value="495">630 cm</option>
            <option value="480">660 cm</option>
            <option value="465">690 cm</option>
            <option value="450">720 cm</option>
            <option value="435">750 cm</option>
            <option value="420">780 cm</option>
        </select>
        <br>
        <br>
        Carport Actual Height
        <select name="carportHeight" title="Carport Height">
            <option value="195">210 cm</option>
            <option value="192">215 cm</option>
            <option value="190">220 cm</option>
            <option value="187">225 cm</option>
            <option value="185">230 cm</option>
            <option value="182">235 cm</option>
            <option value="180">240 cm</option>
        </select>
        <br>
        <br>
        Carport Shed Width
        <select name="shedWidth" title="Shed Width">
            <option value="210">210 cm</option>
            <option value="240">240 cm</option>
            <option value="270">270 cm</option>
            <option value="300">300 cm</option>
            <option value="330">330 cm</option>
            <option value="360">360 cm</option>
            <option value="390">390 cm</option>
            <option value="420">420 cm</option>
            <option value="450">450 cm</option>
            <option value="480">480 cm</option>
            <option value="510">510 cm</option>
            <option value="540">540 cm</option>
            <option value="570">570 cm</option>
            <option value="600">600 cm</option>
            <option value="630">630 cm</option>
            <option value="660">660 cm</option>
            <option value="690">690 cm</option>
            <option value="720">720 cm</option>
        </select>
        <br>
        <br>
        Carport Shed Length
        <select name="shedLength" title="Shed Length">
            <option value="150">150 cm</option>
            <option value="180">180 cm</option>
            <option value="210">210 cm</option>
            <option value="240">240 cm</option>
            <option value="270">270 cm</option>
            <option value="300">300 cm</option>
            <option value="330">330 cm</option>
            <option value="360">360 cm</option>
            <option value="390">390 cm</option>
            <option value="420">420 cm</option>
            <option value="450">450 cm</option>
            <option value="480">480 cm</option>
            <option value="510">510 cm</option>
            <option value="540">540 cm</option>
            <option value="570">570 cm</option>
            <option value="600">600 cm</option>
            <option value="630">630 cm</option>
            <option value="660">660 cm</option>
            <option value="690">690 cm</option>
        </select>
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
