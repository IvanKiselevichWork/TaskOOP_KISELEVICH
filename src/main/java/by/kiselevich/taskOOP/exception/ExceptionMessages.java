package by.kiselevich.taskOOP.exception;

public enum ExceptionMessages {

    // ChildValidator messages
    INVALID_FIRST_NAME("Invalid first name"),
    INVALID_LAST_NAME("Invalid last name"),
    INVALID_AGE("Invalid age");

    private String message;

    private ExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
