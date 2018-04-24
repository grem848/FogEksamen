package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderBuilderException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, OrderBuilderException
    {
        HttpSession session = request.getSession(false);
        if (session != null)
        {
            session.invalidate();
        }
        try
        {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (ServletException | IOException ex)
        {
            throw new LoginSampleException(ex.getMessage());
        }
        return null;
    }

}
