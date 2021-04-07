package bai6_Inheritance.Bai_tap.LopCircle_va_Cylinder;

public class Cylinder extends Circle {
    private double height;


    public Cylinder() {
        height=2;
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getVolume(){
        return super.getArea()*height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +" ,which is a subclass of "+super.toString()+
                '}';
    }
}
