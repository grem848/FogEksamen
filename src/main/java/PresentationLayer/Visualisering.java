/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderBuilderException;
import FunctionLayer.VirtualCalculator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mohammahomarhariri
 */
public class Visualisering extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, OrderBuilderException {

        VirtualCalculator vc = new VirtualCalculator();
        
        String s = vc.sketch(500, 780);
        
        
        request.setAttribute("virtual", s);
        
                
        return "visualisering";
    }
    
}
