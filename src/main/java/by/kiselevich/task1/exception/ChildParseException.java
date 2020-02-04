package by.kiselevich.task1.exception;

public class ChildParseException extends Exception {
    public ChildParseException() {
    }

    public ChildParseException(String message) {
        super(message);
    }

    public ChildParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChildParseException(Throwable cause) {
        super(cause);
    }
}
