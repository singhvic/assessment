package com.assessment;

import org.junit.Assert;
import org.junit.Test;

import static com.assessment.StringCalculator.add;
import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

    @Test
    public void addReturnsZeroWhenInputStringEmpty() {
        assertEquals(0, add(""));
    }

    @Test
    public void addReturnsNumberItselfWhenInputContainsSingleDigit() {
        assertEquals(1, add("1"));
        assertEquals(0, add("0"));
        assertEquals(11, add("11"));
    }

    @Test
    public void addReturnsSumWhenInputContainsMultipleNumbers() {
        assertEquals(6, add("1,5"));
    }

    @Test
    public void numbersCanBeSeparatedByNewline() {
        assertEquals(6, add("1\n2,3"));
    }

    @Test
    public void numbersCanBeSeparatedByCustomDelimiter() {
        assertEquals(3, add("//;\n1;2"));
    }

    @Test
    public void addThrowsExceptionIfNegativeNumbersFound() {
        RuntimeException exception = Assert.assertThrows(RuntimeException.class, () -> add("-1,-2"));
        assertEquals("negative numbers not allowed -1,-2", exception.getMessage());
    }

}
