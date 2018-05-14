/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
import FunctionLayer.OrderBuilderException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author RasmusFriis
 */
public class RequestSentToDb extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException, OrderBuilderException 
    {
       
        int tlf = Integer.parseInt(request.getParameter("tlf"));
        String email = request.getParameter("email");
        int width = Integer.parseInt(request.getParameter("carportWidth"));
        int length = Integer.parseInt(request.getParameter("carportLength"));
        int height = Integer.parseInt(request.getParameter("carportheight"));
        int shedWidth = Integer.parseInt(request.getParameter("shedWidth"));
        int shedLength = Integer.parseInt(request.getParameter("shedLength"));
        
        int slopedRoof = Integer.parseInt(request.getParameter("slopedRoof"));
     
        
        
        try {
            LogicFacade.createOrder(tlf, email, length, width, height, shedLength, shedWidth, slopedRoof);
        } catch (SQLException ex) {
            Logger.getLogger(RequestSentToDb.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "requestodbpage";
    }
        
        
    }

   
    

