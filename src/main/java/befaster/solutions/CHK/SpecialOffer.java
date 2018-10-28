package befaster.solutions.CHK;

import java.util.Comparator;
import java.util.List;

public interface SpecialOffer {

    int getPromotionPrice();

    boolean doesApply(List<Item> itemsInShoppingBasket);
    /**
     * @param itemsInShoppingBasket
     * @return items in the shopping basket not in promotion
     */
    List<Item> apply(List<Item> itemsInShoppingBasket);

    int getAmountSaved(List<Item> itemsInShoppingBasket);

    class AmountSavedComparator implements Comparator<SimpleSpecialOffer> {

        private List<Item> itemsInShoppingBasket;
        public AmountSavedComparator (List<Item> itemsInShoppingBasket) {
            this.itemsInShoppingBasket = itemsInShoppingBasket;
        }

        @Override
        public int compare(SimpleSpecialOffer o1, SimpleSpecialOffer o2) {
            return Integer.compare(o1.getAmountSaved(itemsInShoppingBasket), o2.getAmountSaved(itemsInShoppingBasket));
        }
    }

}
