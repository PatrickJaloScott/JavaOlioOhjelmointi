import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CalculatorTest {

    private static Calculator c;

    @BeforeAll
    static void setupBeforeClass() {
        c = new Calculator();
    }
    @BeforeEach
    void setup() {
        c.clear();
    }

    @Test
    void testClear() {
        System.out.println("Clear");
        c.clear();
        assertEquals(0, c.getResult(), "Clearing was not successful");
    }

    @Test
    void testAdd() {
        System.out.println("Add");
        c.add(2);
        assertEquals(2, c.getResult(), "Adding was not successful");
        c.add(2);
        assertEquals(4, c.getResult(), "Adding was not successful");
    }

    @Test
    void testSub() {
        System.out.println("Sub");
        c.add(10);
        c.sub(2);
        assertEquals(8, c.getResult(), "Subtracting was not successful");
    }

    @Test
    void testMul() {
        System.out.println("Mul");
        c.add(10);
        c.mul(2);
        assertEquals(20, c.getResult(), "Multiplying was not successful");
    }

    @Test
    void testDiv() {
        System.out.println("Div");
        c.add(10);
        c.div(2);
        assertEquals(5, c.getResult(), "Dividing was not successful");
    }

    @Test
    void testGetResult() {
        System.out.println("GetResult");
        c.clear();
        assertEquals(0, c.getResult(), "Getting result was not successful");
        c.add(10);
        assertEquals(10, c.getResult(), "Getting result was not successful");
    }
}