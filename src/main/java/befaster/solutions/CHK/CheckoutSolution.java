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

        List<SimpleSpecialOffer> allSpecialOffers = getSpecialOffers();
        List<Item> shoppingBasket = SkuParser.parseSkus(skus);

        ShoppingBasketWithSpecialOffersApplied shoppingBasketWithSpecialOffersApplied = applyPromotions(shoppingBasket, allSpecialOffers);

        return shoppingBasketWithSpecialOffersApplied.getPrice();
    }

    private ShoppingBasketWithSpecialOffersApplied applyPromotions(List<Item> shoppingBasket, List<SimpleSpecialOffer> allSpecialOffers) {

        List<SimpleSpecialOffer> applicableSpecialOffers = new ArrayList<>();
        List<Item> itemsNotInPromotion = new ArrayList<>(shoppingBasket);

        while (isSpecialOfferAvailable(itemsNotInPromotion, allSpecialOffers)) {
            SimpleSpecialOffer specialOffer = getAvailableSpecialOffer(itemsNotInPromotion, allSpecialOffers);
            itemsNotInPromotion = specialOffer.apply(itemsNotInPromotion);
            applicableSpecialOffers.add(specialOffer);
        }

        return new ShoppingBasketWithSpecialOffersApplied(applicableSpecialOffers, itemsNotInPromotion);

    }

    private SimpleSpecialOffer getAvailableSpecialOffer(List<Item> items, List<SimpleSpecialOffer> allSpecialOffers) {
        return allSpecialOffers.stream()
                .filter(offer -> offer.doesApply(items))
                .sorted(new SimpleSpecialOffer.AmountSavedComparator(items).reversed())
                .findFirst().get();
    }

    private boolean isSpecialOfferAvailable(List<Item> items, List<SimpleSpecialOffer> allSpecialOffers) {
        return allSpecialOffers.stream().anyMatch(offer -> offer.doesApply(items));
    }

    private List<SimpleSpecialOffer> getSpecialOffers() {
        return asList(
                new SimpleSpecialOffer( //3A for 130
                        asList(A, A, A),
                        130
                ),
                new SimpleSpecialOffer( //5A for 200
                        nTimes(A, 5),
                        200
                ),
                new SimpleSpecialOffer( //2B for 45
                        asList(B, B),
                        45
                ),
                new SimpleSpecialOffer( // 2E get one B free
                        asList(E, E, B),
                        Stream.of(E, E).mapToInt(Item::getPrice).sum()
                ),
                new SimpleSpecialOffer( // 2F get one F free
                        asList(F, F, F),
                        Stream.of(F, F).mapToInt(Item::getPrice).sum()
                ),
                new SimpleSpecialOffer( // 5H for 45
                        asList(H, H, H, H, H),
                        45
                ),
                new SimpleSpecialOffer( // 10H for 80
                        nTimes(H, 10),
                        80
                ),
                new SimpleSpecialOffer( // 10H for 80
                        nTimes(K, 2),
                        150
                ),
                new SimpleSpecialOffer( //3N get one M free
                        asList(N, N, N, M),
                        Stream.of(N, N, N).mapToInt(Item::getPrice).sum()
                ),
                new SimpleSpecialOffer( // 5P for 200
                        nTimes(P, 5),
                        200
                ),
                new SimpleSpecialOffer( // 3Q for 80
                        nTimes(Q, 3),
                        80
                ),
                new SimpleSpecialOffer( // 3R get one Q free
                        asList(R, R, R, Q),
                        Stream.of(R, R, R).mapToInt(Item::getPrice).sum()
                ),
                new SimpleSpecialOffer( // 3U get one U free
                        asList(U, U, U, U),
                        Stream.of(U, U, U).mapToInt(Item::getPrice).sum()
                ),
                new SimpleSpecialOffer( // 2V for 90
                        asList(V, V),
                        90
                ),
                new SimpleSpecialOffer( // 3V for 130
                        asList(V, V, V),
                        130
                )

        );
    }

    private List<Item> nTimes(Item item, int times) {
        return IntStream.range(0, times).mapToObj(i -> item).collect(Collectors.toList());
    }


}
