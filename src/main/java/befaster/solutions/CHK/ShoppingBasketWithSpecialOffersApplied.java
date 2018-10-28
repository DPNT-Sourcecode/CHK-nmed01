package befaster.solutions.CHK;

import java.util.List;

public class ShoppingBasketWithSpecialOffersApplied {

    private final List<SimpleSpecialOffer> applicableSpecialOffers;
    private final List<Item> itemsNotInPromotion;

    public ShoppingBasketWithSpecialOffersApplied(List<SimpleSpecialOffer> applicableSpecialOffers, List<Item> itemsNotInPromotion) {
        this.applicableSpecialOffers = applicableSpecialOffers;
        this.itemsNotInPromotion = itemsNotInPromotion;
    }


    public List<SimpleSpecialOffer> getApplicableSpecialOffers() {
        return applicableSpecialOffers;
    }

    public List<Item> getItemsNotInPromotion() {
        return itemsNotInPromotion;
    }


    public Integer getPrice() {

        Integer amountInPromotions = applicableSpecialOffers.stream().mapToInt(SimpleSpecialOffer::getPromotionPrice).sum();
        Integer amountNotInPromotions = itemsNotInPromotion.stream().mapToInt(Item::getPrice).sum();

        return amountInPromotions + amountNotInPromotions;
    }

}
