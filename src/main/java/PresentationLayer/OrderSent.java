
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.FogException;
import FunctionLayer.OrderBuilderException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class OrderSent extends Command
{

   @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException, OrderBuilderException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        LogicFacade.deliverOrder(id);
        
        return "ordersentpage";
    }
    
}
