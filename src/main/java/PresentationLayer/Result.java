/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.BOMCalculator;
import FunctionLayer.FogException;
import FunctionLayer.OrderBuilderException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mohammahomarhariri
 */
public class Result extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException, OrderBuilderException
    {
        
        int carportWidth = Integer.parseInt(request.getParameter("carportWidth"));
        int carportLength = Integer.parseInt(request.getParameter("carportLength"));
        int carportHeight = Integer.parseInt(request.getParameter("carportHeight"));
        int shedWidth = Integer.parseInt(request.getParameter("shedWidth"));
        int shedLength = Integer.parseInt(request.getParameter("shedLength"));
        
//        int height = 280;

        BOMCalculator b = new BOMCalculator(carportLength / 100, carportWidth / 100, carportHeight / 100, shedLength / 100, shedWidth / 100);

        request.setAttribute("res", b.getResDemo());
        request.setAttribute("res2", b.getResDemo2());

        return "result";
    }

}
