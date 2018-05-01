
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome page</title>
    </head>
    <body>
        <h1>Johannes Fog A/S</h1>

        <table>
            <tr><td>Login</td>
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

        <form name="Building" action="FrontController" method="POST">
            <input type="hidden" name="command" value="visualisering" />
            <input type="submit" value="Visualisering" />
        </form>

        For help <a href="FrontController?command=help"> click here </a>
        <br>
        <br>

        <% String error = (String) request.getAttribute("error");
            if (error != null) {%>
        <H2>Error!!</h2>
        <p><%= error%>
            <% }
            %>
            <SVG width="600" height=800 viewBox="0 0 1200 1200" >
            <rect x="0" y="0" height="600" width="780"
                  style="stroke:#000000; fill: white"/>
            <%-- Linjer for spær --%>
            <line x1="55"  y1="0" x2="55"   y2="600" style="stroke:#006600; fill: "/>
            <line x1="110"  y1="0" x2="110"   y2="600" style="stroke:#006600; fill: "/>
            <line x1="165"  y1="0" x2="165"   y2="600" style="stroke:#006600; fill: "/>
            <line x1="220"  y1="0" x2="220"   y2="600" style="stroke:#006600; fill: "/>
            <line x1="275"  y1="0" x2="275"   y2="600" style="stroke:#006600; fill: "/>
            <line x1="330"  y1="0" x2="330"   y2="600" style="stroke:#006600; fill: "/>
            <line x1="385"  y1="0" x2="385"   y2="600" style="stroke:#006600; fill: "/>
            <line x1="440"  y1="0" x2="440"   y2="600" style="stroke:#006600; fill: "/>
            <line x1="495"  y1="0" x2="495"   y2="600" style="stroke:#006600; fill: "/>
            <line x1="550"  y1="0" x2="550"   y2="600" style="stroke:#006600; fill: "/>
            <line x1="605"  y1="0" x2="605"   y2="600" style="stroke:#006600; fill: "/>
            <line x1="660"  y1="0" x2="660"   y2="600" style="stroke:#006600; fill: "/>
            <line x1="715"  y1="0" x2="715"   y2="600" style="stroke:#006600; fill: "/>
            <%-- Linjer for spær --%>
            <line x1="55"  y1="0" x2="55"   y2="600" style="stroke:#006600; fill: "/>
            <line x1="110"  y1="0" x2="110"   y2="600" style="stroke:#006600; fill: "/>
            <line x1="165"  y1="0" x2="165"   y2="600" style="stroke:#006600; fill: "/>
            <line x1="220"  y1="0" x2="220"   y2="600" style="stroke:#006600; fill: "/>
            <line x1="275"  y1="0" x2="275"   y2="600" style="stroke:#006600; fill: "/>
            <line x1="330"  y1="0" x2="330"   y2="600" style="stroke:#006600; fill: "/>
            <line x1="385"  y1="0" x2="385"   y2="600" style="stroke:#006600; fill: "/>
            <line x1="440"  y1="0" x2="440"   y2="600" style="stroke:#006600; fill: "/>
            <line x1="495"  y1="0" x2="495"   y2="600" style="stroke:#006600; fill: "/>
            <line x1="550"  y1="0" x2="550"   y2="600" style="stroke:#006600; fill: "/>
            <line x1="605"  y1="0" x2="605"   y2="600" style="stroke:#006600; fill: "/>
            <line x1="660"  y1="0" x2="660"   y2="600" style="stroke:#006600; fill: "/>
            <line x1="715"  y1="0" x2="715"   y2="600" style="stroke:#006600; fill: "/>

            <%-- Linjer for stolper --%>

            <rect x="110" y="35" height="10" width="10"
                  style="stroke:#000000; fill-opacity: 0.0" stroke-width="2"/>
            <rect x="390" y="35" height="10" width="10"
                  style="stroke:#000000; fill-opacity: 0.0" stroke-width="2"/>
            <rect x="220" y="35" height="10" width="10"
                  style="stroke:#000000; fill-opacity: 0.0" stroke-width="2"/>
            <rect x="275" y="35" height="10" width="10"
                  style="stroke:#000000; fill-opacity: 0.0" stroke-width="2"/>
            <%-- Linjer for remme --%>

            <line x1="0"  y1="35" x2="780"   y2="35" style="stroke:#006600; fill: "/>
            <line x1="0"  y1="565" x2="780"   y2="565" style="stroke:#006600; fill: "/>

            <%-- Linjer for kryds --%>

            <line x1="55"  y1="35" x2="550"   y2="565" style="stroke:#006600; fill: "/>
            <line x1="55"  y1="565" x2="550"   y2="35" style="stroke:#006600; fill: "/>

            <%-- skur --%>
            <rect x="550" y="35" height="530" width="220"
                  style="stroke:#000000; fill-opacity: 0.0" stroke-width="2"/>
            <%-- Pile vertical--%>

    <marker id="beginArrow" 
            markerWidth="9" markerHeight="9" 
            refX="0" refY="4" 
            orient="auto">
        <path d="M0,4 L8,0 L8,8 L0,4" style="fill: red;" />
    </marker>
    <marker id="endArrow" 
            markerWidth="9" markerHeight="9" 
            refX="15" refY="4" 
            orient="auto">
        <path d="M0,0 L8,4 L0,8 L0,0" style="fill: red;" />
    </marker>

    <line x1="0"  y1="650" x2="780"   y2="650" 
          style="stroke:#006600;
          marker-start: url(#beginArrow);
          marker-end: url(#endArrow);"/>
    <text x="350" y="700"
          font-size="40px"
          text-anchor="middle">Width: 7.8 </text>

    <%-- Pile vertical --%>

    <marker id="beginArrow" 
            markerWidth="9" markerHeight="9" 
            refX="0" refY="4" 
            orient="auto">
        <path d="M0,4 L8,0 L8,8 L0,4" style="fill: red;" />
    </marker>
    <marker id="endArrow" 
            markerWidth="9" markerHeight="9" 
            refX="15" refY="4" 
            orient="auto">
        <path d="M0,0 L8,4 L0,8 L0,0" style="fill: red;" />
    </marker>

    <line x1="800"  y1="600" x2="800"   y2="0" 
          style="stroke:#006600;
          marker-start: url(#beginArrow);
          marker-end: url(#endArrow);"/>


    <text x="875" y="350"
          font-size="40px"
          text-anchor="middle"
          style="writing-mode: tb;">Height: 6 M</text>





    </SVG>
    <svg viewBox="0 0 700 700" width="400" height="400">
    <g transform="translate(350 620)">

    <!--body-->
    <path d="M0 -80 L0 0 L-30 75 M0 0 L30 75" fill="none" stroke="black" stroke-width="3" />
    <!--arms-->
    <path d="M40 -25 L0 -50 L-40 -25" fill="none" stroke="black" stroke-width="3" />
    <!--head-->
    <circle cx="0" cy="-110" r="30" stroke="black" stroke-width="3" fill="none" />
    <!--football-->
    <circle cx="50" cy="60" r="15" stroke="black" stroke-width="3" fill="red" />
    <!--tree-->
    <circle cx="200" cy="-130" r="40" stroke="black" stroke-width="2" fill="green" />
    <circle cx="160" cy="-165" r="40" stroke="black" stroke-width="2" fill="green" />
    <circle cx="240" cy="-165" r="40" stroke="black" stroke-width="2" fill="green" />
    <circle cx="200" cy="-205" r="40" stroke="black" stroke-width="2" fill="green" />
    <line x1="200" y1="-90" x2="200" y2="80" style="stroke:brown;stroke-width:10" />
    </g>
    </svg>
</body>
</html>
