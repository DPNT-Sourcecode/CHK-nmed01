package befaster.solutions.CHK;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class SpecialOfferTest {

    @Test
    public void promotionApplyTest() {

        SpecialOffer specialOffer = new SpecialOffer(Arrays.asList(
                new Item('A', 60),
                new Item('A', 60)
        ), 100);

        List<Item> shoppingBasket1 = Arrays.asList(
                new Item('A', 60),
                new Item('A', 60),
                new Item('B', 20)
        );

        List<Item> shoppingBasket2 = Arrays.asList(
                new Item('A', 60),
                new Item('B', 20)
        );

        assertThat(specialOffer.doesApply(shoppingBasket1)).isTrue();
        assertThat(specialOffer.doesApply(shoppingBasket2)).isFalse();

    }

}
