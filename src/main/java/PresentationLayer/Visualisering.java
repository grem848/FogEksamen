package PresentationLayer;

import FunctionLayer.FogException;
import FunctionLayer.OrderBuilderException;
import FunctionLayer.VirtualCalculator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Visualisering extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException, OrderBuilderException
    {

        VirtualCalculator vc = new VirtualCalculator();

        double carportWidth = Double.parseDouble(request.getParameter("carportWidth"));
        double carportLength = Double.parseDouble(request.getParameter("carportLength"));
        double shedWidth = Double.parseDouble(request.getParameter("shedWidth"));
        double shedLength = Double.parseDouble(request.getParameter("shedLength"));
        
        String s = vc.sketch(carportWidth, carportLength, shedWidth, shedLength);

        request.setAttribute("virtual", s);

        return "visualisering";
    }

}
