
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>


    <style>
        *{padding: 0; margin: 0; box-sizing: border-box;}
        body{height: 900px;}
        header {
            background-color: darkblue;
            text-align: center;
            width: 100%;
            height: auto;
            background-size: cover;
            background-attachment: fixed;
            position: relative;
            overflow: hidden;
            border-radius: 0 0 85% 85% / 30%;
            display: inline-block;
        }
        header .overlay{
            width: 100%;
            height: 100%;
            padding: 50px;
            color: #FFF;
            text-shadow: 1px 1px 1px #333;
            background-image: linear-gradient( 135deg, #9f05ff69 10%, #fd5e086b 100%);
        }

        h1 {
            font-family: 'Dancing Script', cursive;
            font-size: 80px;
            margin-bottom: 30px;
        }

        h3{
            font-family: 'Open Sans', sans-serif;
            margin-bottom: 30px;
            }
      
    </style>

    <body> 
        <header>
            <div class="overlay">
                <h1>Johannes Fog A/S</h1>
                <img src="https://prisbyg.libpx.com/eu-west-1/images/merchant/johannesfog.jpg" alt="Logo" width="400" height="90"/>
                <h3>Simply The Best Carport</h3>
                <br>

            </div>
        </header>

    </body>
</html>
