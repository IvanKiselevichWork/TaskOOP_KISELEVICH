package by.kiselevich.taskOOP.validator;

public class ToyValidator {

    public boolean checkFirstName(String firstName) {
        return firstName != null;
    }

    public boolean checkLastName(String lastName) {
        return lastName != null;
    }

    public boolean checkAge(int age) {
        return age >= 2 && age < 15;
    }
}
