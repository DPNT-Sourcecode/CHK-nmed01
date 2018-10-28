package befaster.solutions.CHK;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class SpecialOfferTest {

    @Test
    public void promotionApplyTest() {

        SpecialOffer specialOffer = new SpecialOffer(Arrays.asList(
                new Item('A', 60),
                new Item('A', 60)
        ), 100);

        List<Item> shoppingBasket = Arrays.asList(
                new Item('A', 60),
                new Item('A', 60),
                new Item('B', 20)
        );


        assertThat(specialOffer.doesApply(shoppingBasket), isTrue())


    }

}
