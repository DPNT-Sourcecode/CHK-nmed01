package befaster.solutions.CHK;

import java.util.Arrays;
import java.util.List;

public class SkuParser {

    private static List<Item> parseSkus(String skus) throws SkuParsingException {

        List<String> skusList = Arrays.asList(skus.split("\\s+"));

        if(skusList.isEmpty()) {
            throw new SkuParsingException("")
        }

        if(skusList.stream().anyMatch(skuString -> !isValidSkuString(skuString))) {

            throw new SkuParsingException("String contains invalid sku");
        }


    }

    private static boolean isValidSkuString(String skuString) {
        return skuString.length() == 1 && getValidSkus().contains(skuString.charAt(0));
    }

    private static List<Character> getValidSkus() {
        return Arrays.asList('A', 'B', 'C', 'D');
    }

    private static Item parseSku(char sku) throws SkuParsingException {
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

        throw new SkuParsingException("sku not recognised");
    }

}
