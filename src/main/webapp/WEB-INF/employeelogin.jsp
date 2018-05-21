
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Login page</title>
    </head>
    <body>
    <center>
       <%@include file="../includes/menu.jsp" %>
        <h3>Employee Login</h3>
        <table>
                <td>
                    <form name="login" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="login">
                        Email:<br>
                        <input type="text" name="email" placeholder="Type an email" value="admin">
                        <br>
                        Password:<br>
                        <input type="password" name="password" placeholder="Type password" value="admin">
                        <br>
                        <input type="submit" value="Submit">
                    </form>
                </td>
        </table>
        <form name="Building" action="FrontController" method="POST">
            <input type="hidden" name="command" value="logout" />
            <input type="submit" value="Back to Customer Page" />
        </form>
        For help <a href="FrontController?command=help"> click here </a>
        <br>
        <br>

        <% String error = (String) request.getAttribute("error");
            if (error != null)
            {%>
        <H2>Error!!</h2>
        <p><%= error%>
            <% }
       
%>
</center>
</body>
           <%@include file="../includes/footer.jsp" %>
</html>
