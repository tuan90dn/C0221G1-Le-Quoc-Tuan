package bai7_abstraction.bai_tap;

public class TestSquare {
    public static void main(String[] args) {
        Shape square=new Square();
        ((Square)square).resize(50);
        System.out.println(((Square)square).getArea());
    }
}
