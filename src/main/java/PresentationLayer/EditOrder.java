
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.FogException;
import FunctionLayer.OrderBuilderException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EditOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException, OrderBuilderException {

        int id = Integer.parseInt(request.getParameter("id"));
        int tlf = Integer.parseInt(request.getParameter("tlf"));
        String email = request.getParameter("email");
        int height = Integer.parseInt(request.getParameter("height"));
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int shedLength = Integer.parseInt(request.getParameter("shedLength"));
        int shedWidth = Integer.parseInt(request.getParameter("shedWidth"));
        int slopedRoof = Integer.parseInt(request.getParameter("slope"));
        

        LogicFacade.editOrder(id, tlf, email, height, length, width, shedLength, shedWidth, slopedRoof);
        
        return "ordereditedpage";
    }

}
