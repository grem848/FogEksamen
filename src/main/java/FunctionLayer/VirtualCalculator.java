
package FunctionLayer;


public class VirtualCalculator {

//    private double length;
//    private double width;
    private StringBuilder sb = new StringBuilder();

//    public VirtualCalculator(double length, double width) {
//        this.length = length;
//        this.width = width;
//    }
    private boolean isShed;

    public String sketch(double width, double length, double shedWidth, double shedLength) {

        //beregnet gennem den orginale tegning. (( 7.80 - stolpersAfstandRatio ) * 7.80 )
        double førsteStolpeAfstadRatio = 0.1410;
        //beregnet gennem den orginale tegning. (længde/(11.5*55)) 
        double stolpersAfstandRatio = 0.8096;

        isShed = false;

        sb.append(arealet(width, length));

        rafter(length, width, stolpersAfstandRatio, førsteStolpeAfstadRatio);

        if ((shedWidth > 0) && (shedLength > 0)) {
            shed(width, length, shedWidth, shedLength);
            isShed = true;
        } else {
            isShed = false;
        }

        post(length, width , stolpersAfstandRatio, førsteStolpeAfstadRatio);

        strap(width, length);

        band(width, length, shedLength , førsteStolpeAfstadRatio);

        verticalArrow(length, width);

        horizontalArrow(length, width);

        return sb.toString();
    }

    //arealet
    private String arealet(double length, double width) {

        String res = "<SVG width=" + (width + 200) + " height=" + (length + 200) + " viewBox=\"0 0 1200 1200\" >\n"
                + "            <rect x=\"0\" y=\"0\" height=" + length + " width=" + width + "\n"
                + "                  style=\"stroke:#000000; fill: white\"/>";

        return res;
    }

    //spær
    private String rafter(double length, double width, double stolpeAfstandRatio, double førsteStolpeAfstandRatio) {

        double n = length / 55 ;

        double stolpeafstand = 55;

        sb.append("\n<%-- Linjer for spær --%>\n\n");

        for (int i = 0; i < n; i++) {

            sb.append("<line x1=" + stolpeafstand + "  y1=0  x2=" + stolpeafstand + " y2=" + width + " style='stroke:#006600;' fill='black' />\n");

            stolpeafstand += 55;
        }

        return sb.toString();
    }

    //stolper
    private String post(double length, double width, double stolpeafstand, double førsteStolpeAfstandRatio) {
        int antal = 0;

        if (isShed == false) {
            antal = 3;
        } else {
            antal = 2;
        }

        double x = 55 * 2;

        sb.append("\n<%-- Linjer for stolper --%>\n\n");

        //øverst
        for (int i = 0; i < antal; i++) {

            sb.append("<rect  x = " + x + " y = " + 35 + " height = " + 10 + " width = " + 10
                    + " style = stroke:#000000; />\n");

            x += (length - 110) / 2;

        }

        x = 55 * 2;
        //nederst
        for (int i = 0; i < 3; i++) {

            sb.append("<rect  x = " + x + " y = " + (width - 45) + " height = " + 10 + " width = " + 10
                    + " style = stroke:#000000; />\n");

            x += ((length - (length * førsteStolpeAfstandRatio)) / 2) - 5;

        }
        
        sb.append("<rect  x = " + (width - 10) + " y = " + 35 + " height = " + 10 + " width = " + 10
                    + " style = stroke:#000000; />\n");
        sb.append("<rect  x = " + x + " y = " + (width - 45) + " height = " + 10 + " width = " + 10
                    + " style = stroke:#000000; />\n");

        return sb.toString();

    }

    //rem
    private String strap(double width, double length) {

        int y = 35;

        sb.append("\n<%-- Linjer for remme --%>\n\n");

        for (int i = 0; i < 2; i++) {

            sb.append("<line x1 = 0  y1 = " + y + " x2 = " + length + " y2 = " + y + " style='stroke:#006600;' />\n");

            y = (int) width - 35;
        }

        return sb.toString();

    }

    //skur
    private String shed(double length, double width, double shedLength, double shedWidth) {

        if (shedLength == length) {
            shedLength = - 70;
        }
        if (shedLength > length) {
            shedLength = length - 70;
        }

        sb.append("\n<%-- skur --%>\n\n");

        sb.append("<rect  x = " + (width - shedWidth) + " y = " + 35 + " height = " + shedLength + " width = " + shedWidth
                + " style=' fill: brown; fill-opacity:0.4;' />\n");

        shedPost(length, width, shedLength, shedWidth);

        return sb.toString();

    }

    //hulbånd
    private String band(double width, double length, double shedWidth, double førsteStolpeAfstandRatio) {

        double x = 55 * 2;
        double y = 35;

        double x2 = length - shedWidth;
        double y2 = width - 35;

        sb.append("\n<%-- Linjer for kryds --%>\n\n");

        for (int i = 0; i < 2; i++) {

            sb.append("<line stroke-dasharray=5,5 x1=" + x + " y1=" + y + " x2=" + x2 + " y2=" + y2 + " style=' stroke:black;' />\n");

            y = width - 35;
            y2 = 35;

        }

        return sb.toString();
    }

    private String shedPost(double length, double width, double shedLength, double shedWidth) {

        double x = width - shedWidth;
        double y = 35;

        sb.append("\n<%-- stolper til skur --%>\n\n");

        //left side (downward)
        for (int i = 0; i < 3; i++) {

            sb.append("<rect  x = " + x + " y = " + y + " height = " + 10 + " width = " + 10
                    + " style = stroke:#000000; />\n");

            y += (shedLength / 2) - 5;
        }

        x = width - 10;
        y = 35;

        //right side (downward)
        if (shedLength <= 300) {
            for (int i = 0; i < 2; i++) {
                sb.append("<rect  x = " + x + " y = " + y + " height = " + 10 + " width = " + 10
                        + " style = stroke:#000000; />\n");
                y += shedLength-10;
            }
        } else {
            for (int i = 0; i < 3; i++) {
                sb.append("<rect  x = " + x + " y = " + y + " height = " + 10 + " width = " + 10
                        + " style = stroke:#000000; />\n");
                y += (shedLength / 2) - 5;
            }
        }

        return sb.toString();
    }

    private void verticalArrow(double length, double width) {

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

    private void horizontalArrow(double length, double width) {

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

    public StringBuilder getSb() {
        return sb;
    }

    public void setSb(StringBuilder sb) {
        this.sb = sb;
    }

}
