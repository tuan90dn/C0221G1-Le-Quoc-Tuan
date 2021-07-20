package thi_module2.exceptions;

public class BirthdaysException extends Exception {
    public BirthdaysException() {
        super("The year must > 1900 and < current year-18, format birthday must be dd/mm/yyyy. ");
    }
}
