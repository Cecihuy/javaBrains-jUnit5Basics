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
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@DisplayName(value = "when running MathUtils")
public class MathUtilsTest {
    MathUtils mathUtils;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter){
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        mathUtils = new MathUtils();
    }
    @Nested
    @DisplayName(value = "add method")
    @Tag(value = "Math")
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
    @Tag(value = "Circle")
    void testComputeCircleRadius(){
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return right circle area");
    }
    @Test
    @EnabledOnOs(value = OS.WINDOWS)
    @Tag(value = "Math")
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
    @Tag(value = "Math")
    @DisplayName(value = "multiply method")
    void testMultiply(){
        System.out.println("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags());        //output in console
        testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags()); //output in console
        assertAll(
            () -> assertEquals(4, mathUtils.multiply(2, 2)),
            () -> assertEquals(0, mathUtils.multiply(2, 0)),
            () -> assertEquals(-2, mathUtils.multiply(2, -1))
        );
    }
}