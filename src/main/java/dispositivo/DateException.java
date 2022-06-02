package dispositivo;

public class DateException extends Exception {
    private String code;

    public DateException(String message) {
        super(message);
    }

    public DateException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getCode() {
        return "DATE_EXCEPTION";
    }
}
