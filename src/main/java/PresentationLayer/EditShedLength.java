/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderBuilderException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mohammahomarhariri
 */
public class EditShedLength extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, OrderBuilderException {
        int id = Integer.parseInt(request.getParameter("id"));
        int shedLength = Integer.parseInt(request.getParameter("shedLength"));
        
        LogicFacade.changeShedLength(id, shedLength);

        return "editshedlengthpage";
    }
    
}
