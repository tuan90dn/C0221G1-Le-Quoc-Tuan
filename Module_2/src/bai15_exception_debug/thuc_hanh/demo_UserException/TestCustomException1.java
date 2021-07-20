package bai15_exception_debug.thuc_hanh.demo_UserException;

import java.util.Scanner;

public class TestCustomException1 {
    static void validate(Integer age) throws InvalidAgeException {
        if (age < 18)
            throw new InvalidAgeException("not valid");
        else
            System.out.println("valid");
    }
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String input = scanner.nextLine();
                validate(Integer.parseInt(input));
                break;
            } catch (InvalidAgeException m) {
                System.out.println("Exception occured: " + m);
                System.out.print("Mời người dùng nhập lại: ");
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
