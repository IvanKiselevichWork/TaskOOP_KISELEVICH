package by.kiselevich.task1.validator;

import by.kiselevich.task1.entity.toy.ToySize;
import org.junit.Assert;
import org.junit.Test;

public class StringValidatorTest extends Assert {

    StringValidator stringValidator = new StringValidator();

    @Test
    public void isStringParsableToBigDecimalTestPositive() {
        String string = "34";
        assertTrue(stringValidator.isStringParsableToBigDecimal(string));
    }

    @Test
    public void isStringParsableToBigDecimalTestNegative() {
        String string = "qwqw";
        assertFalse(stringValidator.isStringParsableToBigDecimal(string));
    }

    @Test
    public void isStringParsableToIntTestPositive() {
        String string = "34";
        assertTrue(stringValidator.isStringParsableToInt(string));
    }

    @Test
    public void isStringParsableToIntTestNegative() {
        String string = "qwqw";
        assertFalse(stringValidator.isStringParsableToInt(string));
    }

    @Test
    public void isStringParsableToEnumTestPositive() {
        String string = "BIG";
        assertTrue(stringValidator.isStringParsableToEnum(ToySize.class, string));
    }

    @Test
    public void isStringParsableToEnumTestNegative() {
        String string = "BIG1212";
        assertFalse(stringValidator.isStringParsableToEnum(ToySize.class, string));
    }
}
