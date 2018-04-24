
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome page</title>
    </head>
    <body>
        <h1>Lego House Builders A/S</h1>
        
        <table>
            <tr><td>Login</td>
                <td>
                    <form name="login" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="login">
                        Email:<br>
                        <input type="text" name="email" placeholder="Type an email">
                        <br>
                        Password:<br>
                        <input type="password" name="password" placeholder="Type password">
                        <br>
                        <input type="submit" value="Submit">
                    </form>
                </td>
                <td>Or Register</td>
                <td>
                    <form name="register" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="register">
                        Email:<br>
                        <input type="text" name="email" placeholder="Type an email">
                        <br>
                        Password:<br>
                        <input type="password" name="password1" placeholder="Type password">
                        <br>
                        Retype Password:<br>
                        <input type="password" name="password2" placeholder="Retype password">
                        <br>
                        <input type="submit" value="Submit">
                    </form>
                </td>
            </tr>
        </table>
        
        For help <a href="FrontController?command=help"> click here </a>
        <br>
        <br>
        
        <% String error = (String) request.getAttribute( "error");
           if ( error != null) { %>
           <H2>Error!!</h2>
           <p><%= error %>
        <% }
        %>
    </body>
</html>
