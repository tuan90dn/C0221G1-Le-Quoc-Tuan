package bai6_Inheritance.Bai_tap.Lop_2D_va_3D;

import java.util.Arrays;

public class Test_Point2D {
    public static void main(String[] args) {
        Point_2D point_2D=new Point_2D();
        System.out.println(Arrays.toString(point_2D.getXY()));
        Point_2D point_2D1=new Point_2D(4,5);
        System.out.println(Arrays.toString(point_2D1.getXY()));
        System.out.println(point_2D);
    }
}
