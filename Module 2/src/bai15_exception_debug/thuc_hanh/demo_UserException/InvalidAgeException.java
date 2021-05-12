package bai15_exception_debug.thuc_hanh.demo_UserException;

public class InvalidAgeException extends Exception {
    public InvalidAgeException(String not_valid) {
//        System.out.println(not_valid);
        super(not_valid);
    }
}
