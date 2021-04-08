package bai7_abstraction.bai_tap;

public class TestCircle {
    public static void main(String[] args) {
        Shape circle=new Circle();
//        System.out.println(((Circle) circle).getArea());
        ((Circle) circle).resize(50);
        System.out.println(((Circle) circle).getArea());
    }
}
