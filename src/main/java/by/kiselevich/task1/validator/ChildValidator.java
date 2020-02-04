package by.kiselevich.task1.validator;

import java.math.BigDecimal;

public class ChildValidator {

    private static final int YOUNG_CHILD_MIN_AGE = 2;
    private static final int OLD_CHILD_MAX_AGE = 15;

    public boolean checkFirstName(String firstName) {
        return firstName != null;
    }

    public boolean checkLastName(String lastName) {
        return lastName != null;
    }

    public boolean checkAge(int age) {
        return age >= YOUNG_CHILD_MIN_AGE && age <= OLD_CHILD_MAX_AGE;
    }

    public boolean checkBudget(BigDecimal budget) {
        return budget != null && budget.compareTo(BigDecimal.valueOf(0)) > 0;
    }

    public boolean checkHours(int hours) {
        return hours > 0;
    }
}
