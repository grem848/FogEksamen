
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderBuilderException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EditWidth extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, OrderBuilderException {
       
        int id = Integer.parseInt(request.getParameter("id"));
        int width = Integer.parseInt(request.getParameter("width"));
        
        LogicFacade.changeWidth(id, width);

        return "editwidthpage";
    }
    
}
