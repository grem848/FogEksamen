
package PresentationLayer;

import FunctionLayer.FogException;
import FunctionLayer.OrderBuilderException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EmployeeLogin extends Command
{



    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException, OrderBuilderException
    {
        return "employeelogin";
    }
    
}
