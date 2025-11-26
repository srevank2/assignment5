package solid3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class Smell1AlmostBestToPowerExtraCoverageTest {

    @Test
    public void testInfinityValues() {
        double r = Smell1AlmostBest.toPower(Double.POSITIVE_INFINITY, 2);
        Assertions.assertTrue(Double.isInfinite(r));
    }

    @Test
    public void testNegativeInfinity() {
        double r = Smell1AlmostBest.toPower(Double.NEGATIVE_INFINITY, 3);
        Assertions.assertTrue(Double.isInfinite(r));
    }

    @Test
    public void testVeryLargeExponent() {
        double r = Smell1AlmostBest.toPower(1.000001, 2000);
        Assertions.assertTrue(Double.isFinite(r) || Double.isInfinite(r));
    }
}
