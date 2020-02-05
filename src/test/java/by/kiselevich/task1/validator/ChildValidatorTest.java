package by.kiselevich.task1.validator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ChildValidatorTest extends Assert {

    private ChildValidator childValidator = new ChildValidator();

    @Test
    public void isNameTestPositive() {
        String name = "Name";
        assertTrue(childValidator.isNameAndNotNull(name));
    }

    @Test
    public void isNameTestNegative1() {
        assertFalse(childValidator.isNameAndNotNull(null));
    }

    @Test
    public void isNameTestNegative2() {
        String name = "1";
        assertFalse(childValidator.isNameAndNotNull(name));
    }

    @Test
    public void isAgeChildishTestPositive() {
        int age = 5;
        assertTrue(childValidator.isAgeChildish(age));
    }

    @Test
    public void isAgeChildishTestNegative1() {
        int age = 16;
        assertFalse(childValidator.isAgeChildish(age));
    }

    @Test
    public void isAgeChildishTestNegative2() {
        int age = 1;
        assertFalse(childValidator.isAgeChildish(age));
    }

    @Test
    public void isBudgetNotNullAndPositiveTestPositive() {
        BigDecimal budget = BigDecimal.valueOf(20);
        assertTrue(childValidator.isBudgetNotNullAndPositive(budget));
    }

    @Test
    public void isBudgetNotNullAndPositiveTestPositiveTestNegative1() {
        BigDecimal budget = null;
        assertFalse(childValidator.isBudgetNotNullAndPositive(budget));
    }

    @Test
    public void isBudgetNotNullAndPositiveTestPositiveTestNegative2() {
        BigDecimal budget = BigDecimal.valueOf(-20);
        assertFalse(childValidator.isBudgetNotNullAndPositive(budget));
    }

    @Test
    public void isHoursPositiveTestPositive() {
        int hours = 5;
        assertTrue(childValidator.isHoursPositive(hours));
    }

    @Test
    public void isHoursPositiveTestNegative() {
        int hours = 0;
        assertFalse(childValidator.isHoursPositive(hours));
    }
}
