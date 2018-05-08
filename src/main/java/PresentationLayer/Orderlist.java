package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.FogException;
import FunctionLayer.Order;
import FunctionLayer.OrderBuilderException;
import FunctionLayer.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Orderlist extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException, OrderBuilderException
    {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
//        List<Order> orders = LogicFacade.getUserOrders(user);
//        request.getSession().setAttribute("orders", orders);
//        request.setAttribute("orders", orders);

        return "orderlistpage";
    }

}
