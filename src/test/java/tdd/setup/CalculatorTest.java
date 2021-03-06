package tdd.setup;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Retro calculator")
class CalculatorTest {
    @Test
    @DisplayName("should display result after adding two positive numbers")
    void calculatorCanDoTwoPlusTwo() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(2);
        calc.pressOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressEquals();
        assertEquals("4", calc.readScreen());
    }

    @Test
    @DisplayName("should display result after multiplying two positive numbers")
    void calculatorMultiplication() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(5);
        calc.pressOperationKey("x");
        calc.pressDigitKey(2);
        calc.pressEquals();
        assertEquals("10", calc.readScreen());
    }

    @Test
    @DisplayName("should throw exception, when dividing by zero")
    void calculatorShouldThrowZeroDivisionException() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(2);
        calc.pressOperationKey("/");
        assertThrows(IllegalArgumentException.class, () -> {calc.pressDigitKey(0);});
    }

    @Test
    @DisplayName("should display result after adding a digit and decimal number")
    void calculatorCanAddDecimalNo() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(2);
        calc.pressOperationKey("+");
        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(5);
        calc.pressEquals();
        assertEquals("3.5", calc.readScreen());
    }
}
