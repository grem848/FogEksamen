package PresentationLayer;

import FunctionLayer.FogException;
import FunctionLayer.OrderBuilderException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Forwarder extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException, OrderBuilderException
    {
        
       
        User user =  (User) request.getSession().getAttribute("user");
        HttpSession session = request.getSession();
        session.setAttribute( "role", user.getRole() );
        return user.getRole() + "page";
    }

}
