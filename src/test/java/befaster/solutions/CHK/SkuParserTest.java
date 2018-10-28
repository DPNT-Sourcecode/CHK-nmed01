package befaster.solutions.CHK;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.fail;

public class SkuParserTest {

    @Test
    public void testValid() {

        String input = "A A A A B B C D A";

        try {
            List<Item> items = SkuParser.parseSkus(input);

            items.

        } catch (SkuParsingException e) {
            e.printStackTrace();
            fail();
        }

    }

}
