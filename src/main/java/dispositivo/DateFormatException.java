package dispositivo;

public class DateFormatException extends Exception {
    static final String code = "DATE_FORMAT_EXCEPTION";
    public DateFormatException(String message) {
        super(message);
    }

    public DateFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
