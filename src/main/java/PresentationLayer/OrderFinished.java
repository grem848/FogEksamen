package PresentationLayer;

import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
import FunctionLayer.OrderBuilderException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderFinished extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException, OrderBuilderException
    {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);

        LogicFacade.finishOrder(id);
        
        return "orderfinishedpage";
    }

}
