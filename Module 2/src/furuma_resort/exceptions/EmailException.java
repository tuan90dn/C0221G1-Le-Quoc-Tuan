package furuma_resort.exceptions;

public class EmailException extends Exception {
    public EmailException() {
        super("Format email must be abc@abc.abc");
    }
}
