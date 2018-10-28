package befaster.solutions.CHK;

import java.util.Arrays;
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
        return Arrays.asList('A', 'B', 'C', 'D', 'E');
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
            case 'E':
                return new Item('E', 40);
        }

        throw new SkuParsingException("sku not recognised");
    }

}
