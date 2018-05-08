
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.FogException;
import FunctionLayer.OrderBuilderException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class OrderRemoved extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException, OrderBuilderException {

        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
        
        LogicFacade.removeOrder(id);
        
        return "orderremovedpage";
    }
    
}
