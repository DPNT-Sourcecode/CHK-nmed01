package befaster.solutions.CHK;

import java.util.List;
import java.util.stream.Collectors;

public class SkuParser {

    public static List<Item> parseSkus(String input) {

        String skuString = cleanInput(input);

        if (!isValidInput(skuString)) {

            throw new SkuParsingException("String contains invalid sku");
        }

        return skuString.chars().mapToObj(c -> (char) c)
                .map(SkuParser::parseSku)
                .collect(Collectors.toList());
    }

    public static boolean isValidInput(String input) {
        return isValidSkuString(cleanInput(input));
    }

    private static String cleanInput(String input) {
        return input.replaceAll("\\s+", "");
    }

    private static boolean isValidSkuString(String skuString) {

        return skuString.chars().mapToObj(c -> (char) c).allMatch(character -> getValidSkus().contains(character));
    }

    private static List<Character> getValidSkus() {
        return Items.allItems.stream().map(Item::getCode).collect(Collectors.toList());
    }

    private static Item parseSku(char sku) {
        return Items.allItems.stream().filter(item -> item.getCode() == sku).findFirst().orElseThrow(
                () -> new SkuParsingException("sku not recognised")
        );

    }

}
