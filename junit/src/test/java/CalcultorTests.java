import org.blitmatthew.Calculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalcultorTests {

    private static Calculator calculator;

    @BeforeAll
    public static void setUp() {
        calculator = new Calculator();
    }

    @BeforeEach
    public void setUp2() {
        calculator = new Calculator();
    }

    @AfterEach
    public void tearDown() {
        calculator.resetCount();
    }

    @AfterAll
    public static void tearDown2() {
        calculator = null;
    }

    @Test
    public void testAdd() {
        assertEquals(15, calculator.add(7, 8));
    }

    @Test
    public void testSubtract() {
        assertEquals(50, calculator.subtract(103,53));
    }

    @Test
    public void testDivisionException() {
        Throwable throwable = assertThrows(Exception.class, () -> calculator.divide(5, 0));
        assertEquals("Cannot divide by zero!", throwable.getMessage());
    }

    @Test
    public void testCalCount() {
        Calculator cal = new Calculator();
        Calculator cal2 = new Calculator();

        assertEquals(3, Calculator.getCalCount());
    }
}
