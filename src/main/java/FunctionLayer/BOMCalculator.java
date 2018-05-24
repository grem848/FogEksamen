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

    /**
     * Everything is run in here, when ever the class get created, it runs through all the process and finds it.
     * <p>
     * Used when ever the class is instantiated.
     *
     * @param length
     * @param width
     * @param height
     * @param shedLength
     * @param shedWidth
     * @throws OrderBuilderException
     */
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

    /**
     * Uses area (through the parameters) to calculate the amount and price for each of the products inside the array (in the class).
     * <p>
     * The calculation is the same for each of the products because of the ratio that is in the database.
     * <p>
     * Used to calculate the prices and amount to be displayed later in the editorderpage.
     * @param area 
     */
    private void calculation1(double area)
    {

        for (Product product : resDemo)
        {

            product.setAmount((int) Math.ceil((assignRatio(product.getName()) * area)));

            product.setPrice((int) (assignPrice(product.getName()) * product.getAmount()));
        }
    }

    /**
     * Gets the List resDemo2 (from this class) and calculates everything based on the information of resDemo2.getName.
     * <p>
     * Used to calculate the amount and price of the List to be displayed later on in the editorderpage.
     * <p>
     * This version of the calculation, calculate rafter, post, roofPlastic, walls (Shed not incl.).
     */
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

    /**
     * Uses length,width,height to Calculate the Wood usaged for the walls, except the front and roof
     * <p>
     * because the front should be open for the vehicle, and the roof is calculated somewhere else for the plastic.
     * <p>
     * Used in method called calculation2
     * @param length
     * @param width
     * @param height
     * @return 
     * 
     */
    private double calculateWoodUsage(double length, double width, double height)
    {

        double amount = (((length * height) * 2) + (width * height));
        
        return amount;

    }
    
    /**
     * Uses shedLength, shedWidth and height to the woodUsage for walls, in the shed. Uses method CalculateShedWood for the calculation.  
     * <p>
     * Used in calculation2 to calculate the usage of the shedwalls.
     * @param shedLength
     * @param shedWidth
     * @param height
     * @return 
     */
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
    
    /**
     * Uses shedLength, shedWidth, height to calculate how much the amount of the wood used for 2 sides of the shed
     * <p>
     * the sides that are calculated are always 2. 
     * <p>
     * Used in calculateShedWalls in this class.
     * @param shedLength
     * @param shedWidth
     * @param height
     * @return 
     */
    private double calculateShedWood(double shedLength, double shedWidth, double height) {

        double amount = ((shedLength * height) + (shedWidth * height)) / 100;
        
        return amount;

    }

    /**
     * Calculate the roof area by length, width to know the amount of the plastic that has to be used.
     * <p>
     * Used in calculation2 for the calculation of the roof.
     * @param length
     * @param width
     * @return 
     */
    private double calculateRoff(double length, double width)
    {

        return (length * width);

    }

    /**
     * Calculate the total price of all products.
     * <p>
     * Method Used in PresintationLayer EmployeeEditOrder to display the total price.
     * @return 
     */
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

    /**
     * 
     * @return totalprice
     */
    public int getTotalPrice()
    {
        if (totalPrice == 0)
        {
            calculateTotalPrice();
        }
        return totalPrice;
    }

    /**
     *
     * @param totalPrice
     */
    public void setTotalPrice(int totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    /**
     * Uses the input to parse it to dosuble, because in the DB we have ratio as text. 
     * <p>
     * Used in the calculation1, for the ratio. 
     * 
     * @param name
     * @return 
     */
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

    /**
     * Uses name to get the product price in the class
     * <p>
     * Used in calculation1 to get product price.
     * @param name
     * @return 
     */
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
