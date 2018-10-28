package befaster.solutions.CHK;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AnyNOfGroupSpecialOffer implements SpecialOffer{


    private final int promotionPrice;
    private final int minNumber;
    private final List<Item> group;

    public AnyNOfGroupSpecialOffer(int minNumber, List<Item> group, int promotionPrice) {
        this.promotionPrice = promotionPrice;
        this.minNumber = minNumber;
        this.group = group;
    }

    @Override
    public int getPromotionPrice() {
        return promotionPrice;
    }

    @Override
    public boolean doesApply(List<Item> itemsInShoppingBasket) {
        return itemsInShoppingBasket.stream().filter(group::contains).count() >= minNumber;
    }

    @Override
    public List<Item> apply(List<Item> itemsInShoppingBasket) {

        List<Item> remainingItems = new ArrayList<>(itemsInShoppingBasket);

        List<Item> groupItems = itemsInShoppingBasket.stream()
                .filter(group::contains)
                .sorted(new Item.PriceComparator().reversed())
                .limit(minNumber)
                .collect(Collectors.toList());

        groupItems.forEach(remainingItems::remove);

        return remainingItems;
    }

    @Override
    public int getAmountSaved(List<Item> itemsInShoppingBasket) {
        return itemsInShoppingBasket.stream()
                .filter(group::contains)
                .sorted(new Item.PriceComparator().reversed())
                .limit(minNumber)
                .mapToInt(Item::getPrice)
                .sum() - promotionPrice;
    }
}
