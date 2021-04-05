package bai4_OOP.Thuc_Hanh;

import java.util.Scanner;

public class Rectangle {

        double width, height;

        public Rectangle() {
        }

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        public double getWidth() {
            return width;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public double getArea() {
            return this.height * this.width;
        }

        public double getPerimeter() {
            return (this.height + this.width) * 2;
        }

        public String display() {
            return "Rectangle{" + "width=" + width + ", height=" + height + "}";
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the width: ");
            double width = scanner.nextDouble();
            System.out.println("Enter the height: ");
            double height = scanner.nextDouble();
            Rectangle rectangle = new Rectangle(width, height);
            System.out.println("Your Rectangle \n"+ rectangle.display());
            System.out.println("Perimeter of the Rectangle: "+ rectangle.getPerimeter());
            System.out.println("Area of the Rectangle: "+ rectangle.getArea());
        }


}
