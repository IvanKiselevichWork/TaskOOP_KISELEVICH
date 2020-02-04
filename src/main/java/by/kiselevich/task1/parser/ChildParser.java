package by.kiselevich.task1.parser;

import by.kiselevich.task1.entity.child.Child;
import by.kiselevich.task1.exception.ChildParseException;
import by.kiselevich.task1.validator.ChildValidator;
import by.kiselevich.task1.validator.StringValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

public class ChildParser {

    private static final Logger LOGGER = LogManager.getLogger(ChildParser.class);
    private static final String DELIMITER = ";";
    private static final int DATA_ARRAY_SIZE = 5;
    private static final int FIRST_NAME_INDEX = 0;
    private static final int LAST_NAME_INDEX = 1;
    private static final int AGE_INDEX = 2;
    private static final int BUDGET_INDEX = 3;
    private static final int HOURS_INDEX = 4;

    private ChildValidator childValidator;
    private StringParser stringParser;
    private StringValidator stringValidator;

    public ChildParser() {
        childValidator = new ChildValidator();
        stringParser = new StringParser();
        stringValidator = new StringValidator();
    }

    public Child parseChildFromString(String string) throws ChildParseException {
        String[] childArray = string.split(DELIMITER);
        if (childArray.length != DATA_ARRAY_SIZE) {
            throw new ChildParseException();
        }

        String firstName = childArray[FIRST_NAME_INDEX];

        String lastName = childArray[LAST_NAME_INDEX];

        int age;
        if (!stringValidator.isStringParsableToInt(childArray[AGE_INDEX])) {
            throw new ChildParseException();
        }
        age = stringParser.parseStringToInt(childArray[AGE_INDEX]);

        BigDecimal budget;
        if (!stringValidator.isStringParsableToBigDecimal(childArray[BUDGET_INDEX])) {
            throw new ChildParseException();
        }
        budget = stringParser.parseStringToBigDecimal(childArray[BUDGET_INDEX]);

        int hours;
        if (!stringValidator.isStringParsableToInt(childArray[HOURS_INDEX])) {
            throw new ChildParseException();

        }
        hours = stringParser.parseStringToInt(childArray[HOURS_INDEX]);

        if (childValidator.isName(firstName)
                && childValidator.isName(lastName)
                && childValidator.isAgeChildish(age)
                && childValidator.isBudgetNotNullAndPositive(budget)
                && childValidator.isHoursPositive(hours)) {

            LOGGER.info("Child parsed");
            return new Child.Builder()
                    .firstName(firstName)
                    .lastName(lastName)
                    .age(age)
                    .budget(budget)
                    .hours(hours)
                    .build();
        } else {
            throw new ChildParseException();
        }
    }
}
