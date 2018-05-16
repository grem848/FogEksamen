package PresentationLayer;

import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
import FunctionLayer.OrderBuilderException;
import FunctionLayer.VirtualCalculator;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Visualization extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException, OrderBuilderException
    {

        VirtualCalculator vc = new VirtualCalculator();

        double carportWidth = Double.parseDouble(request.getParameter("carportWidth"));
        double carportLength = Double.parseDouble(request.getParameter("carportLength"));
        double carportHeight = Double.parseDouble(request.getParameter("carportHeight"));
        double shedWidth = Double.parseDouble(request.getParameter("shedWidth"));
        double shedLength = Double.parseDouble(request.getParameter("shedLength"));
        String s = vc.sketch(carportWidth, carportLength, shedWidth, shedLength);

        int tlf = Integer.parseInt(request.getParameter("tlf"));
        String email = request.getParameter("email");
        int slopedRoof = Integer.parseInt(request.getParameter("slopedRoof"));

        int widthDB = Integer.parseInt(request.getParameter("carportWidth"));
        int lengthDB = Integer.parseInt(request.getParameter("carportLength"));
        int heightDB = Integer.parseInt(request.getParameter("carportHeight"));
        int shedWidthDB = Integer.parseInt(request.getParameter("shedWidth"));
        int shedLengthDB = Integer.parseInt(request.getParameter("shedLength"));

        try
        {
            LogicFacade.createOrder(tlf, email, lengthDB, widthDB, heightDB, shedLengthDB, shedWidthDB, slopedRoof);
        } catch (SQLException ex)
        {
            throw new FogException(ex.getMessage());
        }

        request.setAttribute("carportHeight", carportHeight);
        
        request.setAttribute("virtual", s);

        return "sendrequestpage";
    }

}
