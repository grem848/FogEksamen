
package PresentationLayer;

import FunctionLayer.FogException;
import FunctionLayer.OrderBuilderException;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdateIndex extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException, OrderBuilderException
    {

        try
        {
            int inputHeight = Integer.parseInt(request.getParameter("carportHeight"));
//        int inputwidth = Integer.parseInt(request.getParameter("carportWidth"));
            int inputLength = Integer.parseInt(request.getParameter("carportLength"));

            request.setAttribute("carportLength", inputLength);
            request.setAttribute("carportHeight", inputHeight);
            request.getRequestDispatcher("index.jsp").forward(request, response);
            

        } catch (ServletException | IOException ex)
        {
            System.out.println(ex);
        }
        return null;
    }

}
