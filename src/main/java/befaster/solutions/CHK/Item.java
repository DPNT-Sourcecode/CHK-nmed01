package befaster.solutions.CHK;

import java.util.Comparator;

public class Item {

    private final char code;
    private final int price;


    public Item(char code, int price) {
        this.code = code;
        this.price = price;
    }

    public char getCode() {
        return code;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (code != item.code) return false;
        return price == item.price;
    }

    @Override
    public int hashCode() {
        int result = (int) code;
        result = 31 * result + price;
        return result;
    }

    public static class PriceComparator implements Comparator<Item> {

        @Override
        public int compare(Item o1, Item o2) {
            return Integer.compare(o1.getPrice(), o2.getPrice());
        }
    }
}
