package creditsuisse.shopping;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ThreePriceOfTwoTest {
    Item lime = new ItemRepository().getBySku("Lime");
    ThreePriceOfTwo offer = new ThreePriceOfTwo(lime);

    @Test
    public void threePriceOfTwoForThreeItems() {
        List<Item> basket = Arrays.asList(lime, lime, lime) ;
        assertThat(offer.discount(basket), is(-0.15)) ;
    }

    @Test
    public void threePriceOfTwoForFourItems() {
        List<Item> basket = Arrays.asList(lime, lime, lime, lime) ;
        assertThat(offer.discount(basket), is(-0.15)) ;
    }

    @Test
    public void threePriceOfTwoForTwoItems() {
        List<Item> basket = Arrays.asList(lime, lime) ;
        assertThat(offer.discount(basket), is(0.0)) ;
    }

    @Test
    public void threePriceOfTwoForNoItems() {
        List<Item> basket = Arrays.asList() ;
        assertThat(offer.discount(basket), is(0.0)) ;
    }
}