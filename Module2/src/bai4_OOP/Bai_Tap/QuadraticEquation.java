package bai4_OOP.Bai_Tap;

import java.util.Scanner;

public class QuadraticEquation {
    private double a,b,c;

    public QuadraticEquation() {
    }
    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
    public double getDiscriminant(){
//        double delta;
        return b*b-2*a*c;
    }
    public double getRoot1(){
        return (-b+Math.pow(getDiscriminant(),0.5))/2*a;
    }
    public double getRoot2(){
        return (-b-Math.pow(getDiscriminant(),0.5))/2*a;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a: ");
        double a=scanner.nextDouble();
        System.out.println("Enter b: ");
        double b=scanner.nextDouble();
        System.out.println("Enter c: ");
        double c=scanner.nextDouble();
        QuadraticEquation equation=new QuadraticEquation(a,b,c);
        if (equation.getDiscriminant()>0){
            System.out.println("The root 1 is "+equation.getRoot1()+"The root 2 is "+equation.getRoot2());
        } else if (equation.getDiscriminant()==0){
            System.out.println("The root is "+equation.getRoot1());
        } else {
            System.out.println("The equation has no root");
        }
    }
}
