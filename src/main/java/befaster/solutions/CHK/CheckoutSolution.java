package befaster.solutions.CHK;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static befaster.solutions.CHK.Items.*;
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
| F    | 10    | 2F get one F free      |
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
                        asList(A, A, A),
                        130
                ),
                new SpecialOffer( //5A for 200
                        asList(A, A, A, A, A),
                        200
                ),
                new SpecialOffer( //2B for 45
                        asList(B, B),
                        45
                ),
                new SpecialOffer( // 2E get one B free
                        asList(E, E, B),
                        80
                ),
                new SpecialOffer( // 2F get one F free
                        asList(F, F, F),
                        20
                ),
                new SpecialOffer( // 5H for 45
                        asList(H, H, H, H, H),
                        45
                ),
                new SpecialOffer( // 10H for 45
                        IntStream.range(0, 9).mapToObj(i -> H).collect(Collectors.toList()),
                        80
                ),
                new SpecialOffer( // 2K for 150
                        asList(K, K),
                        150
                ),
                new SpecialOffer( // 2K for 150
                        asList(K, K),
                        150
                )
        );
    }


}
