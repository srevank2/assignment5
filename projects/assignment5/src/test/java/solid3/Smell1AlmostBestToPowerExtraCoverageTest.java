package solid3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

public class Smell1AlmostBestToPowerExtraCoverageTest {

    private int invokeToPower(int base, int exp) throws Exception {
        Method m = Smell1AlmostBest.class.getDeclaredMethod("toPower", int.class, int.class);
        m.setAccessible(true);
        return (Integer) m.invoke(null, base, exp);
    }

    @Test
    public void testCachePopulation() throws Exception {
       
        int v = invokeToPower(3, 4);
        Assertions.assertEquals(81, v);

        
        Field cacheField = Smell1AlmostBest.class.getDeclaredField("__cache");
        cacheField.setAccessible(true);
        Object raw = cacheField.get(null);
        Assertions.assertTrue(raw instanceof Map);

        @SuppressWarnings("unchecked")
        Map<Integer, Map<Integer, Integer>> cache = (Map<Integer, Map<Integer, Integer>>) raw;
        Assertions.assertTrue(cache.containsKey(3));
        Assertions.assertTrue(cache.get(3).containsKey(4));
        Assertions.assertEquals(Integer.valueOf(81), cache.get(3).get(4));
    }

    @Test
    public void testMultiplePowersCaching() throws Exception {
        
        int a = invokeToPower(5, 2);
        int b = invokeToPower(5, 3);
        Assertions.assertEquals(25, a);
        Assertions.assertEquals(125, b);
    }

    @Test
    public void testPowOne() throws Exception {
        Assertions.assertEquals(7, invokeToPower(7, 1));
    }
}
