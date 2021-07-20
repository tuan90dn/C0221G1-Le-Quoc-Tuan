package bai15_exception_debug.bai_tap;

import bai15_exception_debug.thuc_hanh.demo_UserException.InvalidAgeException;

import java.util.Scanner;

public class InputTriangel {
    static void validate(double a,double b,double c) throws IllegalTriangleException{
        if (a < 0||b<0||c<0||a+b<c||a+c<b||b+c<a){
            throw new IllegalTriangleException("not valid");
        }

        else {
            System.out.println("valid");
        }
    }
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String a = scanner.nextLine();
                String b=scanner.nextLine();
                String c=scanner.nextLine();
                validate(Double.parseDouble(a),Double.parseDouble(b),Double.parseDouble(c));
                break;
            } catch (IllegalTriangleException m) {
                System.out.println("Exception occured: " + m);
                System.out.print("Mời người dùng nhập lại: ");
            }
        }
        System.out.println("rest of the code...");
//
    }

}
