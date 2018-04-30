
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderBuilderException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EditLength extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, OrderBuilderException {

        int id = Integer.parseInt(request.getParameter("id"));
        int length = Integer.parseInt(request.getParameter("length"));
        
        LogicFacade.changeLength(id, length);

        return "editlengthpage";
    }
    
}
