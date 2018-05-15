        
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    // get this from a request attribute
    int inputLength = (request.getAttribute("carportLength") == null ? 690 : (int) request.getAttribute("carportLength")); // length from input
    int outputLength = 240; // length from right pole to length of roof, shown to customer
    int inputHeight = (request.getAttribute("carportHeight") == null ? 195 : (int) request.getAttribute("carportHeight")); // height from input
    int actualHeight = 210; // height from bottom to bottom of roof, shown to customer
    int totalHeight = 225; // height from bottom to top of roof, shown to customer
    int width = (request.getAttribute("carportWidth") == null ? 240 : (int) request.getAttribute("carportWidth"));
    int shedWidth = (request.getAttribute("shedWidth") == null ? 0 : (int) request.getAttribute("shedWidth"));
    int shedLength = (request.getAttribute("shedLength") == null ? 0 : (int) request.getAttribute("shedLength"));
    boolean noShed = (request.getAttribute("noShed") == null ? false : (boolean) request.getAttribute("noShed"));

    switch (inputHeight) {
        /*
        200 height of SVG path = 200cm
        195 height of SVG path = 210cm
        ---------
        200 SVG Height = 2m
        150 SVG Height = 3m
        100 SVG Height = 4m
        ---------
        500 SVG Height = 10m
        50 SVG Height = 1m
        5 SVG Height = 10cm
        ---------
        Increased SVG height shrinks the actual height
         */
        case 195:
            actualHeight = 210;
            totalHeight = actualHeight + 15;
            break;
        case 192:
            actualHeight = 215;
            totalHeight = actualHeight + 15;
            break;
        case 190:
            actualHeight = 220;
            totalHeight = actualHeight + 15;
            break;
        case 187:
            actualHeight = 225;
            totalHeight = actualHeight + 15;
            break;
        case 185:
            actualHeight = 230;
            totalHeight = actualHeight + 15;
            break;
        case 182:
            actualHeight = 235;
            totalHeight = actualHeight + 15;
            break;
        case 180:
            actualHeight = 240;
            totalHeight = actualHeight + 15;
            break;
    }
    switch (inputLength) {

        case 690:
            outputLength = 240;
            break;
        case 675:
            outputLength = 270;
            break;
        case 660:
            outputLength = 300;
            break;
        case 645:
            outputLength = 330;
            break;
        case 630:
            outputLength = 360;
            break;
        case 615:
            outputLength = 390;
            break;
        case 600:
            outputLength = 420;
            break;
        case 585:
            outputLength = 450;
            break;
        case 570:
            outputLength = 480;
            break;
        case 555:
            outputLength = 510;
            break;
        case 540:
            outputLength = 540;
            break;
        case 525:
            outputLength = 570;
            break;
        case 510:
            outputLength = 600;
            break;
        case 495:
            outputLength = 630;
            break;
        case 480:
            outputLength = 660;
            break;
        case 465:
            outputLength = 690;
            break;
        case 450:
            outputLength = 720;
            break;
        case 435:
            outputLength = 750;
            break;
        case 420:
            outputLength = 780;
            break;
    }
%>
<html>
    <head>
        <style>
            table, th, td {
                border: 1px solid black;
            }

        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Create page</title>
    </head>
    <body>
        <h1>Johannes Fog A/S</h1>
        <br>
        <br>
        <form name="Request" action="FrontController" method="POST">
            Carport Width
            <select name="carportWidth" title="Carport Width">
                <option selected="selected" value="<%=width%>">Pick a width</option>
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
                <option selected="selected" value="<%=inputLength%>">Pick a length</option>
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
                <option selected="selected" value="<%=inputHeight%>">Pick a height</option>
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
            <input type="checkbox" name="noShed" value="true"
                   <%
                       if (noShed == true) {
                           out.println("checked");
                       } else {

                           out.println("<input type='hidden' name='noShed' value='false'");
                       }
                   %>
                   />
            I don't want a shed, uncheck to see shed options again
            <% if (noShed == false) {%>
            <br>
            <br>
            Carport Shed Width
            <select name="shedWidth" title="Shed Width">
                <option selected="selected" value="<%=shedWidth%>">Pick a shed width</option>
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
                <option selected="selected" value="<%=shedLength%>">Pick a shed length</option>
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
            <br>
            <% }%>
            Your Current Carport!
            <br>
            <table>
                <tr>
                    <th>Dimension</th>
                    <th>Measurement</th>
                </tr>
                <tr>
                    <td>Carport Width</td>
                    <td><%=width%> cm</td>
                </tr>
                <tr>
                    <td>Carport Length</td>
                    <td><%=outputLength%> cm</td>
                </tr>
                <tr>
                    <td>Carport Actual Height</td>
                    <td><%=actualHeight%> cm</td>
                </tr>
                <tr>
                    <td>Carport Total Height</td>
                    <td><%=totalHeight%> cm</td>
                </tr>
                <tr>
                    <td>Current Shed Width</td>
                    <td><%=shedWidth%> cm</td>
                </tr>
                <tr>
                    <td>Current Shed Length</td>
                    <td><%=shedLength%> cm</td>
                </tr>
            </table>
            <br>
            <input type="hidden" name="command" value="updateemployeecreateorder" />
            <input type="hidden" name="shedWidth" value="<%=shedWidth%>" />
            <input type="hidden" name="shedLength" value="<%=shedLength%>" />
            <input type="submit" value="Update Carport & Visualization" />
        </form>

        <br>
            
        <form name="Building" action="FrontController" method="POST">
            <input type="hidden" name="command" value="sendrequestpage">
            <input type="hidden" name="carportWidth" value="<%=width%>">
            <input type="hidden" name="carportHeight" value="<%=actualHeight%>">
            <input type="hidden" name="carportLength" value="<%=outputLength%>">
            <input type="hidden" name="shedWidth" value="<%=shedWidth%>">
            <input type="hidden" name="shedLength" value="<%=shedLength%>">
            Do this last!
            <p>Tlf</p>
            <input type="number"name="tlf" placeholder="12345678" required>
            <p>Email:</p>
            <input type="text" name="email" placeholder="email@email.dk" required>
            <p>slopedRoof</p>
            <input type="number" name="slopedRoof" placeholder="84" required>
            <input type="submit" value="Send Request">
        </form>
        </form>
        
        
        
        
    <body/>
</html>

