package by.kiselevich.task1.validator;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChildValidator {

    private static final int YOUNG_CHILD_MIN_AGE = 2;
    private static final int OLD_CHILD_MAX_AGE = 15;

    private static final String NAME_REGEX = "[a-zA-Z\\._\\-]{2,30}";

    public boolean isName(String firstName) {
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(firstName);
        return matcher.matches();
    }

    public boolean isAgeChildish(int age) {
        return age >= YOUNG_CHILD_MIN_AGE && age <= OLD_CHILD_MAX_AGE;
    }

    public boolean isBudgetNotNullAndPositive(BigDecimal budget) {
        return budget != null && budget.compareTo(BigDecimal.valueOf(0)) > 0;
    }

    public boolean isHoursPositive(int hours) {
        return hours > 0;
    }
}
