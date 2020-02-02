package by.kiselevich.taskOOP.validator;

import java.math.BigDecimal;

public class ChildValidator {

    public boolean checkFirstName(String firstName) {
        return firstName != null;
    }

    public boolean checkLastName(String lastName) {
        return lastName != null;
    }

    public boolean checkAge(int age) {
        return age >= 2 && age < 15;
    }

    public boolean checkBudget(BigDecimal budget) {
        return budget != null && budget.compareTo(BigDecimal.valueOf(0)) > 0;
    }

    public boolean checkHours(int hours) {
        return hours > 0;
    }
}
