import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MathUtilsTest {
    @Test
    void testAdd(){
        MathUtils mathUtils = new MathUtils();
        int expect = 2;
        int reality = mathUtils.add(1, 1);

        assertEquals(expect, reality, "The add method should add two numbers");
    }
    @Test
    void testComputeCircleRadius(){
        MathUtils mathUtils = new MathUtils();
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return right circle area");
    }
    @Test
    void testDivide(){
        MathUtils mathUtils = new MathUtils();        
        assertThrows(ArithmeticException.class, ()-> mathUtils.divide(1, 0), "divide by zero should throw");
    }
}
