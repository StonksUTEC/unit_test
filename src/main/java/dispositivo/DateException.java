package dispositivo;

public class DateException extends Exception {
    static final String code = "DATE_EXCEPTION";
    public DateException(String message) {
        super(message);
    }

    public DateException(String message, Throwable cause) {
        super(message, cause);
    }
}
