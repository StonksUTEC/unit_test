package dispositivo;

public class DateFormatException extends Exception {
    public DateFormatException(String message) {
        super(message);
    }

    public DateFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getCode() {
        return "DATE_FORMAT_EXCEPTION";
    }
}
