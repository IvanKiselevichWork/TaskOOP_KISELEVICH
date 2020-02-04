package by.kiselevich.taskOOP.exception;

public class ToyParseException extends Exception {
    public ToyParseException() {
    }

    public ToyParseException(String message) {
        super(message);
    }

    public ToyParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public ToyParseException(Throwable cause) {
        super(cause);
    }
}
