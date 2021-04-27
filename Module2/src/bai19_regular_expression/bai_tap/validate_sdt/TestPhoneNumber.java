package bai19_regular_expression.bai_tap.validate_sdt;

public class TestPhoneNumber {
    public static void main(String[] args) {
        PhoneNumber phoneNumber=new PhoneNumber();
        System.out.println(phoneNumber.validate("(a8)-(22222222)"));
    }

}
