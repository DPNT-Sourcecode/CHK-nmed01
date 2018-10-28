package befaster.solutions.CHK;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class SimpleSpecialOfferTest {

    @Test
    public void doesApplyTest() {

        SimpleSpecialOffer specialOffer = new SimpleSpecialOffer(Arrays.asList(
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

    @Test
    public void applyTest() {

        SimpleSpecialOffer specialOffer = new SimpleSpecialOffer(Arrays.asList(
                new Item('A', 60),
                new Item('A', 60)
        ), 100);

        List<Item> shoppingBasket1 = Arrays.asList(
                new Item('A', 60),
                new Item('A', 60),
                new Item('B', 20)
        );

        List<Item> shoppingBasketAfterPromotion = Arrays.asList(
                new Item('B', 20)
        );


        assertThat(specialOffer.apply(shoppingBasket1)).hasSameElementsAs(shoppingBasketAfterPromotion);

    }

    @Test
    public void getAmountSavedTest() {

        SimpleSpecialOffer specialOffer1 = new SimpleSpecialOffer(Arrays.asList(
                new Item('A', 60),
                new Item('A', 60)
        ), 100);

        SimpleSpecialOffer specialOffer2 = new SimpleSpecialOffer(Arrays.asList(
                new Item('A', 10),
                new Item('B', 20),
                new Item('C', 30)
        ), 50);

        SimpleSpecialOffer specialOffer3 = new SimpleSpecialOffer(Arrays.asList(
                new Item('A', 10),
                new Item('A', 10)
        ), 100);


        assertThat(specialOffer1.getAmountSaved(null)).isEqualTo(20);
        assertThat(specialOffer2.getAmountSaved(null)).isEqualTo(10);
        assertThat(specialOffer3.getAmountSaved(null)).isEqualTo(-80);

    }

    @Test(expected = SpecialOfferException.class)
    public void applyOnNotApplicableShoppingBasketTest() {

        SimpleSpecialOffer specialOffer = new SimpleSpecialOffer(Arrays.asList(
                new Item('A', 60),
                new Item('A', 60)
        ), 100);

        List<Item> shoppingBasket2 = Arrays.asList(
                new Item('A', 60),
                new Item('B', 20)
        );

        specialOffer.apply(shoppingBasket2);


    }

    @Test
    public void amountSavedComparatorTest() {

        SimpleSpecialOffer specialOffer1 = new SimpleSpecialOffer(Arrays.asList(
                new Item('A', 60),
                new Item('A', 60)
        ), 100);

        SimpleSpecialOffer specialOffer2 = new SimpleSpecialOffer(Arrays.asList(
                new Item('A', 10),
                new Item('B', 20),
                new Item('C', 30)
        ), 50);

        SimpleSpecialOffer specialOffer3 = new SimpleSpecialOffer(Arrays.asList(
                new Item('A', 10),
                new Item('A', 10)
        ), 100);


        List<SimpleSpecialOffer> offers = Arrays.asList(specialOffer2, specialOffer1, specialOffer3);

        offers.sort(new SimpleSpecialOffer.AmountSavedComparator(null).reversed());

        assertThat(offers).containsExactly(specialOffer1, specialOffer2, specialOffer3);


    }


}
