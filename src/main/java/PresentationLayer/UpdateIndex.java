package PresentationLayer;

import FunctionLayer.FogException;
import FunctionLayer.OrderBuilderException;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateIndex extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException, OrderBuilderException
    {

        int inputHeight = Integer.parseInt(request.getParameter("carportHeight"));
        int inputLength = Integer.parseInt(request.getParameter("carportLength"));
        int width = Integer.parseInt(request.getParameter("carportWidth"));
        int shedLength = Integer.parseInt(request.getParameter("shedLength"));
        int shedWidth = Integer.parseInt(request.getParameter("shedWidth"));
        boolean noShed = Boolean.parseBoolean(request.getParameter("noShed"));

        request.setAttribute("carportLength", inputLength);
        request.setAttribute("carportHeight", inputHeight);
        request.setAttribute("carportWidth", width);

        if (noShed == true)
        {
            request.setAttribute("shedLength", 0);
            request.setAttribute("shedWidth", 0);
            request.setAttribute("noShed", noShed);

        } else
        {
            request.setAttribute("noShed", noShed);
            request.setAttribute("shedLength", shedLength);
            request.setAttribute("shedWidth", shedWidth);
        }

        return "index";
    }

}
