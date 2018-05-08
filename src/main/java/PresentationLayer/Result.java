/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.BOMCalculator;
import FunctionLayer.FogException;
import FunctionLayer.OrderBuilderException;
import FunctionLayer.Product;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mohammahomarhariri
 */
public class Result extends Command {

    public Result() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException, OrderBuilderException {
       
        
        BOMCalculator b = new BOMCalculator(4, 9);

        request.setAttribute("res", b.getRes());
        
        return "result";
    }
    
}
