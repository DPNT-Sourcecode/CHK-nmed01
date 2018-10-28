package befaster.solutions.CHK;

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
}
