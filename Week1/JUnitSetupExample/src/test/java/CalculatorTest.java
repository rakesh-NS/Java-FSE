package Week1.JUnitSetupExample.src.test;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testAdd() {

        Calculator calculator = new Calculator();

        int result = calculator.add(10,20);

        assertEquals(30,result);
    }

}