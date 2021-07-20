package furuma_resort.exceptions;

public class IdCardException extends Exception {
    public IdCardException() {
        super("Format id card must be XXX XXX XXX");
    }
}
