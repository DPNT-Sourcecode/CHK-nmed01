package befaster.solutions.CHK;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

/*
+------+-------+----------------+
| Item | Price | Special offers |
+------+-------+----------------+
| A    | 50    | 3A for 130     |
| B    | 30    | 2B for 45      |
| C    | 20    |                |
| D    | 15    |                |
+------+-------+----------------+
 */
public class CheckoutSolution {
    public Integer checkout(String skus) {



    }

    private static List<Item> parseSkus(String skus) {

        List<String> skusList = Arrays.asList(skus.split("\\s+"));

        skusList.stream().filter(skuString -> {
            return skuString.length() > 1
        })


    }


    private static Item parseSku(char sku) {
        switch (sku) {
            case 'A':
                return new Item('A', 50);
            case 'B':
                return new Item('B', 30);
            case 'C':
                return new Item('C', 20);
            case 'D':
                return new Item('D', 15);
        }
    }

}
