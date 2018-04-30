
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderBuilderException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EditShedWidth extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, OrderBuilderException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        int shedWidth = Integer.parseInt(request.getParameter("shedWidth"));
        
        
        LogicFacade.changeShedWidth(id, shedWidth);
        
        return "editshedwidthpage";
    }
    
}