
package FunctionLayer;


public class Product {
    
    private String name;
    private String ratio;
    private int price;
    private int amount;
    
    /**
     *
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
     *
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
     *
     * @param productname
     * @param priceforeach
     */
    public Product(String productname, int priceforeach) {
        
        this.name = productname;
        this.price = priceforeach;
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
    
    
}
