package creditsuisse.shopping;

import java.util.Arrays;
import java.util.List;

public class Cashier {
    private ItemRepository repository = new ItemRepository();

    private final List<DiscountStrategy> discounts =  Arrays.asList(
            new ThreePriceOfTwo(repository.getBySku("Lime")),
            new BuyOneGetOneFree(repository.getBySku("Melon"))
    );

    public double subTotal(List<Item> basket) {
        return basket.stream().mapToDouble(Item::getPrice).sum();
    }

    public double savingsTotal(List<Item> basket) {
        return discounts.stream().mapToDouble(offer -> offer.discount(basket)).sum();
    }

    public double total(List<Item> basket) {
        return subTotal(basket) + savingsTotal(basket);
    }
}
