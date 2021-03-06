package Exceptions.CreateException;

public class SideException extends Exception {
    public SideException() {}

    public SideException(String message) {
        super(message);
    }

    public SideException(String message, Throwable cause) {
        super(message, cause);
    }

    public SideException(Throwable cause) {
        super(cause);
    }

    public SideException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
