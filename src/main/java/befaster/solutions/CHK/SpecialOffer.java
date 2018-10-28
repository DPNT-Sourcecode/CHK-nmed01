package befaster.solutions.CHK;

import java.util.ArrayList;
import java.util.List;

public class SpecialOffer {

    private final List<Item> items;
    private final int promotionPrice;

    public SpecialOffer(List<Item> items, int promotionPrice) {
        this.items = items;
        this.promotionPrice = promotionPrice;
    }

    public List<Item> getItems() {
        return items;
    }

    public int getPromotionPrice() {
        return promotionPrice;
    }

    public boolean doesApply(List<Item> itemsInShoppingBasket) {

        List<Item> remainingInShoppingBasket = new ArrayList<>(itemsInShoppingBasket);

        for(Item requiredItem : this.items) {
            if(!remainingInShoppingBasket.contains(requiredItem)) {
                return false;
            }
            remainingInShoppingBasket.remove(requiredItem);

        }

        return true;

    }

    /**
     * @param itemsInShoppingBasket
     * @return items in the shopping basket not in promotion
     */
    public List<Item> apply(List<Item> itemsInShoppingBasket) {

        List<Item> remainingInShoppingBasket = new ArrayList<>(itemsInShoppingBasket);

        for(Item requiredItem : this.items) {

            boolean isRemoved = remainingInShoppingBasket.remove(requiredItem);

            if(!isRemoved) {
                throw new SpecialOfferException("promotion does not apply");
            }
        }

        return remainingInShoppingBasket;


    }

}
