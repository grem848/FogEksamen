/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author mohammahomarhariri
 */
public class VirtualCalculator {

//    private double length;
//    private double width;
    private StringBuilder sb = new StringBuilder();

//    public VirtualCalculator(double length, double width) {
//        this.length = length;
//        this.width = width;
//    }
    public String sketch(double length, double width) {

        //beregnet gennem den orginale tegning. (( 7.80 - stolpersAfstandRatio ) * 7.80 )
        double førsteStolpeAfstadRatio = 0.1410;
        //beregnet gennem den orginale tegning. (længde/(11.5*55)) 
        double stolpersAfstandRatio = 0.8096;

        sb.append(arealet(length, width));

        rafter(length, width);
        
        post(width, stolpersAfstandRatio, length);

        return sb.toString();
    }

    //
    public String arealet(double length, double width) {

        String res = "<SVG width=" + (width + 200) + " height=" + (length + 200) + " viewBox=\"0 0 1200 1200\" >\n"
                + "            <rect x=\"0\" y=\"0\" height=" + length + " width=" + width + "\n"
                + "                  style=\"stroke:#000000; fill: white\"/>";

        return res;
    }

    //spær
    public String rafter(double length, double width) {

        double n = width / 55;

        double stolpeafstand = 0;

        for (int i = 0; i < n; i++) {

            sb.append("<line x1=" + stolpeafstand + "  y1=0  x2=" + stolpeafstand + " y2=" + length + " style='stroke:#006600;' fill='black' />");

            stolpeafstand += 55;
        }

        return sb.toString();
    }

    public String post(double width, double stolpeafstand, double length) {
        int antal = 0;

        if (width * stolpeafstand > 4) {
            antal =+ 3;
        } else {
            antal =+ 2;
        }
        
        int x = 110; 

        //øverst
        for (int i = 0; i < antal; i++) {

            sb.append("<rect  x = " + x + " y = " + 35 + " height = " + 10 + " width = " + 10 +
            " style = stroke:#000000; />");
           
           
           x += ((width / antal));
           
        }
        
        x = 110;
        //nederst
        for (int i = 0; i < antal; i++) {
            
            sb.append("<rect  x = " + x + " y = " + (length - 35) + " height = " + 10 + " width = " + 10 +
            " style = stroke:#000000; />");
        
           x += ((width / antal));
            
        }
        
        return sb.toString();

    }
    

    public StringBuilder getSb() {
        return sb;
    }

    public void setSb(StringBuilder sb) {
        this.sb = sb;
    }

}
