package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.OrderBuilderException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Order extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws OrderBuilderException
    {
        User user = (User) request.getSession().getAttribute("user");
        int id = user.getId();
        
//        int length = ((int) request.getSession().getAttribute("lengthS"));
//        int width = ((int) request.getSession().getAttribute("widthS"));
//        int height = ((int) request.getSession().getAttribute("heightS"));

        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));

        
        boolean sent = false;
        

        LogicFacade.createOrder(id, length, width, height, sent);
//        OrderBOM orderBOM = LogicFacade.createOrder(id, length, width, height, sent);
      
//        request.setAttribute("orderBOM", orderBOM);
        
        return "ordercreatedpage";
    }

}
