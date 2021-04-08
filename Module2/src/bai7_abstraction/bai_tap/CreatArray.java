package bai7_abstraction.bai_tap;

import java.util.Arrays;

public class CreatArray {
    public static void main(String[] args) {

        Shape[] shapes= new Shape[3];
        shapes[0]=new Circle(2);
        shapes[1]=new Square(2);
        shapes[2]=new Rectangle(1,2);
        System.out.println(Arrays.toString(shapes));
        for (Shape shape : shapes) {
            shape.resize(Math.random()*100);
        }
        System.out.println(Arrays.toString(shapes));
    }
}
