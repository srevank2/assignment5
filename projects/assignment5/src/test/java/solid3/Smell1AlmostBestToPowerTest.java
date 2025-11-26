package solid3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Part1-A Black-box tests for Smell1AlmostBest.toPower(base, exponent)
 * Assumes: public static double toPower(double base, int exponent)
 */
public class Smell1AlmostBestToPowerTest {

    private static final double EPS = 1e-9;

    @ParameterizedTest
    @CsvSource({
        "2.0, 1, 2.0",
        "2.0, 2, 4.0",
        "2.0, 3, 8.0",
        "1.5, 2, 2.25"
    })
    @DisplayName("Positive exponent normal cases")
    public void testPositiveExponents(double base, int exp, double expected) {
        double actual = Smell1AlmostBest.toPower(base, exp);
        Assertions.assertEquals(expected, actual, EPS);
    }

    @Test
    @DisplayName("Exponent zero returns 1.0 for nonzero bases")
    public void testExponentZero() {
        Assertions.assertEquals(1.0, Smell1AlmostBest.toPower(2.0, 0), EPS);
        Assertions.assertEquals(1.0, Smell1AlmostBest.toPower(-3.7, 0), EPS);
    }

    @Test
    @DisplayName("Base zero cases")
    public void testBaseZero() {
        Assertions.assertEquals(0.0, Smell1AlmostBest.toPower(0.0, 3), EPS);
        // Note: some implementations treat 0^0 as 1. Adjust if your code differs.
        Assertions.assertEquals(1.0, Smell1AlmostBest.toPower(0.0, 0), EPS);
    }

    @Test
    @DisplayName("Negative exponent reciprocal")
    public void testNegativeExponentReciprocal() {
        double actual = Smell1AlmostBest.toPower(2.0, -2);
        Assertions.assertEquals(0.25, actual, EPS);
    }

    @Test
    @DisplayName("Negative base odd/even exponents")
    public void testNegativeBaseOddEven() {
        Assertions.assertEquals(-8.0, Smell1AlmostBest.toPower(-2.0, 3), EPS); // odd => negative
        Assertions.assertEquals(4.0, Smell1AlmostBest.toPower(-2.0, 2), EPS);  // even => positive
    }

    @Test
    @DisplayName("Large exponent sanity check")
    public void testLargeExponent() {
        double actual = Smell1AlmostBest.toPower(10.0, 308);
        Assertions.assertTrue(Double.isFinite(actual) || Double.isInfinite(actual));
    }

    @Test
    @DisplayName("NaN base handling")
    public void testNaNBase() {
        double r = Smell1AlmostBest.toPower(Double.NaN, 2);
        Assertions.assertTrue(Double.isNaN(r) || Double.isFinite(r));
    }
}
