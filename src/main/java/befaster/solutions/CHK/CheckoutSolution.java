package befaster.solutions.CHK;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/*
+------+-------+------------------------+
| Item | Price | Special offers         |
+------+-------+------------------------+
| A    | 50    | 3A for 130, 5A for 200 |
| B    | 30    | 2B for 45              |
| C    | 20    |                        |
| D    | 15    |                        |
| E    | 40    | 2E get one B free      |
+------+-------+------------------------+
 */
public class CheckoutSolution {
    public Integer checkout(String skus) {

        if (!SkuParser.isValidInput(skus)) {
            return -1;
        }

        List<SpecialOffer> allSpecialOffers = getSpecialOffers();
        List<Item> shoppingBasket = SkuParser.parseSkus(skus);

        ShoppingBasketWithSpecialOffersApplied shoppingBasketWithSpecialOffersApplied = applyPromotions(shoppingBasket, allSpecialOffers);

        return shoppingBasketWithSpecialOffersApplied.getPrice();
    }

    private ShoppingBasketWithSpecialOffersApplied applyPromotions(List<Item> shoppingBasket, List<SpecialOffer> allSpecialOffers) {

        List<SpecialOffer> applicableSpecialOffers = new ArrayList<>();
        List<Item> itemsNotInPromotion = new ArrayList<>(shoppingBasket);

        while (isSpecialOfferAvailable(itemsNotInPromotion, allSpecialOffers)) {
            SpecialOffer specialOffer = getAvailableSpecialOffer(itemsNotInPromotion, allSpecialOffers);
            itemsNotInPromotion = specialOffer.apply(itemsNotInPromotion);
            applicableSpecialOffers.add(specialOffer);
        }

        return new ShoppingBasketWithSpecialOffersApplied(applicableSpecialOffers, itemsNotInPromotion);

    }

    private SpecialOffer getAvailableSpecialOffer(List<Item> items, List<SpecialOffer> allSpecialOffers) {
        return allSpecialOffers.stream()
                .filter(offer -> offer.doesApply(items))
                .sorted(new SpecialOffer.AmountSavedComparator().reversed())
                .findFirst().get();
    }

    private boolean isSpecialOfferAvailable(List<Item> items, List<SpecialOffer> allSpecialOffers) {
        return allSpecialOffers.stream().anyMatch(offer -> offer.doesApply(items));
    }

    private List<SpecialOffer> getSpecialOffers() {
        return asList(
                new SpecialOffer( //3A for 130
                        asList(
                                new Item('A', 50),
                                new Item('A', 50),
                                new Item('A', 50)),
                        130
                ),
                new SpecialOffer( //5A for 200
                        asList(
                                new Item('A', 50),
                                new Item('A', 50),
                                new Item('A', 50),
                                new Item('A', 50),
                                new Item('A', 50)),
                        200
                ),
                new SpecialOffer( //2B for 45
                        asList(
                                new Item('B', 30),
                                new Item('B', 30)),
                        45
                ),
                new SpecialOffer( // 2E get one B free - we don't need to worry about the value of B at the moment
                        asList(
                                new Item('E', 40),
                                new Item('E', 40),
                                new Item('B', 30)),
                        80
                )
        );
    }


}
