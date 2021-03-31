package bai1_introduction_to_java.Bai_Tap;
import java.util.Scanner;
public class Chuyen_Doi_Tien_Te {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int money,USD;
        System.out.println("Nhập số tiền USD");
        money=scanner.nextInt();
        USD=money*23000;
        System.out.println("Số tiền VND là " + USD);

    }
}
