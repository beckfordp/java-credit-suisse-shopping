package creditsuisse.shopping;

import java.util.List;

public class BuyOneGetOneFree implements DiscountStrategy {

    private String sku;
    private double unitPrice;

    public BuyOneGetOneFree(Item iteme)  {
        this.sku = iteme.getSku();
        this.unitPrice = iteme.getPrice();
    }

    public double discount(List<Item> basket) {
        long count = basket.stream().filter(item -> item.getSku().equals(sku)).count();

        double  pairs  = Math.floor(count / 2);
        double discount =  - (pairs * unitPrice);
        return PriceUtils.round( discount, 2);
    }
}