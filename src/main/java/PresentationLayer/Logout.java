package PresentationLayer;

import FunctionLayer.FogException;
import FunctionLayer.OrderBuilderException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException, OrderBuilderException
    {
        HttpSession session = request.getSession(false);
        if (session != null)
        {
            session.invalidate();
        }
        return "index";
    }

}
