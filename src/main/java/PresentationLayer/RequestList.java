
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.Order;
import FunctionLayer.OrderBuilderException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RequestList extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws OrderBuilderException
    {

        List<Order> orders = LogicFacade.getRequestList();

        request.setAttribute("allOrders", orders);

        return "employeerequestpage";
    }

}
