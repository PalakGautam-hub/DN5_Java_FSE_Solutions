package com.palak.testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// JUnit Exercise 3: Assertions in JUnit
public class AssertionsTest {
    @Test
    public void testAssertions() {
        Calculator calculator = new Calculator();

        assertEquals(5, calculator.add(2, 3));
        assertTrue(calculator.multiply(3, 4) == 12);
        assertFalse(calculator.subtract(10, 5) == 3);
        assertNull(null);
        assertNotNull(new Calculator());

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.divide(10, 0)
        );
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
