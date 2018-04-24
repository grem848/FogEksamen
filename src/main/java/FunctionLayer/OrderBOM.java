package FunctionLayer;

public class OrderBOM
{

    private int orderid;
    private int id;
    private int length;
    private int width;
    private int height;
    private boolean sent;

    public OrderBOM(int orderid, int id, int length, int width, int height, boolean sent) // get order
    {
        this.orderid = orderid;
        this.id = id;
        this.length = length;
        this.width = width;
        this.height = height;
        this.sent = sent;
    }

    public OrderBOM(int id, int length, int width, int height, boolean sent) // create order
    {
        this.id = id;
        this.length = length;
        this.width = width;
        this.height = height;
        this.sent = sent;
    }
    
    public OrderBOM(int length, int width, int height, boolean sent)
    {
        this.length = length;
        this.width = width;
        this.height = height;
        this.sent = sent;
    }
    
    public int getOrderid()
    {
        return orderid;
    }

    public void setOrderid(int orderid)
    {
        this.orderid = orderid;
    }
    
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public boolean isSent()
    {
        return sent;
    }

    public void setSent(boolean sent)
    {
        this.sent = sent;
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

    @Override
    public String toString()
    {
        String status;
        if(sent == true)
        {
            status = "Sent";
        }
        else
        {
            status = "Pending";
        }
        return "[ Order ID: " + orderid + " | Bill of Materials: Length:" + length + ", Width: " + width + ", Height: " + height + " | Status: " + status + " ]";
    }

    
}
