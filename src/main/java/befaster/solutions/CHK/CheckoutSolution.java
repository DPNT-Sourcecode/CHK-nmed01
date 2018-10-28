package befaster.solutions.CHK;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static befaster.solutions.CHK.Items.*;
import static java.util.Arrays.asList;


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
                        nTimes(A, 5),
                        200
                ),
                new SpecialOffer( //2B for 45
                        asList(B, B),
                        45
                ),
                new SpecialOffer( // 2E get one B free
                        asList(E, E, B),
                        Stream.of(E, E).mapToInt(Item::getPrice).sum()
                ),
                new SpecialOffer( // 2F get one F free
                        asList(F, F, F),
                        Stream.of(F, F).mapToInt(Item::getPrice).sum()
                ),
                new SpecialOffer( // 5H for 45
                        asList(H, H, H, H, H),
                        45
                ),
                new SpecialOffer( // 10H for 80
                        nTimes(H, 10),
                        80
                ),
                new SpecialOffer( //3N get one M free
                        asList(N, N, N, M),
                        Stream.of(N, N, N).mapToInt(Item::getPrice).sum()
                ),
                new SpecialOffer( // 5P for 200
                        nTimes(P, 5),
                        200
                ),
                new SpecialOffer( // 3Q for 80
                        nTimes(Q, 3),
                        80
                ),
                new SpecialOffer( // 3R get one Q free
                        asList(R, R, R, Q),
                        Stream.of(R, R, R).mapToInt(Item::getPrice).sum()
                ),
                new SpecialOffer( // 3U get one U free
                        asList(U, U, U, U),
                        Stream.of(U, U, U).mapToInt(Item::getPrice).sum()
                ),
                new SpecialOffer( // 2V for 90
                        asList(V, V),
                        90
                ),
                new SpecialOffer( // 3V for 130
                        asList(V, V, V),
                        130
                )

        );
    }

    private List<Item> nTimes(Item item, int times) {
        return IntStream.range(0, times).mapToObj(i -> item).collect(Collectors.toList());
    }


}
