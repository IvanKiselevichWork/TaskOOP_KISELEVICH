package by.kiselevich.taskOOP.validator;

import by.kiselevich.taskOOP.exception.ChildException;

import static by.kiselevich.taskOOP.exception.ExceptionMessages.*;

public class ChildValidator {

    public void checkFirstName(String firstName) throws ChildException {
        if (firstName == null) {
            throw new ChildException(INVALID_FIRST_NAME.getMessage());
        }
    }

    public void checkLastName(String lastName) throws ChildException {
        if (lastName == null) {
            throw new ChildException(INVALID_LAST_NAME.getMessage());
        }
    }

    public void checkAge(int age) throws ChildException {
        if (age < 2 || age >= 15) {
            throw new ChildException(INVALID_AGE.getMessage());
        }
    }
}
