import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MathUtilsTest {
    @Test
    void test(){
        MathUtils mathUtils = new MathUtils();
        int expect = 2;
        int reality = mathUtils.add(1, 1);

        assertEquals(expect, reality);
    }
}
