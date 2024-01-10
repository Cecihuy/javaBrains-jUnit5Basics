import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MathUtilsTest {
    MathUtils mathUtils;
    
    @BeforeEach
    void init(){
        mathUtils = new MathUtils();
    }
    @Test
    @DisplayName("Testing add method")
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
    @Test
    @Disabled
    @DisplayName("TDD method. Should not run")
    void testDisabled(){        
        fail("No mather what, this test is fail");
    }
}
