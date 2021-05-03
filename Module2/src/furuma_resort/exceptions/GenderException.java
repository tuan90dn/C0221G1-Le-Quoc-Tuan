package furuma_resort.exceptions;

public class GenderException extends Exception {
    public GenderException() {
        super("Gender must be Male, Female or Unknown!");
    }
}
