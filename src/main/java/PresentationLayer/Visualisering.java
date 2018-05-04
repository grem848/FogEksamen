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

        String s = vc.sketch(Double.parseDouble(request.getParameter("carportWidth")),
                Double.parseDouble(request.getParameter("carportLength")),
                Double.parseDouble(request.getParameter("shedWidth")),
                Double.parseDouble(request.getParameter("shedLength")));

        request.setAttribute("virtual", s);

        return "visualisering";
    }

}
