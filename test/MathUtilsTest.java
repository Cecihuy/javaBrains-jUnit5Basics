import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MathUtilsTest {
    @Test
    void test(){
        MathUtils mathUtils = new MathUtils();
        int expect = 1;
        int reality = mathUtils.add(1, 1);

        assertEquals(expect, reality, "The add method should add two numbers");
    }
}
