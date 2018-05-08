package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.FogException;
import FunctionLayer.OrderBuilderException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderConfirmed extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException, OrderBuilderException
    {
        int height = Integer.parseInt(request.getParameter("height"));
        int width = Integer.parseInt(request.getParameter("width"));
        int length = Integer.parseInt(request.getParameter("length"));
        int shedLength = Integer.parseInt(request.getParameter("shedLength"));
        int shedWidth = Integer.parseInt(request.getParameter("shedWidth"));
        int tlf = Integer.parseInt(request.getParameter("tlf"));
        String email = request.getParameter("email");
        int slopedRoof = Integer.parseInt(request.getParameter("slopedRoof"));

        try {
            LogicFacade.createOrder(tlf, email, length, width, height, shedLength, shedWidth, slopedRoof);
        } catch (SQLException ex) {
            Logger.getLogger(OrderConfirmed.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "orderconfirmed";
    }

}
