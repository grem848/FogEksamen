/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;

/**
 *
 * @author mohammahomarhariri
 */
public class BOMCalculator {

    private int length;
    private int width;
    
    private int endPrice;

    private List<Product> products;

    private List<Product> res = new ArrayList();

    private double area;

//    private final double ratioPlastmoBottomScrews;
//    private final double ratioPerforatedBand;
//    private final double ratioUniversalRight;
//    private final double ratioUniversalLeft;
//    private final double ratioScrews60mm;
//    private final double ratioBracketScrews50mm;
//    private final double ratioCarriageBolt;
//    private final double ratioSquarePost;
//    private final double ratioScrews50mm;
//    private final double ratioScrews70mm;
//    private final double ratioFarmgateGrip;
//    private final double ratioTHinge;
//    private final double ratioAngleBracket;
    
    private int plastmoBottomScrews;
    private int perforatedBand;
    private int universalRight;
    private int universalLeft;
    private int screws60mm;
    private int bracketScrews50mm;
    private int carriageBolt;
    private int squarePost;
    private int screws50mm;
    private int screws70mm;
    private int farmgateGrip;
    private int tHinge;
    private int angleBracket;

    private int pricePlastmoBottomScrews = 0;
    private int pricePerforatedBand = 0;
    private int priceUniversalRight = 0;
    private int priceUniversalLeft = 0;
    private int priceScrews60mm = 0;
    private int priceBracketScrews50mm = 0;
    private int priceCarriageBolt = 0;
    private int priceSquarePost = 0;
    private int priceScrews50mm = 0;
    private int priceScrews70mm = 0;
    private int priceFarmgateGrip = 0;
    private int priceTHinge = 0;
    private int priceAngleBracket = 0;

    public BOMCalculator(int length, int width) throws OrderBuilderException {

        this.length = length;
        this.width = width;

        this.area = length * width;

        this.products = LogicFacade.getProductsFromDB();

        calculateBOM();

        calculatePrice();

        res.add(new Product("4.5 x 60 mm Screws 200 pcs.", priceAngleBracket, angleBracket));
        res.add(new Product("Bracket Screws 4.0 x 50mm. 250 pcs.", priceBracketScrews50mm, bracketScrews50mm));
        res.add(new Product("Carriage Bolt 10 x 120mm", priceCarriageBolt, carriageBolt));
        res.add(new Product("Farmgate Grip 50 x 75", priceFarmgateGrip, farmgateGrip));
        res.add(new Product("Perforated Band 1 x 20mm 10 mtr.", pricePerforatedBand, perforatedBand));
        res.add(new Product("Plastmo Bottom Screws 200 pcs.", pricePlastmoBottomScrews, plastmoBottomScrews));
        res.add(new Product("Square Slices 40x40x11mm", priceSquarePost, squarePost));
        res.add(new Product("T Hinge 390mm", priceTHinge, tHinge));
        res.add(new Product("Universal 190 mm Left", priceUniversalLeft, universalLeft));
        res.add(new Product("Universal 190 mm Right", priceUniversalRight, universalRight));
        res.add(new Product("4.5 x 50 mm Screws 300 pcs.", priceScrews50mm, screws50mm));
        res.add(new Product("4.5 x 60 mm Screws 200 pcs.", priceScrews60mm, screws60mm));
        res.add(new Product("4.5 x 70mm Screws 300 pcs. ", priceScrews70mm, screws70mm));
        res.add(new Product("end Price", endPrice, 0));
        

    }

    private void calculateBOM() {

        angleBracket = (int) Math.ceil((assignRatio("4.5 x 60 mm Screws 200 pcs.") * area));
        bracketScrews50mm = (int) Math.ceil((assignRatio("Bracket Screws 4.0 x 50mm. 250 pcs.") * area));
        carriageBolt = (int) Math.ceil((assignRatio("Carriage Bolt 10 x 120mm") * area));
        farmgateGrip = (int) Math.ceil((assignRatio("Farmgate Grip 50 x 75") * area));
        perforatedBand = (int) Math.ceil((assignRatio("Perforated Band 1 x 20mm 10 mtr.") * area));
        plastmoBottomScrews = (int) Math.ceil((assignRatio("Plastmo Bottom Screws 200 pcs.") * area));
        screws50mm = (int) Math.ceil((assignRatio("4.5 x 50 mm Screws 300 pcs.") * area));
        screws60mm = (int) Math.ceil((assignRatio("4.5 x 60 mm Screws 200 pcs.") * area));
        screws70mm = (int) Math.ceil((assignRatio("4.5 x 70mm Screws 300 pcs. ") * area));
        squarePost = (int) Math.ceil((assignRatio("Square Slices 40x40x11mm") * area));
        tHinge = (int) Math.ceil((assignRatio("T Hinge 390mm") * area));
        universalLeft = (int) Math.ceil((assignRatio("Universal 190 mm Left") * area));
        universalRight = (int) Math.ceil((assignRatio("Universal 190 mm Right") * area));

    }

    private void calculatePrice() {

        priceAngleBracket = (int) ((assignPrice("4.5 x 60 mm Screws 200 pcs.") * angleBracket));
        priceBracketScrews50mm = (int) ((assignPrice("Bracket Screws 4.0 x 50mm. 250 pcs.") * bracketScrews50mm));
        priceCarriageBolt = (int) ((assignPrice("Carriage Bolt 10 x 120mm") * carriageBolt));
        priceFarmgateGrip = (int) ((assignPrice("Farmgate Grip 50 x 75") * farmgateGrip));
        pricePerforatedBand = (int) ((assignPrice("Perforated Band 1 x 20mm 10 mtr.") * perforatedBand));
        pricePlastmoBottomScrews = (int) ((assignPrice("Plastmo Bottom Screws 200 pcs.") * plastmoBottomScrews));
        priceSquarePost = (int) ((assignPrice("Square Slices 40x40x11mm") * squarePost));
        priceTHinge = (int) ((assignPrice("T Hinge 390mm") * tHinge));
        priceUniversalLeft = (int) ((assignPrice("Universal 190 mm Left") * universalLeft));
        priceUniversalRight = (int) ((assignPrice("Universal 190 mm Right") * universalRight));
        priceScrews50mm = (int) ((assignPrice("4.5 x 50 mm Screws 300 pcs.") * screws50mm));
        priceScrews60mm = (int) ((assignPrice("4.5 x 60 mm Screws 200 pcs.") * screws60mm));
        priceScrews70mm = (int) ((assignPrice("4.5 x 70mm Screws 300 pcs. ") * screws70mm));
        
        endPrice = priceAngleBracket + priceBracketScrews50mm + priceCarriageBolt + priceFarmgateGrip + pricePlastmoBottomScrews + pricePerforatedBand + priceScrews50mm + priceScrews60mm + priceScrews70mm + priceSquarePost + priceTHinge + priceUniversalLeft+ priceUniversalRight;

    }

    private double assignRatio(String name) {

        double ratio = 0;

        for (Product product : products) {

            if (name.equals(product.getName())) {
                ratio = Double.parseDouble(product.getRatio());
            }
        }

        return ratio;
    }

    private double assignPrice(String name) {

        double price = 0;

        for (Product product : products) {

            if (name.equals(product.getName())) {
                price = product.getPrice();
            }
        }

        return price;
    }

    public List<Product> getRes() {
        return res;
    }

    public void setRes(List<Product> res) {
        this.res = res;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getPricePlastmoBottomScrews() {
        return pricePlastmoBottomScrews;
    }

    public void setPricePlastmoBottomScrews(int pricePlastmoBottomScrews) {
        this.pricePlastmoBottomScrews = pricePlastmoBottomScrews;
    }

    public int getPricePerforatedBand() {
        return pricePerforatedBand;
    }

    public void setPricePerforatedBand(int pricePerforatedBand) {
        this.pricePerforatedBand = pricePerforatedBand;
    }

    public int getPriceUniversalRight() {
        return priceUniversalRight;
    }

    public void setPriceUniversalRight(int priceUniversalRight) {
        this.priceUniversalRight = priceUniversalRight;
    }

    public int getPriceUniversalLeft() {
        return priceUniversalLeft;
    }

    public void setPriceUniversalLeft(int priceUniversalLeft) {
        this.priceUniversalLeft = priceUniversalLeft;
    }

    public int getPriceScrews60mm() {
        return priceScrews60mm;
    }

    public void setPriceScrews60mm(int priceScrews60mm) {
        this.priceScrews60mm = priceScrews60mm;
    }

    public int getPriceBracketScrews50mm() {
        return priceBracketScrews50mm;
    }

    public void setPriceBracketScrews50mm(int priceBracketScrews50mm) {
        this.priceBracketScrews50mm = priceBracketScrews50mm;
    }

    public int getPriceCarriageBolt() {
        return priceCarriageBolt;
    }

    public void setPriceCarriageBolt(int priceCarriageBolt) {
        this.priceCarriageBolt = priceCarriageBolt;
    }

    public int getPriceSquarePost() {
        return priceSquarePost;
    }

    public void setPriceSquarePost(int priceSquarePost) {
        this.priceSquarePost = priceSquarePost;
    }

    public int getPriceScrews50mm() {
        return priceScrews50mm;
    }

    public void setPriceScrews50mm(int priceScrews50mm) {
        this.priceScrews50mm = priceScrews50mm;
    }

    public int getPriceScrews70mm() {
        return priceScrews70mm;
    }

    public void setPriceScrews70mm(int priceScrews70mm) {
        this.priceScrews70mm = priceScrews70mm;
    }

    public int getPriceFarmgateGrip() {
        return priceFarmgateGrip;
    }

    public void setPriceFarmgateGrip(int priceFarmgateGrip) {
        this.priceFarmgateGrip = priceFarmgateGrip;
    }

    public int getPriceTHinge() {
        return priceTHinge;
    }

    public void setPriceTHinge(int priceTHinge) {
        this.priceTHinge = priceTHinge;
    }

    public int getPriceAngleBracket() {
        return priceAngleBracket;
    }

    public void setPriceAngleBracket(int priceAngleBracket) {
        this.priceAngleBracket = priceAngleBracket;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getPlastmoBottomScrews() {
        return plastmoBottomScrews;
    }

    public void setPlastmoBottomScrews(int plastmoBottomScrews) {
        this.plastmoBottomScrews = plastmoBottomScrews;
    }

    public int getPerforatedBand() {
        return perforatedBand;
    }

    public void setPerforatedBand(int perforatedBand) {
        this.perforatedBand = perforatedBand;
    }

    public int getUniversalRight() {
        return universalRight;
    }

    public void setUniversalRight(int universalRight) {
        this.universalRight = universalRight;
    }

    public int getUniversalLeft() {
        return universalLeft;
    }

    public void setUniversalLeft(int universalLeft) {
        this.universalLeft = universalLeft;
    }

    public int getScrews60mm() {
        return screws60mm;
    }

    public void setScrews60mm(int screws60mm) {
        this.screws60mm = screws60mm;
    }

    public int getBracketScrews50mm() {
        return bracketScrews50mm;
    }

    public void setBracketScrews50mm(int bracketScrews50mm) {
        this.bracketScrews50mm = bracketScrews50mm;
    }

    public int getCarriageBolt() {
        return carriageBolt;
    }

    public void setCarriageBolt(int carriageBolt) {
        this.carriageBolt = carriageBolt;
    }

    public int getSquarePost() {
        return squarePost;
    }

    public void setSquarePost(int squarePost) {
        this.squarePost = squarePost;
    }

    public int getScrews50mm() {
        return screws50mm;
    }

    public void setScrews50mm(int screws50mm) {
        this.screws50mm = screws50mm;
    }

    public int getScrews70mm() {
        return screws70mm;
    }

    public void setScrews70mm(int screws70mm) {
        this.screws70mm = screws70mm;
    }

    public int getFarmgateGrip() {
        return farmgateGrip;
    }

    public void setFarmgateGrip(int farmgateGrip) {
        this.farmgateGrip = farmgateGrip;
    }

    public int gettHinge() {
        return tHinge;
    }

    public void settHinge(int tHinge) {
        this.tHinge = tHinge;
    }

    public int getAngleBracket() {
        return angleBracket;
    }

    public void setAngleBracket(int angleBracket) {
        this.angleBracket = angleBracket;
    }

}
