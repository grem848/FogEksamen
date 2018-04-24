package PresentationLayer;

import FunctionLayer.LoginSampleException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BOM extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException
    {
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));
        
//        request.getSession().setAttribute("lengthS", length);
//        request.getSession().setAttribute("widthS", width);
//        request.getSession().setAttribute("heightS", height);

        int totalDots = ((length * 2) + (width * 2)) * height * 2;

        int lengthSmallBrick = (length % 2);
        int lengthMediumBrick = (length % 4) / 2;
        int lengthLargeBrick = (length / 4);

        width = width - 4;
        int widthSmallBrick = (width % 2);
        int widthMediumBrick = (width % 4) / 2;
        int widthLargeBrick = width / 4;

        int totalSmallBricks = (((lengthSmallBrick * 2) + (widthSmallBrick * 2)) * height);
        int totalMediumBricks = (((lengthMediumBrick * 2) + (widthMediumBrick * 2)) * height);
        int totalLargeBricks = (((lengthLargeBrick * 2) + (widthLargeBrick * 2)) * height);
        
        int sideLengthTotal = lengthSmallBrick + widthMediumBrick + lengthLargeBrick;
        int sideWidthTotal = widthSmallBrick + widthMediumBrick + widthLargeBrick;

        List<Integer> bList = new ArrayList<>();
        bList.add(lengthSmallBrick);
        bList.add(lengthMediumBrick);
        bList.add(lengthLargeBrick);
        bList.add(widthSmallBrick);
        bList.add(widthMediumBrick);
        bList.add(widthLargeBrick);

        int brickCounter = 0;

        for (int b : bList)
        {
            brickCounter += b * height * 2;
        }

        request.setAttribute("totalDots", totalDots);
        request.setAttribute("totalBricks", brickCounter);
        request.setAttribute("totalSmallBricks", totalSmallBricks);
        request.setAttribute("totalMediumBricks", totalMediumBricks);
        request.setAttribute("totalLargeBricks", totalLargeBricks);
        
        request.setAttribute("smallTotalLength", lengthSmallBrick);
        request.setAttribute("mediumTotalLength", lengthMediumBrick);
        request.setAttribute("largeTotalLength", lengthLargeBrick);
        
        request.setAttribute("smallTotalWidth", widthSmallBrick);
        request.setAttribute("mediumTotalWidth", widthMediumBrick);
        request.setAttribute("largeTotalWidth", widthLargeBrick);
        
        request.setAttribute("sideLengthTotal", sideLengthTotal);
        request.setAttribute("sideWidthTotal", sideWidthTotal);
        

        

        return "bompage";
    }
}
