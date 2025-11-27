package solid3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;

import java.lang.reflect.Method;

@DisplayName("Smell1AlmostBest.toPower tests (reflection, instructor API)")
public class Smell1AlmostBestToPowerTest {

    
    private int invokeToPower(int base, int exp) throws Exception {
        Method m = Smell1AlmostBest.class.getDeclaredMethod("toPower", int.class, int.class);
        m.setAccessible(true);
        Object res = m.invoke(null, base, exp);
        return (Integer) res;
    }

    @Test
    @DisplayName("Positive exponent normal cases")
    public void testPositiveExponent() throws Exception {
        Assertions.assertEquals(2, invokeToPower(2, 1));
        Assertions.assertEquals(4, invokeToPower(2, 2));
        Assertions.assertEquals(8, invokeToPower(2, 3));
        Assertions.assertEquals(9, invokeToPower(3, 2));
    }

    @Test
    @DisplayName("Exponent zero returns 1 for any base")
    public void testZeroExponent() throws Exception {
        Assertions.assertEquals(1, invokeToPower(2, 0));
        Assertions.assertEquals(1, invokeToPower(-3, 0));
        Assertions.assertEquals(1, invokeToPower(0, 0));
    }

    @Test
    @DisplayName("Base zero cases")
    public void testBaseZero() throws Exception {
        Assertions.assertEquals(0, invokeToPower(0, 3));
        Assertions.assertEquals(1, invokeToPower(0, 0));
    }

    @Test
    @DisplayName("Negative exponent handling (implementation-defined)")
    public void testNegativeExponent() throws Exception {
        Assertions.assertEquals(1, invokeToPower(2, -2));
    }

    @Test
    @DisplayName("Negative base odd/even exponents")
    public void testNegativeBaseOddEven() throws Exception {
        Assertions.assertEquals(-8, invokeToPower(-2, 3));  
        Assertions.assertEquals(4, invokeToPower(-2, 2));   
    }

    @Test
    @DisplayName("Large exponent sanity check")
    public void testLargeExponent() throws Exception {
        int r = invokeToPower(10, 9); 
        Assertions.assertTrue(r == 1000000000);
    }
}
