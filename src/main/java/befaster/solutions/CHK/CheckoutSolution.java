package befaster.solutions.CHK;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

/*
+------+-------+----------------+
| Item | Price | Special offers |
+------+-------+----------------+
| A    | 50    | 3A for 130     |
| B    | 30    | 2B for 45      |
| C    | 20    |                |
| D    | 15    |                |
+------+-------+----------------+
 */
public class CheckoutSolution {
    public Integer checkout(String skus) {

        if(SkuParser.isValidInput(skus)) {
            return -1;
        }

        List<SpecialOffer> allSpecialOffers = getSpecialOffers();
        List<Item> shoppingBasket = SkuParser.parseSkus(skus);

        List<SpecialOffer> applicableSpecialOffers = new ArrayList<>();
        List<Item> itemsNotInPromotion = new ArrayList<>();



        return null;
    }

    private


    private List<SpecialOffer> getSpecialOffers() {
        return asList(
                new SpecialOffer(
                        asList(
                                new Item('A', 50),
                                new Item('A', 50),
                                new Item('A', 50)),
                        130
                ),
                new SpecialOffer(
                        asList(
                                new Item('B', 30),
                                new Item('B', 30)),
                        45
                )
        );
    }


}
