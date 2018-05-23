
package FunctionLayer;


public class Product {
    
    private String name;
    private String ratio;
    private int price;
    private int amount;
    
    /**
     * Constructor used for getting Data from Database. 
     * <p>
     * Called from DBAccess.OrderMapper and BOMCalculator
     * @param name
     * @param ratio
     * @param price
     */
    public Product(String name, String ratio, int price) {
        this.name = name;
        this.ratio = ratio;
        this.price = price;
    }

    /**
     * Constructor used to display products in editorderpage 
     * <p>
     * Used in PresentationLayer.EditOrder.java and editorderpage
     * @param name
     * @param price
     * @param amount
     */
    public Product(String name, int price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    /**
     * Constructor Used in Database to get Data
     * <p>
     * called in OrderMapper
     * 
     * @param productname
     * @param priceforeach
     */
    public Product(String productname, int priceforeach) {
        
        this.name = productname;
        this.price = priceforeach;
    }

    /**
     * Constructor used to display the shed in editorderpage
     * <p>
     * method called from BomCalculator
     * @param shedWalls
     * @param calculateShedWalls
     * @param d 
     */
    Product(String shedWalls, int calculateShedWalls, double d) {
        
        this.name = shedWalls;
        this.price = (int) calculateShedWalls;
        this.amount = (int) d;
        
    }
    
    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getRatio() {
        return ratio;
    }

    /**
     *
     * @param ratio
     */
    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    /**
     *
     * @return
     */
    public int getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     *
     * @return
     */
    public int getAmount() {
        return amount;
    }

    /**
     *
     * @param amount
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString()
    {
        return "Product{" + "name=" + name + ", ratio=" + ratio + ", price=" + price + ", amount=" + amount + '}';
    }
    
    
}
