package creditsuisse.shopping;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CashierTest {

    private ItemRepository repository = new ItemRepository();
    Item apple = repository.getBySku("Apple");
    Item banana = repository.getBySku("Banana");
    Item melon = repository.getBySku("Melon");
    Item lime = repository.getBySku("Lime");

    private List<Item> basket = Arrays.asList(apple, apple, banana, banana, melon, melon, lime, lime, lime);

    private Cashier cashier = new Cashier();

    @Test
    public void priceOfBasketWithoutDiscounts() {
        assertThat(cashier.subTotal(basket), is(2.55));
 }

    @Test
    public void threeForTwoSavings() {
        assertThat(cashier.savingsTotal(Arrays.asList(lime, lime, lime)), is(-0.15));
    }

    @Test
    public void buyOneGetOneFreeSavings() {
        assertThat(cashier.savingsTotal(Arrays.asList(melon, melon)), is(-0.50));
    }

    @Test
    public void multipleSavings() { assertThat(cashier.savingsTotal(basket), is(-0.65)); }

    @Test
    public void priceOfBasket() {
        assertThat(cashier.total(basket), is(1.90));
    }
}