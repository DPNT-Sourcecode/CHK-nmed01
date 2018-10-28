package befaster.solutions.CHK;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class SpecialOfferTest {

    @Test
    public void doesApplyTest() {

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

    @Test
    public void applyTest() {

        SpecialOffer specialOffer = new SpecialOffer(Arrays.asList(
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

        SpecialOffer specialOffer1 = new SpecialOffer(Arrays.asList(
                new Item('A', 60),
                new Item('A', 60)
        ), 100);

        SpecialOffer specialOffer2 = new SpecialOffer(Arrays.asList(
                new Item('A', 10),
                new Item('B', 20),
                new Item('C', 30)
        ), 50);

        SpecialOffer specialOffer3 = new SpecialOffer(Arrays.asList(
                new Item('A', 10),
                new Item('A', 10)
        ), 100);



        assertThat(specialOffer1.getAmountSaved()).isEqualTo(20);
        assertThat(specialOffer2.getAmountSaved()).isEqualTo(10);
        assertThat(specialOffer3.getAmountSaved()).isEqualTo(-80);

    }

    @Test(expected = SpecialOfferException.class)
    public void applyOnNotApplicableShoppingBasketTest() {

        SpecialOffer specialOffer = new SpecialOffer(Arrays.asList(
                new Item('A', 60),
                new Item('A', 60)
        ), 100);

        List<Item> shoppingBasket2 = Arrays.asList(
                new Item('A', 60),
                new Item('B', 20)
        );

        specialOffer.apply(shoppingBasket2);


    }


}
