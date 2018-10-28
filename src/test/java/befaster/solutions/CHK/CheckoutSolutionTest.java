package befaster.solutions.CHK;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CheckoutSolutionTest {

    private CheckoutSolution checkoutSolution;

    @Before
    public void setup() {
        checkoutSolution = new CheckoutSolution();
    }

    @Test
    public void test_R1() {


        assertThat(checkoutSolution.checkout("")).isEqualTo(0);

        assertThat(checkoutSolution.checkout("zza")).isEqualTo(-1);
        assertThat(checkoutSolution.checkout("test test")).isEqualTo(-1);


        assertThat(checkoutSolution.checkout("A")).isEqualTo(50);
        assertThat(checkoutSolution.checkout("B")).isEqualTo(30);
        assertThat(checkoutSolution.checkout("C")).isEqualTo(20);
        assertThat(checkoutSolution.checkout("D")).isEqualTo(15);
        assertThat(checkoutSolution.checkout("E")).isEqualTo(40);
        assertThat(checkoutSolution.checkout("F")).isEqualTo(10);


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

        assertThat(checkoutSolution.checkout("EEEB")).isEqualTo(120);

        assertThat(checkoutSolution.checkout("EEEEBB")).isEqualTo(160);

        assertThat(checkoutSolution.checkout("EEEEBBB")).isEqualTo(190);
        assertThat(checkoutSolution.checkout("EEEEBBBB")).isEqualTo(205);
        assertThat(checkoutSolution.checkout("EEEEEBBBBB")).isEqualTo(275);


    }

    @Test
    public void test_R3() {

        assertThat(checkoutSolution.checkout("F")).isEqualTo(10);
        assertThat(checkoutSolution.checkout("FF")).isEqualTo(20);
        assertThat(checkoutSolution.checkout("FFF")).isEqualTo(20);
        assertThat(checkoutSolution.checkout("FFFF")).isEqualTo(30);
        assertThat(checkoutSolution.checkout("FFFFF")).isEqualTo(40);
        assertThat(checkoutSolution.checkout("FFFFFF")).isEqualTo(40);
        assertThat(checkoutSolution.checkout("FFFFFFF")).isEqualTo(50);
        assertThat(checkoutSolution.checkout("FFFFFFFA")).isEqualTo(100);
        assertThat(checkoutSolution.checkout("FFFFFFFAA")).isEqualTo(150);
        assertThat(checkoutSolution.checkout("FFFFFFFAAA")).isEqualTo(180);

    }


    @Test
    public void test_R4() {

        assertThat(checkoutSolution.checkout("KK")).isEqualTo(120);
        assertThat(checkoutSolution.checkout("KKK")).isEqualTo(190);
        assertThat(checkoutSolution.checkout("KKKK")).isEqualTo(240);

    }

    @Test
    public void test_R5() {

        assertThat(checkoutSolution.checkout("STXYZ")).isEqualTo(82);
        assertThat(checkoutSolution.checkout("STXYZAAA")).isEqualTo(212);

    }

}
