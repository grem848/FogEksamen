
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
        <title>Customer home page</title>
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
            <input type="hidden" name="command" value="update" />
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
            <input type="hidden" name="carportHeight" value="<%=inputHeight%>">
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
            
            
            
            
            
        <br>
        <br>

        <svg width="1000" height="300" viewBox="0 0 1000 300">

        <!-- Created with Vector Paint - http://www.vectorpaint.yaks.com/ https://chrome.google.com/webstore/detail/hnbpdiengicdefcjecjbnjnoifekhgdo -->

        <rect id="backgroundrect" width="100%" height="100%" x="0" y="0" fill="#3887ff" stroke="#000000" style="" class="" fill-opacity="1" stroke-opacity="1"/>
        <g class="currentLayer" style="">

        <!-- Tree trunk -->
        <path fill="#9e6924" fill-opacity="1" stroke="#9e6924" stroke-opacity="1" stroke-width="10" stroke-dasharray="none"
              stroke-linejoin="round" stroke-linecap="butt"
              stroke-dashoffset="" fill-rule="nonzero" opacity="1" marker-start="" marker-mid="" marker-end="" 
              d="M930,299 L930,200 " id="svg_2" class=""/>
        <!-- Tree leaves -->
        <path fill="#04b804" fill-opacity="1" stroke="#000000" stroke-opacity="1" stroke-width="1" stroke-dasharray="none"
              stroke-linejoin="round" stroke-linecap="butt"
              stroke-dashoffset="" fill-rule="nonzero" opacity="1" marker-start="" marker-mid="" marker-end=""
              d="M930,178 C930,166 940,155 952,155 C965,155 975,166 975,178 C975,190 975,200 952,200 C940,200 930,190
              930,178 z" id="svg_36" class=""/>

        <path fill="#04b804" fill-opacity="1" stroke="#000000" stroke-opacity="1" stroke-width="1" stroke-dasharray="none"
              stroke-linejoin="round" stroke-linecap="butt" stroke-dashoffset="" fill-rule="nonzero" opacity="1"
              marker-start="" marker-mid="" marker-end="" 
              d="M890,178 C890,166 900,155 912,155 C925,155 935,166 935,178 C935,190 925,200 912,200 C900,200 890,190
              890,178 z" id="svg_40" class=""/>

        <path fill="#04b804" fill-opacity="1" stroke="#000000" stroke-opacity="1" stroke-width="1" stroke-dasharray="none"
              stroke-linejoin="round" stroke-linecap="butt" stroke-dashoffset="" fill-rule="nonzero" opacity="1" marker-start=""
              marker-mid="" marker-end="" 
              d="M910,158 C910,146 920,135 932,135 C945,135 955,146 955,158 C955,170 945,180 932,180 C920,180 910,170
              910,158 z" id="svg_39" class=""/>

        <path fill="#04b804" fill-opacity="1" stroke="#000000" stroke-opacity="1"
              stroke-width="1" stroke-dasharray="none" stroke-linejoin="round" stroke-linecap="butt" stroke-dashoffset="" 
              fill-rule="nonzero" opacity="1" marker-start="" marker-mid="" marker-end="" 
              d="M910,198 C910,186 920,175 932,175 C945,175 955,186 955,198 C955,210 945,220 932,220 C920,220 910,210
              910,198 z" id="svg_38" class=""/>

        <!-- Carport & Stickman & measurements -->
        <foreignObject fill="black" stroke="black"
                       stroke-linejoin="round" stroke-dashoffset="" fill-rule="nonzero" font-size="20" font-family="Georgia, serif" 
                       letter-spacing="0" word-spacing="0" marker-start="" marker-mid="" marker-end="" id="svg_4" x="103" 
                       y="232" width="133" height="120" style="color: rgb(255, 255, 255);" class="">
        <p style="border: none;outline: none;font-size: inherit;line-height: 1em;padding:0;margin:0;">
        <p style="border: none;outline: none;font-size: inherit;line-height: 1em;padding:0;margin:0;">

        </p>
        <p style="border: none;outline: none;font-size: inherit;line-height: 1em;padding:0;margin:0;">

        </p>
        <p style="border: none;outline: none;font-size: inherit;line-height: 1em;padding:0;margin:0;">
            <!-- Carport height text -->
            200 cm
        </p>
        <p style="border: none;outline: none;font-size: inherit;line-height: 1em;padding:0;margin:0;">

        </p>
        <p style="border: none;outline: none;font-size: inherit;line-height: 1em;padding:0;margin:0;">

        </p>

    </p>
    </foreignObject>

    <!-- Carport Poles -->
    <!-- MOVE MEEE -->
    <%--
    M650 (Pole location must be same as below) (Length of roof plus 30 (30cm)), 200 is height of roof (DO TOUCH)
    L650 (Pole location must be same as above) (Length of roof plus 30 (30cm)), 200 is height of roof (DO TOUCH)
    --%>
    <path fill="black" stroke="black" stroke-width="8" fill-rule="nonzero" opacity="1" marker-start=""
          marker-mid="" marker-end="" d="M<%=inputLength + 30%>,<%=inputHeight%> L<%=inputLength + 30%>,300 " 
          id="svg_6" class=""/>
    <!-- Dont touch me I am the pole that doesnt move! -->
    <path fill="black" stroke="black" stroke-width="8" fill-rule="nonzero" opacity="1" marker-start=""
          marker-mid="" marker-end="" d="M800,<%=inputHeight%> L800,300 " 
          id="svg_6" class=""/>

    <!-- Carport Roof -->
    <%--
    800 is roof start, roof length = (800 - 620) * 2 = 360 = 3.6m
    M620 (Roof length), 200 is height of roof (DO TOUCH)!
    L810 (DONT TOUCH), 200 is height of roof (DO TOUCH)!
    --%>
    <path fill="black" stroke="black" stroke-width="8" fill-rule="nonzero" opacity="1" marker-start=""
          marker-mid="" marker-end="" d="M<%=inputLength%>,<%=inputHeight%> L810,<%=inputHeight%> "
          id="svg_6" class=""/>



    <!-- Carport height -->
    <path fill="white" fill-opacity="1" stroke="white" stroke-opacity="1" stroke-width="2" stroke-dasharray="none" 
          stroke-linejoin="round" stroke-linecap="butt" stroke-dashoffset="" fill-rule="nonzero" opacity="1" marker-start=""
          marker-mid="" marker-end="" d="M839, 300 L839, <%=inputHeight%>"
          id="svg_6" class=""/>
    <text x='845' y='200' fill='white'>Actual Height</text>
    <text x='845' y='220' fill='white'><%=actualHeight%> cm</text>
    <text x='845' y='260' fill='white'>Total Height</text>
    <text x='845' y='280' fill='white'><%=totalHeight%> cm</text>

    <text x='<%=inputLength%>' y='160' fill='white'>Total Length: <%=outputLength%> cm</text>


    <!-- Stickman height -->
    <path fill="white" stroke="white"stroke-width="2" d="M97,300 L97,200 " id="svg_11"
          class=""/>
    <!-- Stickman -->
    <path fill="black" stroke="black" stroke-width="2" stroke-linejoin="round" stroke-dashoffset="" fill-rule="nonzero"
          marker-start="" marker-mid="" marker-end="" id="svg_13" d="M5,235 L87,235 
          M46,260 L60,300 M46,260 L30,300 M46,220 L46,260 M59,210 C59,217 53,222 46,222 C39,222 33,217 33,210 C33,203 39,197 46,197
          C53,197 59,203 59,210 z" style="color: rgb(0, 0, 0);" class=""/>
    </g>
    </svg>
    <br>
    <br>
    <form name="Building" action="FrontController" method="POST">
        <input type="hidden" name="command" value="employeelogin" />
        <input type="submit" value="Employee Login" />
    </form>
    <br>
    <p>Johannes Fog A/S</p>

</body>
</html>
