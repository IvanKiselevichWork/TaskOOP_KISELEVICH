package by.kiselevich.task1.validator;

import by.kiselevich.task1.entity.toy.ToySize;
import by.kiselevich.task1.entity.toy.ToyType;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ToyValidatorTest extends Assert {

    private ToyValidator toyValidator = new ToyValidator();

    @Test
    public void isToyTypeNotNullTestPositive() {
        ToyType toyType = ToyType.BALL;
        assertTrue(toyValidator.isToyTypeNotNull(toyType));
    }

    @Test
    public void isToyTypeNotNullTestNegative() {
        ToyType toyType = null;
        assertFalse(toyValidator.isToyTypeNotNull(toyType));
    }

    @Test
    public void isToySizeNotNullTestPositive() {
        ToySize toySize = ToySize.BIG;
        assertTrue(toyValidator.isToySizeNotNull(toySize));
    }

    @Test
    public void isToySizeNotNullTestNegative() {
        ToySize toySize = null;
        assertFalse(toyValidator.isToySizeNotNull(toySize));
    }

    @Test
    public void isCostNotNullAndPositiveTestPositive() {
        BigDecimal cost = BigDecimal.valueOf(12);
        assertTrue(toyValidator.isCostNotNullAndPositive(cost));
    }

    @Test
    public void isCostNotNullAndPositiveTestNegative1() {
        BigDecimal cost = null;
        assertFalse(toyValidator.isCostNotNullAndPositive(cost));
    }

    @Test
    public void isCostNotNullAndPositiveTestNegative2() {
        BigDecimal cost = BigDecimal.valueOf(0);
        assertFalse(toyValidator.isCostNotNullAndPositive(cost));
    }
}
