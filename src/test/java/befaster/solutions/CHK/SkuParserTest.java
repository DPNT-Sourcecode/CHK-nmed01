package befaster.solutions.CHK;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

public class SkuParserTest {

    @Test
    public void testValid() {

        String input = "A A A A B B C D A";
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


        assertThat(SkuParser.isValidInput(input)).isTrue();
        assertThat(SkuParser.parseSkus(input)).containsExactlyInAnyOrderElementsOf(expectedItems);



    }

}
