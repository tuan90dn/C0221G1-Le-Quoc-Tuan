package bai6_Inheritance.Bai_tap.LopCircle_va_Cylinder;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle=new Circle();
        System.out.println(circle);
        Circle circle1=new Circle(2,"yellow");
        System.out.println(circle1.toString());
    }
}
