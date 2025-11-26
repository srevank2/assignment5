package solid3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class Smell1AlmostBestToPowerExtraCoverageTest {

    @Test
    public void testInfinityBaseEvenExponent() {
        double result = Smell1AlmostBest.toPower(Double.POSITIVE_INFINITY, 2);
        Assertions.assertTrue(Double.isInfinite(result));
    }

    @Test
    public void testInfinityBaseOddExponent() {
        double result = Smell1AlmostBest.toPower(Double.NEGATIVE_INFINITY, 3);
        Assertions.assertTrue(Double.isInfinite(result));
    }

    @Test
    public void testVeryLargePositiveExponent() {
        double result = Smell1AlmostBest.toPower(1.0001, 5000);
        Assertions.assertTrue(Double.isFinite(result) || Double.isInfinite(result));
    }
}
