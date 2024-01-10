import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class MathUtilsTest {
    MathUtils mathUtils;
    
    @BeforeAll
    void beforeAllInit(){
        System.out.println("This needs to run before all");
    }
    @BeforeEach
    void init(){
        mathUtils = new MathUtils();
    }
    @AfterEach
    void cleanUp(){
        System.out.println("Cleaning up...");
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
