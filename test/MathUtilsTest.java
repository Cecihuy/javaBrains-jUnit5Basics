import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MathUtilsTest {
    MathUtils mathUtils;
    
    @BeforeEach
    void init(){
        mathUtils = new MathUtils();
    }
    @Test
    void testAdd(){        
        int expect = 2;
        int reality = mathUtils.add(1, 1);
        assertEquals(expect, reality, "The add method should add two numbers");
    }
    @Test
    void testComputeCircleRadius(){        
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return right circle area");
    }
    @Test
    void testDivide(){        
        assertThrows(ArithmeticException.class, ()-> mathUtils.divide(1, 0), "divide by zero should throw");
    }
}
