package PresentationLayer;

import FunctionLayer.BOMCalculator;
import FunctionLayer.LogicFacade;
import FunctionLayer.FogException;
import FunctionLayer.OrderBuilderException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeEditOrder extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException, OrderBuilderException
    {

        int carportHeight = Integer.parseInt(request.getParameter("height"));
        int carportWidth = Integer.parseInt(request.getParameter("width"));
        int carportLength = Integer.parseInt(request.getParameter("length"));
        int shedWidth = Integer.parseInt(request.getParameter("shedWidth"));
        int shedLength = Integer.parseInt(request.getParameter("shedLength"));
        //skal ændres 
        int height = 280;
        

        BOMCalculator b = new BOMCalculator(carportLength / 100, carportWidth / 100, height / 100);
        int totalPrice = b.getTotalPrice();

        request.setAttribute("totalPrice", totalPrice);
        request.setAttribute("res", b.getResDemo());
        request.setAttribute("res2", b.getResDemo2());
        
        int id = Integer.parseInt(request.getParameter("id"));

        request.setAttribute("order", LogicFacade.getOneOrder(id));

        return "employeeeditpage";
    }

}
