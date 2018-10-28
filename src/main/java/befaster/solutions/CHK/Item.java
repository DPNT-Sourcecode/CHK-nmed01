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
}
