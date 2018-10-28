package befaster.solutions.CHK;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SkuParser {

    private static List<Item> parseSkus(String skus) throws SkuParsingException {

        List<String> skuStringList = Arrays.asList(skus.split("\\s+"));

        if(isValidSkuStringList(skuStringList)) {

            throw new SkuParsingException("String contains invalid sku");
        }

        return skuStringList.stream()
                .map(skuString -> skuString.charAt(0))
                .map(SkuParser::parseSku)
                .collect(Collectors.toList());
    }

    private static boolean isValidSkuStringList(List<String> skusList) {
        return skusList.stream().anyMatch(skuString -> !isValidSkuString(skuString));
    }

    private static boolean isValidSkuString(String skuString) {
        return skuString.length() == 1 && getValidSkus().contains(skuString.charAt(0));
    }

    private static List<Character> getValidSkus() {
        return Arrays.asList('A', 'B', 'C', 'D');
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

        throw new RuntimeException("sku not recognised");
    }

}
