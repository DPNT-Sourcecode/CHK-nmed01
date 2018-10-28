package befaster.solutions.CHK;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SkuParserTest {

    @Test
    public void testValid() {

        String input1 = "A A A A B B C D A";
        String input2 = "AAAABBCDA";
        String input3 = "AAA ABB CDA";

        List<Item> expectedItems = Arrays.asList(
                new Item('A', 50),
                new Item('A', 50),
                new Item('A', 50),
                new Item('A', 50),
                new Item('B', 30),
                new Item('B', 30),
                new Item('C', 20),
                new Item('D', 15),
                new Item('A', 50)
        );


        assertThat(SkuParser.isValidInput(input1)).isTrue();
        assertThat(SkuParser.parseSkus(input1)).containsExactlyInAnyOrderElementsOf(expectedItems);

        assertThat(SkuParser.isValidInput(input2)).isTrue();
        assertThat(SkuParser.parseSkus(input2)).containsExactlyInAnyOrderElementsOf(expectedItems);

        assertThat(SkuParser.isValidInput(input3)).isTrue();
        assertThat(SkuParser.parseSkus(input3)).containsExactlyInAnyOrderElementsOf(expectedItems);

    }

    @Test
    public void testInvalid() {

        String input1 = "A A A A B B C D Aa";
        String input2 = "A A A A B B C D 1";
        String input3 = "A A A A E B B C D";
        String input4 = "012A";

        assertThat(SkuParser.isValidInput(input1)).isFalse();
        assertThat(SkuParser.isValidInput(input2)).isFalse();
        assertThat(SkuParser.isValidInput(input3)).isFalse();
        assertThat(SkuParser.isValidInput(input4)).isFalse();

    }

    @Test
    public void testEmpty() {

        String input1 = "";
        String input2 = " ";

        assertThat(SkuParser.isValidInput(input1)).isTrue();
        assertThat(SkuParser.parseSkus(input1)).isEmpty();
        assertThat(SkuParser.isValidInput(input2)).isTrue();
        assertThat(SkuParser.parseSkus(input2)).isEmpty();



    }

}
