package creditsuisse.shopping;

import java.util.List;

public class ThreePriceOfTwo implements DiscountStrategy {

    private String sku;
    private double unitPrice;

    public ThreePriceOfTwo(Item item) {
        this.sku = item.getSku();
        this.unitPrice = item.getPrice();
    }

    public double discount(List<Item> basket) {
        long count = basket.stream().filter(item -> item.getSku().equals(sku)).count();

        double triples  = Math.floor(count / 3);
        double discount =  (triples * 2 * unitPrice) - (triples * 3 * unitPrice);
        return PriceUtils.round(discount, 2);
    }
}
