
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.FogException;
import FunctionLayer.Order;
import FunctionLayer.OrderBuilderException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EmployeeEditOrder extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException, OrderBuilderException {   
        
        int id = Integer.parseInt(request.getParameter("id"));

        request.setAttribute("order", LogicFacade.getOneOrder(id));

        return "employeeeditpage";
    }
    
}
