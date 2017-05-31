package creditsuisse.shopping;

import java.util.List;

public interface DiscountStrategy {
    double discount(List<Item> basket);
}
