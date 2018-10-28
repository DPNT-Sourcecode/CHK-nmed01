package befaster.solutions.CHK;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


/*
Our price table and offers:
+------+-------+------------------------+
| Item | Price | Special offers         |
+------+-------+------------------------+
| A    | 50    | 3A for 130, 5A for 200 |
| B    | 30    | 2B for 45              |
| C    | 20    |                        |
| D    | 15    |                        |
| E    | 40    | 2E get one B free      |
+------+-------+------------------------+
 */

public class CheckoutSolutionTest {

    private CheckoutSolution checkoutSolution;

    @Before
    public void setup() {
        checkoutSolution = new CheckoutSolution();
    }

    @Test
    public void test_R1() {


        assertThat(checkoutSolution.checkout("")).isEqualTo(0);

        assertThat(checkoutSolution.checkout("F")).isEqualTo(-1);
        assertThat(checkoutSolution.checkout("test test")).isEqualTo(-1);


        assertThat(checkoutSolution.checkout("A")).isEqualTo(50);
        assertThat(checkoutSolution.checkout("B")).isEqualTo(30);
        assertThat(checkoutSolution.checkout("C")).isEqualTo(20);
        assertThat(checkoutSolution.checkout("D")).isEqualTo(15);
        assertThat(checkoutSolution.checkout("E")).isEqualTo(40);


        assertThat(checkoutSolution.checkout("A A")).isEqualTo(100);
        assertThat(checkoutSolution.checkout("A A A")).isEqualTo(130);
        assertThat(checkoutSolution.checkout("A A A A")).isEqualTo(180);
        assertThat(checkoutSolution.checkout("AAAA")).isEqualTo(180);


        assertThat(checkoutSolution.checkout("A A A B B")).isEqualTo(175);

        assertThat(checkoutSolution.checkout("B B")).isEqualTo(45);

        assertThat(checkoutSolution.checkout("A A A A B B")).isEqualTo(225);

    }

    @Test
    public void test_R2() {


        assertThat(checkoutSolution.checkout("EE")).isEqualTo(80);
        assertThat(checkoutSolution.checkout("EEEE")).isEqualTo(160);

        assertThat(checkoutSolution.checkout("AAAAA")).isEqualTo(200);
        assertThat(checkoutSolution.checkout("AAAAA EE")).isEqualTo(280);

        assertThat(checkoutSolution.checkout("AAAAA AAAAA AAAAA")).isEqualTo(600);

        assertThat(checkoutSolution.checkout("AAAAA AAAAA AAAAA A")).isEqualTo(650);

        assertThat(checkoutSolution.checkout("AAAAA AAAAA AAAAA AA")).isEqualTo(700);

        assertThat(checkoutSolution.checkout("AAAAA AAAAA AAAAA AAA")).isEqualTo(730);

        assertThat(checkoutSolution.checkout("AAAAA AAAAA AAAAA AAAA")).isEqualTo(780);

        assertThat(checkoutSolution.checkout("AAAAA AAAAA AAAAA AAAAA")).isEqualTo(800);

        assertThat(checkoutSolution.checkout("EEB")).isEqualTo(80);

        assertThat(checkoutSolution.checkout("EEEBB")).isEqualTo(120);

        assertThat(checkoutSolution.checkout("EEEBB")).isEqualTo(120);

        "EEB"],"id":"CHK_R2_025"}, expected: 80, got: 110
            - {"method":"checkout","params":["EEEB"],"id":"CHK_R2_026"}, expected: 120, got: 150
            - {"method":"checkout","params":["EEEEBB"
    }


}
