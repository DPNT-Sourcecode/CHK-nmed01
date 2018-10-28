package befaster.solutions.CHK;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static befaster.solutions.CHK.Items.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AnyNOfGroupSpecialOfferTest {

    @Test
    public void test() {

        List<Item> shoppingBasket1 = Arrays.asList(T, X, Y, Z);
        List<Item> shoppingBasket2 = Arrays.asList(S, X, Y, Z);
        List<Item> shoppingBasket3 = Arrays.asList(Z, Z, X, X, X);
        List<Item> shoppingBasket4 = Arrays.asList(T, X);
        SpecialOffer specialOffer = new AnyNOfGroupSpecialOffer(3, Arrays.asList(S, T, X, Y, Z),45 );


        assertThat(specialOffer.doesApply(shoppingBasket1)).isTrue();
        assertThat(specialOffer.apply(shoppingBasket1)).containsOnlyOnce(X);

        assertThat(specialOffer.doesApply(shoppingBasket2)).isTrue();
        assertThat(specialOffer.apply(shoppingBasket2)).containsOnlyOnce(X);

        assertThat(specialOffer.doesApply(shoppingBasket3)).isTrue();
        assertThat(specialOffer.apply(shoppingBasket3)).containsExactlyInAnyOrder(X, X);


        assertThat(specialOffer.doesApply(shoppingBasket4)).isFalse();

    }

}
