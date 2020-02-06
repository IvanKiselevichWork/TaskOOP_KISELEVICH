package by.kiselevich.task1.exception;

public enum ChildExceptionMessages {

    INVALID_DATA_ARRAY_LENGTH("Invalid data array length"),
    INVALID_CHILD_AGE("Invalid child age"),
    INVALID_CHILD_BUDGET("Invalid child budget"),
    INVALID_CHILD_HOURS("Invalid child hours"),
    CHILD_NOT_PASS_VALIDATION("Toy not pass validation");

    private String message;

    ChildExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
