package befaster.solutions.CHK;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SkuParserTest {

    @Test
    public void testValid() {

        String input = "A A A A B B C D A";

        assertThat(SkuParser.isValidInput(input)).isTrue();

    }

}
