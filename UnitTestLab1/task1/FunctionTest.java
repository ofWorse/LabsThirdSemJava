package task1;

import org.junit.jupiter.api.Test;
import task1.Function;

import static org.junit.jupiter.api.Assertions.*;

public class FunctionTest extends Function {
    private double result;
    private double[] variables = {432, 1, 999, -0.34, 324, 56, 2_000_000, -2_000_000};

    @Test
    public void assertForInfinityTest() {
        result = Func(0, 0);
        boolean infinity = true;
        assertEquals(infinity, Double.isInfinite(result));
    }

    @Test
    public void funcTest() {
        boolean notInf = false;
        for(int i = 0; i < variables.length; i++) {
            result = Func(variables[i], variables[i]);
            assertEquals(notInf, Double.isInfinite(result));
        }
    }
}
