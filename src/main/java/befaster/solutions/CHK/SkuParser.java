package befaster.solutions.CHK;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SkuParser {

    public static List<Item> parseSkus(String input) {

        List<String> skuStringList = splitInput(input);

        if(!isValidSkuList(skuStringList)) {

            throw new SkuParsingException("String contains invalid sku");
        }

        return skuStringList.stream()
                .map(skuString -> skuString.charAt(0))
                .map(SkuParser::parseSku)
                .collect(Collectors.toList());
    }

    public static boolean isValidInput(String input) {
        return isValidSkuList(splitInput(input));
    }

    private static List<String> splitInput(String skus) {

        if(StringUtils.isBlank(skus)) {
            return new ArrayList<>();
        }

        return Arrays.asList(skus.split("\\s+"));
    }

    private static boolean isValidSkuList(List<String> skuList) {
        return skuList.stream().allMatch(SkuParser::isValidSkuString);
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

        throw new SkuParsingException("sku not recognised");
    }

}
