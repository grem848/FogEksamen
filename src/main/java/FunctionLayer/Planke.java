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
public class Planke {
    
    private int width;
    private int length;
    
    private Position location;

    public Planke(Position location,int width, int length) {
        this.width = width;
        this.length = length;
        this.location = location;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
    
}
