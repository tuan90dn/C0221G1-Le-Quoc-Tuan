package furuma_resort.exceptions;

public class NameException extends Exception {
    public NameException() {
        super("First charactor must be upper case!");
    }
}
