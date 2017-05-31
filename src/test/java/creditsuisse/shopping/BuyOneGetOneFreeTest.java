package creditsuisse.shopping;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BuyOneGetOneFreeTest {
    Item melon = new ItemRepository().getBySku("Melon");
    BuyOneGetOneFree offer = new BuyOneGetOneFree(melon);

    @Test
    public void buyOneGetOneFreeEven() {
        List<Item> basket = Arrays.asList(melon, melon) ;
        assertThat(offer.discount(basket), is(-0.50)) ;
    }

    @Test
    public void buyOneGetOneFreeOdd() {
        List<Item> basket = Arrays.asList(melon, melon, melon) ;
        assertThat(offer.discount(basket), is(-0.50)) ;
    }

    @Test
    public void buyOneGetOneFreeOneItemOnly() {
        List<Item> basket = Arrays.asList(melon) ;
        assertThat(offer.discount(basket), is(0.0)) ;
    }

    @Test
    public void buyOneGetOneFreeNoItems() {
        List<Item> basket = Arrays.asList() ;
        assertThat(offer.discount(basket), is(0.0)) ;
    }
}