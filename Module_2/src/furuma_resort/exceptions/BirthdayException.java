package furuma_resort.exceptions;

public class BirthdayException extends Exception {
    public BirthdayException() {
        super("The year must > 1900 and < current year-18, format birthday must be dd/mm/yyyy. ");
    }
}
