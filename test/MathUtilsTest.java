import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@DisplayName(value = "when running MathUtils")
public class MathUtilsTest {
    MathUtils mathUtils;
    
    @BeforeEach
    void init(){
        mathUtils = new MathUtils();
    }
    @Nested
    @DisplayName(value = "add method")
    class AddTest{
        @Test
        @DisplayName(value = "when adding two positive numbers")
        void testAddPositive(){
            assertEquals(2, mathUtils.add(1, 1), "should return the right sum");
        }
        @Test
        @DisplayName(value = "when adding two negative numbers")
        void testAddNegative(){
            int expect = -2;
            int reality = mathUtils.add(-1, -1);
            assertEquals(expect, reality, () -> "should return sum " + expect + " but returned " + reality);
        }
    }
    @RepeatedTest(value = 3)
    void testComputeCircleRadius(RepetitionInfo repetitionInfo){    //this argument is additional option
        repetitionInfo.getCurrentRepetition();      //this code is optional is additional option
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
