/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mohammahomarhariri
 */
public class BOMCalculator {

    private int length;
    private int width;

    private List<Product> products;

    private List<Product> resDemo = new ArrayList<>();

    private double area;

    public BOMCalculator(int length, int width) throws OrderBuilderException {

        this.length = length;
        this.width = width;

        this.area = length * width;

        this.products = LogicFacade.getProductsFromDB();
        
        this.resDemo = this.products;
        
        calculation(area);
        
        resDemo.add(new Product("Total Price", calculateTotalPrice(), 0));
    }

    private void calculation(double area) {

        for (Product product : resDemo) {
            
            product.setAmount((int) Math.ceil((assignRatio(product.getName()) * area)));
            
            product.setPrice((int) (assignPrice(product.getName()) * product.getAmount()));
        }

    }
    
    private int calculateTotalPrice(){
        
        int res = 0;
        
        for (Product product : products) {
            
            res += product.getPrice();
            
        }
        
        return res;
        
    }

        private double assignRatio(String name) {

        double ratio = 0;

        for (Product product : resDemo) {

            if (name.equals(product.getName())) {
                ratio = Double.parseDouble(product.getRatio());
                
            }
        }

        return ratio;
    }
    
    private double assignPrice(String name) {

        double price = 0;

        for (Product product : resDemo) {

            if (name.equals(product.getName())) {
                price = product.getPrice();
            }
        }

        return price;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
  

    public List<Product> getResDemo() {
        return resDemo;
    }

    public void setResDemo(List<Product> resDemo) {
        this.resDemo = resDemo;
    }

}
