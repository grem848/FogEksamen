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
    private int price;
    private String Status;

    /**
     *
     * @param id
     * @param tlf
     * @param email
     * @param length
     * @param height
     * @param width
     * @param shedLength
     * @param shedWidth
     * @param slopedRoof
     * @param Status
     */
    public Order(int id, int tlf, String email, int length, int height, int width, int shedLength, int shedWidth, int slopedRoof, String Status)
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
        this.Status = Status;
    }

    /**
     *
     * @param id
     * @param tlf
     * @param email
     * @param length
     * @param height
     * @param width
     * @param shedLength
     * @param shedWidth
     * @param slopedRoof
     * @param price
     * @param Status
     */
    public Order(int id, int tlf, String email, int length, int height, int width, int shedLength, int shedWidth, int slopedRoof, int price, String Status)
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
        this.price = price;
        this.Status = Status;
    }

    /**
     *
     * @param id
     * @param tlf
     * @param email
     * @param length
     * @param height
     * @param width
     * @param shedLength
     * @param shedWidth
     * @param slopedRoof
     */
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

    /**
     *
     * @param tlf
     * @param email
     * @param length
     * @param height
     * @param width
     * @param shedLength
     * @param shedWidth
     * @param slopedRoof
     */
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

    /**
     *
     * @param length
     * @param height
     * @param width
     * @param shedLength
     * @param shedWidth
     * @param slopedRoof
     */

    public Order(int length, int height, int width, int shedLength, int shedWidth, int slopedRoof)
    {
        this.length = length;
        this.height = height;
        this.width = width;
        this.shedLength = shedLength;
        this.shedWidth = shedWidth;
        this.slopedRoof = slopedRoof;
    }

    /**
     *
     * @return
     */
    public int getPrice()
    {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(int price)
    {
        this.price = price;
    }

    /**
     *
     * @return
     */
    public String getStatus() {
        return Status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(String status) {
        this.Status = status;
    }
    
    /**
     *
     * @return
     */
    public int getId()
    {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id)
    {
        this.id = id;
    }
   
    /**
     *
     * @return
     */
    public int getLength()
    {
        return length;
    }

    /**
     *
     * @param length
     */
    public void setLength(int length)
    {
        this.length = length;
    }

    /**
     *
     * @return
     */
    public int getWidth()
    {
        return width;
    }

    /**
     *
     * @param width
     */
    public void setWidth(int width)
    {
        this.width = width;
    }

    /**
     *
     * @return
     */
    public int getHeight()
    {
        return height;
    }

    /**
     *
     * @param height
     */
    public void setHeight(int height)
    {
        this.height = height;
    }

    /**
     *
     * @return
     */
    public int getTlf()
    {
        return tlf;
    }

    /**
     *
     * @param tlf
     */
    public void setTlf(int tlf)
    {
        this.tlf = tlf;
    }

    /**
     *
     * @return
     */
    public String getEmail()
    {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public int getShedLength()
    {
        return shedLength;
    }

    /**
     *
     * @param shedLength
     */
    public void setShedLength(int shedLength)
    {
        this.shedLength = shedLength;
    }

    /**
     *
     * @return
     */
    public int getShedWidth()
    {
        return shedWidth;
    }

    /**
     *
     * @param shedWidth
     */
    public void setShedWidth(int shedWidth)
    {
        this.shedWidth = shedWidth;
    }

    /**
     *
     * @return
     */
    public int getSlopedRoof()
    {
        return slopedRoof;
    }

    /**
     *
     * @param slopedRoof
     */
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
//            Status = "Sent";
//        }
//        else
//        {
//            Status = "Pending";
//        }
        return "[ Order ID: " + id + " | Bill of Materials: Length:" + length + ", Width: " + width + ", Height: " + height + " | Status: " + status + " ]";
    }

    
}
