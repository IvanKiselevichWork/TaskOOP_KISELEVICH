package by.kiselevich.taskOOP.exception;

public enum ToyExceptionMessages {

    INVALID_DATA_ARRAY_LENGTH("Invalid data array length"),
    INVALID_TOY_TYPE("Invalid toy type"),
    INVALID_TOY_SIZE("Invalid toy size"),
    INVALID_TOY_COST("Invalid toy cost"),
    INVALID_TOY_COUNT("Invalid toy count");

    private String message;

    private ToyExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
