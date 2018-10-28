package befaster.solutions.CHK;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


/*
Our price table and offers:
+------+-------+----------------+
| Item | Price | Special offers |
+------+-------+----------------+
| A    | 50    | 3A for 130     |
| B    | 30    | 2B for 45      |
| C    | 20    |                |
| D    | 15    |                |
+------+-------+----------------+
 */

public class CheckoutSolutionTest {

    private CheckoutSolution checkoutSolution;

    @Before
    public void setup() {
        checkoutSolution = new CheckoutSolution();
    }

    @Test
    public void test() {


        assertThat(checkoutSolution.checkout("")).isEqualTo(0);

        assertThat(checkoutSolution.checkout("E")).isEqualTo(-1);
        assertThat(checkoutSolution.checkout("test test")).isEqualTo(-1);


        assertThat(checkoutSolution.checkout("A")).isEqualTo(50);
        assertThat(checkoutSolution.checkout("B")).isEqualTo(30);
        assertThat(checkoutSolution.checkout("C")).isEqualTo(20);
        assertThat(checkoutSolution.checkout("D")).isEqualTo(15);


        assertThat(checkoutSolution.checkout("A A")).isEqualTo(100);
        assertThat(checkoutSolution.checkout("A A A")).isEqualTo(130);
        assertThat(checkoutSolution.checkout("A A A A")).isEqualTo(180);


        assertThat(checkoutSolution.checkout("A A A B B")).isEqualTo(175);

        assertThat(checkoutSolution.checkout("B B")).isEqualTo(45);

        assertThat(checkoutSolution.checkout("A A A A B B")).isEqualTo(225);

    }


}
