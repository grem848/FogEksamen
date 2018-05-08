
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>
    </head>
    <body>
        <h1>Johannes Fog A/S</h1>
        <br>
        <br>
        <form action="Control" method="post">
            Carport Width
            <select name="Carport_width" title="Carport Width"><option selected="selected" value="">Pick a width</option>
                <option value="240 cm">240 cm</option>
                <option value="270 cm">270 cm</option>
                <option value="300 cm">300 cm</option>
                <option value="330 cm">330 cm</option>
                <option value="360 cm">360 cm</option>
                <option value="390 cm">390 cm</option>
                <option value="420 cm">420 cm</option>
                <option value="450 cm">450 cm</option>
                <option value="480 cm">480 cm</option>
                <option value="510 cm">510 cm</option>
                <option value="540 cm">540 cm</option>
                <option value="570 cm">570 cm</option>
                <option value="600 cm">600 cm</option>
                <option value="630 cm">630 cm</option>
                <option value="660 cm">660 cm</option>
                <option value="690 cm">690 cm</option>
                <option value="720 cm">720 cm</option>
                <option value="750 cm">750 cm</option>
            </select>
            <br>
            <br>
            Carport Length
            <select name="Carport_length" title="Carport Length"><option selected="selected" value="">Pick a length</option>
                <option value="240 cm">240 cm</option>
                <option value="270 cm">270 cm</option>
                <option value="300 cm">300 cm</option>
                <option value="330 cm">330 cm</option>
                <option value="360 cm">360 cm</option>
                <option value="390 cm">390 cm</option>
                <option value="420 cm">420 cm</option>
                <option value="450 cm">450 cm</option>
                <option value="480 cm">480 cm</option>
                <option value="510 cm">510 cm</option>
                <option value="540 cm">540 cm</option>
                <option value="570 cm">570 cm</option>
                <option value="600 cm">600 cm</option>
                <option value="630 cm">630 cm</option>
                <option value="660 cm">660 cm</option>
                <option value="690 cm">690 cm</option>
                <option value="720 cm">720 cm</option>
                <option value="750 cm">750 cm</option>
                <option value="780 cm">780 cm</option>
            </select>
            <br>
            <br>
            Carport Shed Width
            <select name="Shed_width" title="Shed Width"><option selected="selected" value="Don't want a shed">Don't want a shed</option>
                <option value="210 cm">210 cm</option>
                <option value="240 cm">240 cm</option>
                <option value="270 cm">270 cm</option>
                <option value="300 cm">300 cm</option>
                <option value="330 cm">330 cm</option>
                <option value="360 cm">360 cm</option>
                <option value="390 cm">390 cm</option>
                <option value="420 cm">420 cm</option>
                <option value="450 cm">450 cm</option>
                <option value="480 cm">480 cm</option>
                <option value="510 cm">510 cm</option>
                <option value="540 cm">540 cm</option>
                <option value="570 cm">570 cm</option>
                <option value="600 cm">600 cm</option>
                <option value="630 cm">630 cm</option>
                <option value="660 cm">660 cm</option>
                <option value="690 cm">690 cm</option>
                <option value="720 cm">720 cm</option>
            </select>
            <br>
            <br>
            Carport Shed Length
            <select name="Shed_length" title="Shed Length"><option selected="selected" value="Don't want a shed">Don't want a shed</option>
                <option value="150 cm">150 cm</option>
                <option value="180 cm">180 cm</option>
                <option value="210 cm">210 cm</option>
                <option value="240 cm">240 cm</option>
                <option value="270 cm">270 cm</option>
                <option value="300 cm">300 cm</option>
                <option value="330 cm">330 cm</option>
                <option value="360 cm">360 cm</option>
                <option value="390 cm">390 cm</option>
                <option value="420 cm">420 cm</option>
                <option value="450 cm">450 cm</option>
                <option value="480 cm">480 cm</option>
                <option value="510 cm">510 cm</option>
                <option value="540 cm">540 cm</option>
                <option value="570 cm">570 cm</option>
                <option value="600 cm">600 cm</option>
                <option value="630 cm">630 cm</option>
                <option value="660 cm">660 cm</option>
                <option value="690 cm">690 cm</option>
            </select>
            <br>
            <br>
            <p>Click below to verify and send a request to a Johannes Fog Expert!</p>
            <input type="hidden" name="command" value="customerrequest" />
            <input type="submit" value="Send request" />
        </form>

    </body>
</html>
