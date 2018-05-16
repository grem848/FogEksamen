package FunctionLayer;

import java.util.ArrayList;
import java.util.List;

public class BOMCalculator
{

    private double length;
    private double width;
    private double height;
    private int totalPrice = 0;

    private List<Product> products;
    private List<Product> products2;

    private List<Product> resDemo = new ArrayList<>();
    private List<Product> resDemo2 = new ArrayList<>();

    private VirtualCalculator vc = new VirtualCalculator();

    private double area;

    public BOMCalculator(double length, double width, double height , double shedLength, double shedWidth) throws OrderBuilderException {

        this.length = length;
        this.width = width;
        this.height = height;

        this.area = length * width;

        this.products = LogicFacade.getProductsFromDB();
        this.products2 = LogicFacade.getProductsFromDB2();

        this.resDemo = this.products;
        this.resDemo2 = this.products2;

        calculation1(area);

//        resDemo.add(new Product("Total Price", calculateTotalPrice(), 0));

        vc.sketch(width, length, shedWidth, shedLength);
//        calculateTotalPrice();
        
        vc.sketch(width, length, 0, 0);

        calculation2();
        
        resDemo2.add(new Product("100x100mm wood for shed", calculateShedWalls(shedLength, shedWidth, height ), ((shedLength * height) + (shedWidth * height))));

    }

    private void calculation1(double area)
    {

        for (Product product : resDemo)
        {

            product.setAmount((int) Math.ceil((assignRatio(product.getName()) * area)));

            product.setPrice((int) (assignPrice(product.getName()) * product.getAmount()));
        }
    }

    private void calculation2()
    {

        for (int i = 0; i < resDemo2.size(); i++)
        {

            switch (resDemo2.get(i).getName())
            {

                //beregner hvor mange af 100x100mm og deres totale pris
                case "100x100mm wood for walls":

                    resDemo2.get(i).setAmount((int) (Math.ceil(calculateWoodUsage(length, width, height))));
                    resDemo2.get(i).setPrice(resDemo2.get(i).getAmount() * resDemo2.get(i).getPrice());
//                    totalPrice += (resDemo2.get(i).getAmount() * resDemo2.get(i).getPrice());
                    break;

                case "45x195 mm. spærtræ ubh.":

                    resDemo2.get(i).setAmount(vc.getRafterAmount());
                    resDemo2.get(i).setPrice(resDemo2.get(i).getAmount() * resDemo2.get(i).getPrice());

                    break;

                case "97x97 mm.	trykimp. Stolpe":

                    resDemo2.get(i).setAmount(vc.getPostAmount());
                    resDemo2.get(i).setPrice(resDemo2.get(i).getAmount() * resDemo2.get(i).getPrice());

                    break;

                case "Plastmo Ecolite blåtonet":

                    resDemo2.get(i).setAmount((int) (Math.ceil(calculateRoff(length, width))));
                    resDemo2.get(i).setPrice(resDemo2.get(i).getAmount() * resDemo2.get(i).getPrice());

                    break;

            }

        }
        calculateTotalPrice();
    }

    // calculates all the sides of the carport, except the front and roof.
    private double calculateWoodUsage(double length, double width, double height)
    {

        double amount = (((length * height) * 2) + (width * height));
        
        return amount;

    }
    
    private int calculateShedWalls(double shedLength , double shedWidth, double height){
        
        double shedArea = calculateShedWood( shedLength , shedWidth , height);
        int price = 0;
                
                for (int i = 0; i < products2.size() ; i++) {
            
                    if(products2.get(i).getName().equals("100x100mm wood for walls")){
                        
                        price = products2.get(i).getPrice();
                        
                    }
                    
        }
                return (int)(price * (Math.ceil(shedArea)));
        
    }
    
       private double calculateShedWood(double shedLength, double shedWidth, double height) {

        double amount = ((shedLength * height) + (shedWidth * height)) / 100;;
        
        return amount;

    }

    private double calculateRoff(double length, double width)
    {

        return (length * width);

    }

    private int calculateTotalPrice()
    {

        int res = 0;

        for (Product product : products)
        {

            res += product.getPrice();

        }
        for (Product product : products2)
        {

            res += product.getPrice();

        }
        totalPrice = res;
        return res;
    }

    public int getTotalPrice()
    {
        if (totalPrice == 0)
        {
            calculateTotalPrice();
        }
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    private double assignRatio(String name)
    {

        double ratio = 0;

        for (Product product : resDemo)
        {

            if (name.equals(product.getName()))
            {
                ratio = Double.parseDouble(product.getRatio());

            }
        }

        return ratio;
    }

    private double assignPrice(String name)
    {

        double price = 0;

        for (Product product : resDemo)
        {

            if (name.equals(product.getName()))
            {
                price = product.getPrice();
            }
        }

        return price;
    }

    /**
     *
     * @return
     */
    public List<Product> getProducts()
    {
        return products;
    }

    /**
     *
     * @param products
     */
    public void setProducts(List<Product> products)
    {
        this.products = products;
    }

    /**
     *
     * @return
     */
    public List<Product> getResDemo()
    {
        return resDemo;
    }

    /**
     *
     * @param resDemo
     */
    public void setResDemo(List<Product> resDemo)
    {
        this.resDemo = resDemo;
    }

    /**
     *
     * @return
     */
    public List<Product> getProducts2()
    {
        return products2;
    }

    /**
     *
     * @param products2
     */
    public void setProducts2(List<Product> products2)
    {
        this.products2 = products2;
    }

    /**
     *
     * @return
     */
    public List<Product> getResDemo2()
    {
        return resDemo2;
    }

    /**
     *
     * @param resDemo2
     */
    public void setResDemo2(List<Product> resDemo2)
    {
        this.resDemo2 = resDemo2;
    }

}
