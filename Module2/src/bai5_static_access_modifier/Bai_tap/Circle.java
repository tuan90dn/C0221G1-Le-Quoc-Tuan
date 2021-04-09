package bai5_Static_AccessModifier.Bai_tap;

public class Circle {
    private double radius=1.0;
    private String color="red";
    public Circle(){
    }
    public Circle(double r){
        this.radius=r;
    }
    public double getRadius(){
        return radius;
    }
    public double getArea(){
        return radius*radius*3.14;
    }

    public static void main(String[] args) {
        Circle circle=new Circle();
        System.out.println(circle.getRadius());
    }


}
