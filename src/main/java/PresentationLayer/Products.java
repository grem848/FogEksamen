package PresentationLayer;

import FunctionLayer.FogException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Products extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException
    {
        return "products";
    }

}
