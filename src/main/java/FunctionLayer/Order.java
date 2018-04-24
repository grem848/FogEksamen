package FunctionLayer;

public class Order
{

    private int id;
    private int tlf;
    private String email;
    private int length;
    private int height;
    private int width;
    private int shedLength;
    private int shedWidth;
    private int slopedRoof;

    public Order(int id, int tlf, String email, int length, int height, int width, int shedLength, int shedWidth, int slopedRoof) // get order?
    {
        this.id = id;
        this.tlf = tlf;
        this.email = email;
        this.length = length;
        this.height = height;
        this.width = width;
        this.shedLength = shedLength;
        this.shedWidth = shedWidth;
        this.slopedRoof = slopedRoof;
    }

    public Order(int tlf, String email, int length, int height, int width, int shedLength, int shedWidth, int slopedRoof) // create order
    {
        this.tlf = tlf;
        this.email = email;
        this.length = length;
        this.height = height;
        this.width = width;
        this.shedLength = shedLength;
        this.shedWidth = shedWidth;
        this.slopedRoof = slopedRoof;
    }
    

//    public Order(int id, int length, int height, int width, int shedLength, int shedWidth, int slopedRoof) 
//    {
//        this.id = id;
//        this.length = length;
//        this.height = height;
//        this.width = width;
//        this.shedLength = shedLength;
//        this.shedWidth = shedWidth;
//        this.slopedRoof = slopedRoof;
//    }

    public Order(int length, int height, int width, int shedLength, int shedWidth, int slopedRoof)
    {
        this.length = length;
        this.height = height;
        this.width = width;
        this.shedLength = shedLength;
        this.shedWidth = shedWidth;
        this.slopedRoof = slopedRoof;
    }
    
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
   
    public int getLength()
    {
        return length;
    }

    public void setLength(int length)
    {
        this.length = length;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public int getTlf()
    {
        return tlf;
    }

    public void setTlf(int tlf)
    {
        this.tlf = tlf;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public int getShedLength()
    {
        return shedLength;
    }

    public void setShedLength(int shedLength)
    {
        this.shedLength = shedLength;
    }

    public int getShedWidth()
    {
        return shedWidth;
    }

    public void setShedWidth(int shedWidth)
    {
        this.shedWidth = shedWidth;
    }

    public int getSlopedRoof()
    {
        return slopedRoof;
    }

    public void setSlopedRoof(int slopedRoof)
    {
        this.slopedRoof = slopedRoof;
    }

    
    
    @Override
    public String toString()
    {
        String status;
        status = "Pending"; // DELETE THIS PLS
//        if(sent == true)
//        {
//            status = "Sent";
//        }
//        else
//        {
//            status = "Pending";
//        }
        return "[ Order ID: " + id + " | Bill of Materials: Length:" + length + ", Width: " + width + ", Height: " + height + " | Status: " + status + " ]";
    }

    
}
