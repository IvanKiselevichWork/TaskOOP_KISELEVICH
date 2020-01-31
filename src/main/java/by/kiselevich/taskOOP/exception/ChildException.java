package by.kiselevich.taskOOP.exception;

public class ChildException extends Exception {
    public ChildException() {
    }

    public ChildException(String message) {
        super(message);
    }

    public ChildException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChildException(Throwable cause) {
        super(cause);
    }
}
