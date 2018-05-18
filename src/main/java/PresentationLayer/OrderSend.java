package PresentationLayer;

import FunctionLayer.BOMCalculator;
import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
import FunctionLayer.OrderBuilderException;
import FunctionLayer.VirtualCalculator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderSend extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException, OrderBuilderException
    {

        int carportHeight = Integer.parseInt(request.getParameter("height"));
        int carportWidth = Integer.parseInt(request.getParameter("width"));
        int carportLength = Integer.parseInt(request.getParameter("length"));
        int shedWidth = Integer.parseInt(request.getParameter("shedWidth"));
        int shedLength = Integer.parseInt(request.getParameter("shedLength"));
        String email = request.getParameter("email");
        BOMCalculator b = new BOMCalculator(carportLength / 100, carportWidth / 100, carportHeight / 100, shedLength / 100, shedWidth / 100);
        int totalPrice = b.getTotalPrice();

        request.setAttribute("totalPrice", totalPrice);
        request.setAttribute("res", b.getResDemo());
        request.setAttribute("res2", b.getResDemo2());

        int id = Integer.parseInt(request.getParameter("id"));

        request.setAttribute("order", LogicFacade.getOneOrder(id));

        VirtualCalculator vc = new VirtualCalculator();

        double carportWidthDouble = Double.parseDouble(request.getParameter("width"));
        double carportLengthDouble = Double.parseDouble(request.getParameter("length"));
        double shedWidthDouble = Double.parseDouble(request.getParameter("shedWidth"));
        double shedLengthDouble = Double.parseDouble(request.getParameter("shedLength"));
        String s = vc.sketch(carportWidthDouble, carportLengthDouble, shedWidthDouble, shedLengthDouble);

        request.setAttribute("carportHeight", carportHeight);
        request.setAttribute("virtual", s);
        request.setAttribute("email", email);

        LogicFacade.finishOrder(id);

        return "sendorderpage";
    }

}
