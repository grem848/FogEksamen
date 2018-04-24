/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.OrderBOM;
import FunctionLayer.OrderBuilderException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andreas Heick Laptop
 */
public class EmployeeOrderList extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws OrderBuilderException
    {

        List<OrderBOM> orders = LogicFacade.getOrderList();

        request.setAttribute("allOrders", orders);

        return "employeeOrderList";
    }

}
