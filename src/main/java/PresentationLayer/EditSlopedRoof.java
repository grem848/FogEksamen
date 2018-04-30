
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderBuilderException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EditSlopedRoof extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, OrderBuilderException {

        int id = Integer.parseInt(request.getParameter("id"));
        int slope = Integer.parseInt(request.getParameter("slope"));
        
        LogicFacade.changeSlopedRoof(id, slope);

        return "editslopedroofpage";
    }
    
}
