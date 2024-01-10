import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class MathUtilsTest {
    MathUtils mathUtils;
    
    @BeforeEach
    void init(){
        mathUtils = new MathUtils();
    }
    @Test
    @DisplayName(value = "testing add method")
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
    @EnabledOnOs(value = OS.WINDOWS)
    void testDivide(){
        boolean isServerUp = false;
        assumeTrue(isServerUp);
        assertThrows(ArithmeticException.class, ()-> mathUtils.divide(1, 0), "divide by zero should throw");
    }
    @Test
    @Disabled
    @DisplayName(value = "TDD method. Should not run")
    void testDisabled(){        
        fail("No mather what, this test is fail");
    }
    @Test
    @DisplayName(value = "multiply method")
    void testMultiply(){
        assertAll(
            () -> assertEquals(4, mathUtils.multiply(2, 2)),
            () -> assertEquals(0, mathUtils.multiply(2, 0)),
            () -> assertEquals(-2, mathUtils.multiply(2, -1))
        );
    }
}
