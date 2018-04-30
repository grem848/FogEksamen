

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
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }

    </style>
    <body>
        <h1>Edit Order!</h1>




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
                <th>Sloped Roof</th>
                <th>Status</th>
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
                <td><%= order.getSlopedRoof()%></td>
                <td><%= order.getStatus()%></td>

            </tr>

            <tr>
                <td>

                </td>
                <td>
                    <form action="FrontController">
                        <input type="number" name="number" placeholder="12345678">
                        <input type="hidden" name="command" value="edittlfpage">
                        <input type="hidden" name="id" value="<%= order.getId()%>">
                        <input type="submit" value="Change Number">
                    </form>    
                </td>
                <td>
                    <form action="FrontController">
                        <input type="text" name="email" placeholder="something@something.dk">
                        <input type="hidden" name="command" value="editemailpage">
                        <input type="hidden" name="id" value="<%= order.getId()%>">
                        <input type="submit" value="Change Email">
                    </form>    
                </td>
                <td>
                    <form action="FrontController">
                        <input type="number" name="length" placeholder="30">
                        <input type="hidden" name="command" value="editlengthpage">
                        <input type="hidden" name="id" value="<%= order.getId()%>">
                        <input type="submit" value="Change Length">
                    </form>    
                </td>
                <td>
                    <form action="FrontController">
                        <input type="number" name="height" placeholder="10">
                        <input type="hidden" name="command" value="editheightpage">
                        <input type="hidden" name="id" value="<%= order.getId()%>">
                        <input type="submit" value="Change Height">
                    </form>    
                </td>                
                <td>
                    <form action="FrontController">
                        <input type="number" name="width" placeholder="20">
                        <input type="hidden" name="command" value="editwidthpage">
                        <input type="hidden" name="id" value="<%= order.getId()%>">
                        <input type="submit" value="Change Width">
                    </form>    
                </td>
                <td>
                    <form action="FrontController">
                        <input type="number" name="shedLength" placeholder="5">
                        <input type="hidden" name="command" value="editshedlengthpage">
                        <input type="hidden" name="id" value="<%= order.getId()%>">
                        <input type="submit" value="Change Shed Length">
                    </form>    
                </td>
                <td>
                    <form action="FrontController">
                        <input type="number" name="shedWidth" placeholder="10">
                        <input type="hidden" name="command" value="editshedwidthpage">
                        <input type="hidden" name="id" value="<%= order.getId()%>">
                        <input type="submit" value="Change Shed Width">
                    </form>    
                </td>
                <td>
                    <form action="FrontController">
                        <input type="number" name="slope" placeholder="10">
                        <input type="hidden" name="command" value="editslopedroofpage">
                        <input type="hidden" name="id" value="<%= order.getId()%>">
                        <input type="submit" value="Change Roof Slope">
                    </form>    
                </td>
                <td>
                    
                </td>
            </tr>

            <br>

            <form name="Building" action="FrontController" method="POST">
                <input type="hidden" name="command" value="employeeorderlist" />
                <input type="submit" value="Go back to Order List" />
            </form>

            <br>
            </body>
            </html>
