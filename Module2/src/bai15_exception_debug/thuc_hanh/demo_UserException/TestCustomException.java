package bai15_exception_debug.thuc_hanh.demo_UserException;
import java.util.Scanner;
import static java.lang.System.*;
public class TestCustomException {
    static void validate(Integer age) throws InvalidAgeException, InvaluNumberException {
        if (age < 18)
            throw new InvalidAgeException("not valid");
        else
            throw new InvaluNumberException("valid");
    }
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String input = scanner.nextLine();
                if(Integer.parseInt(input)<18) {
                    throw new InvalidAgeException("Em chưa 18");
                }
                break;
            } catch (InvalidAgeException m) {
                System.out.println("Exception occured: " + m);
            }
        }
        System.out.println("rest of the code...");
//        int age = scanner.nextInt();
//        if(age<18) {
//            throw new InvalidAgeException("EM chưa 18");
//        }
//        out.println("Hello gái");
    }
}
