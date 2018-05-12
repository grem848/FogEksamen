
package PresentationLayer;

import FunctionLayer.BOMCalculator;
import FunctionLayer.FogException;
import FunctionLayer.OrderBuilderException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class OrderSend extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException, OrderBuilderException
    {
        
        int carportHeight = Integer.parseInt(request.getParameter("carportHeight"));
        int carportWidth = Integer.parseInt(request.getParameter("carportWidth"));
        int carportLength = Integer.parseInt(request.getParameter("carportLength"));
        int shedWidth = Integer.parseInt(request.getParameter("shedWidth"));
        int shedLength = Integer.parseInt(request.getParameter("shedLength"));

        BOMCalculator b = new BOMCalculator(carportLength / 100, carportWidth / 100);

        request.setAttribute("res", b.getRes());

        return "sendorderpage";
    }

}
