package befaster.solutions.CHK;

public class SpecialOffer {

    private final int quantity;
    private final Item item;
    private final int promotionPrice;

    public SpecialOffer(int quantity, Item item, int promotionPrice) {
        this.quantity = quantity;
        this.item = item;
        this.promotionPrice = promotionPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public Item getItem() {
        return item;
    }

    public int getPromotionPrice() {
        return promotionPrice;
    }
}
