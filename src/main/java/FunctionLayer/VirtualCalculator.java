package FunctionLayer;

public class VirtualCalculator
{

//    private double length;
//    private double width;
    private StringBuilder sb = new StringBuilder();

//    public VirtualCalculator(double length, double width) {
//        this.length = length;
//        this.width = width;
//    }
    private boolean isShed;
    
    private int postAmount = 0;
    private int rafterAmount = 2;
    
    /**
     *
     * @param width
     * @param length
     * @param shedWidth
     * @param shedLength
     * @return
     */
    public String sketch(double width, double length, double shedWidth, double shedLength)
    {

//        //beregnet gennem den orginale tegning. (( 7.80 - stolpersAfstandRatio ) * 7.80 )
//        double firstPostDistanceRatio = 0.1410;
//        //beregnet gennem den orginale tegning. (længde/(11.5*55)) 
//        double postDistanceRatio = 0.8096;

        isShed = false;

        sb.append(area(width, length));

        rafter(length, width);

        if ((shedWidth > 0) && (shedLength > 0))
        {
            shed(width, length, shedWidth, shedLength);
            isShed = true;
        } else
        {
            isShed = false;
        }

        post(length, width, shedLength);

        strap(width, length);

        band(width, length, shedLength);

        verticalArrow(length, width);

        horizontalArrow(length, width);

        return sb.toString();
    }

    //arealet
    private String area(double length, double width)
    {

        String res = "<SVG width='800' height='645' viewBox=\"0 0 1000 800\" >\n"
                + "            <rect x=\"0\" y=\"0\" height=" + length + " width=" + width + "\n"
                + "                  style=\"stroke:#000000; fill: white\"/>";

        return res;
    }

    //spær
    private String rafter(double length, double width)
    {

        double n = length / 55;

        double postDistance = 55;

        sb.append("\n<%-- Linjer for spær --%>\n\n");

        for (int i = 0; i < n; i++)
        {

            sb.append("<line x1=" + postDistance + "  y1=0  x2=" + postDistance + " y2=" + width + " style='stroke:#006600;' fill='black' />\n");

            postDistance += 55;
            rafterAmount++;
        }

        return sb.toString();
    }

    //stolper
    private String post(double length, double width, double shedLength)
    {

        double x = 55;
        if (isShed == false)
        {
            sb.append("\n<%-- Linjer for stolper --%>\n\n");

            //øverst
            for (int i = 0; i < 2; i++)
            {

                sb.append("<rect  x = " + (x) + " y = " + 35 + " height = " + 10 + " width = " + 10
                        + " style = stroke:#000000; />\n");

                x += ((length - 55) / 2);
                postAmount++;

            }
            sb.append("<rect  x = " + (length - 10) + " y = " + 35 + " height = " + 10 + " width = " + 10
                    + " style = stroke:#000000; />\n");
            postAmount++;
            sb.append("<rect  x = " + (length - 10) + " y = " + (width - 45) + " height = " + 10 + " width = " + 10
                    + " style = stroke:#000000; />\n");
            postAmount++;
            x = 55;
            //nederst
            for (int i = 0; i < 2; i++)
            {

                sb.append("<rect  x = " + (x) + " y = " + (width - 45) + " height = " + 10 + " width = " + 10
                        + " style = stroke:#000000; />\n");

                x += ((length - 55) / 2);

            }
        } else
        {
            for (int i = 0; i < 2; i++)
            {

                sb.append("<rect  x = " + (x) + " y = " + 35 + " height = " + 10 + " width = " + 10
                        + " style = stroke:#000000; />\n");

                x += (((length - 55) - shedLength) / 2);
                postAmount++;

            }
            x = 55;
            //nederst
            for (int i = 0; i < 2; i++)
            {

                sb.append("<rect  x = " + (x) + " y = " + (width - 45) + " height = " + 10 + " width = " + 10
                        + " style = stroke:#000000; />\n");

                x += (((length - 55) - shedLength) / 2);
                postAmount++;

            }

        }

        return sb.toString();

    }

    //rem
    private String strap(double width, double length)
    {

        int y = 35;

        sb.append("\n<%-- Linjer for remme --%>\n\n");

        for (int i = 0; i < 2; i++)
        {

            sb.append("<line x1 = 0  y1 = " + y + " x2 = " + length + " y2 = " + y + " style='stroke:#006600;' />\n");

            y = (int) width - 35;
        }

        return sb.toString();

    }

    //skur
    private String shed(double length, double width, double shedLength, double shedWidth)
    {

        //shedlength is shedwidth and vice versa
//        if (shedLength == length) {
//            shedLength = - 70;
//        }
        if (shedLength > (length - 55))
        {
            shedLength = length - 70;
        }

        sb.append("\n<%-- skur --%>\n\n");

        sb.append("<rect  x = " + (width - shedWidth) + " y = " + 35 + " height = " + shedLength + " width = " + shedWidth
                + " style=' fill: brown; fill-opacity:0.4;' />\n");

        shedPost(width, shedLength, shedWidth);

        return sb.toString();

    }

    //hulbånd
    private String band(double width, double length, double shedWidth)
    {

        double x = 55;
        double y = 35;

        double x2 = length - shedWidth;
        double y2 = width - 35;

        sb.append("\n<%-- Linjer for kryds --%>\n\n");

        for (int i = 0; i < 2; i++)
        {

            sb.append("<line stroke-dasharray=5,5 x1=" + x + " y1=" + y + " x2=" + x2 + " y2=" + y2 + " style=' stroke:black;' />\n");

            y = width - 35;
            y2 = 35;

        }

        return sb.toString();
    }

    private String shedPost(double width, double shedLength, double shedWidth)
    {

        double x = width - shedWidth;
        double y = 35;

        sb.append("\n<%-- stolper til skur --%>\n\n");

        //left side (downward)
        for (int i = 0; i < 3; i++)
        {

            sb.append("<rect  x = " + x + " y = " + y + " height = " + 10 + " width = " + 10
                    + " style = stroke:#000000; />\n");

            y += (shedLength / 2) - 5;
        }

        x = width - 10;
        y = 35;

        //right side (downward)
        for (int i = 0; i < 3; i++)
        {
            sb.append("<rect  x = " + x + " y = " + y + " height = " + 10 + " width = " + 10
                    + " style = stroke:#000000; />\n");
            y += (shedLength / 2) - 5;
        }

        return sb.toString();
    }

    private void verticalArrow(double length, double width)
    {

        sb.append("\n<%-- Pile vertical--%>\n\n");

        sb.append(" <marker id='beginArrow' markerWidth = " + 9 + " markerHeight = " + 9
                + " refX= " + 0 + " refY=" + 4 + " orient = auto><path d = 'M0,4 L8,0 L8,8 L0,4' style = fill: red; />"
                + " </marker> "
                + "<marker id='endArrow' markerWidth = " + 9 + " markerHeight = " + 9 + "refX = " + 15 + " refY = " + 4
                + " orient = auto>"
                + " <path d = 'M0,0 L8,4 L0,8 L0,0' style = fill: red; /> "
                + "</marker> "
                + "<line  x1 = " + 0 + "  y1 = " + (width + 25) + " x2 = " + length + "   y2 = " + (width + 25)
                + " style =stroke:#006600; marker-start:url(#beginArrow); marker-end:url(#endArrow);/>        <text x = " + (length / 2) + " y  = " + (width + 40) + "\n"
                + "    font\n"
                + "    -size  = \"40px\"\n"
                + "    text\n"
                + "    -anchor  = \"middle\" > Length : \n"
                + "    : " + length + " CM </text>\n");

    }

    private void horizontalArrow(double length, double width)
    {

        sb.append("\n<%-- Pile horizontal--%>\n\n");

        sb.append(" <marker id='beginArrow' markerWidth = " + 9 + " markerHeight = " + 9
                + " refX= " + 0 + " refY=" + 4 + " orient = auto><path d = 'M0,4 L8,0 L8,8 L0,4' style = fill: red; />"
                + " </marker> "
                + "<marker id='endArrow' markerWidth = " + 9 + " markerHeight = " + 9 + "refX = " + 15 + " refY = " + 4
                + " orient = auto>"
                + " <path d = 'M0,0 L8,4 L0,8 L0,0' style = fill: red; /> "
                + "</marker> "
                + "<line  x1 = " + (length + 25) + "  y1 = " + 0 + " x2 = " + (length + 25) + "   y2 = " + (width)
                + " style =stroke:#006600; marker-start:url(#beginArrow); marker-end:url(#endArrow);/>        <text x = " + (length + 40) + " y  = " + (width / 2) + "\n"
                + "    font\n"
                + "    -size  = \"40px\"\n"
                + "    text\n"
                + "    -anchor  = \"middle\" style='writing-mode: tb;' > Width : \n"
                + "    : " + width + " CM </text>\n");

    }

    /**
     *
     * @return
     */
    public StringBuilder getSb()
    {
        return sb;
    }

    /**
     *
     * @param sb
     */
    public void setSb(StringBuilder sb)
    {
        this.sb = sb;
    }

    /**
     *
     * @return
     */
    public int getPostAmount() {
        return postAmount;
    }

    /**
     *
     * @param postAmount
     */
    public void setPostAmount(int postAmount) {
        this.postAmount = postAmount;
    }

    /**
     *
     * @return
     */
    public int getRafterAmount() {
        return rafterAmount;
    }

    /**
     *
     * @param rafterAmount
     */
    public void setRafterAmount(int rafterAmount) {
        this.rafterAmount = rafterAmount;
    }
    
    

}
