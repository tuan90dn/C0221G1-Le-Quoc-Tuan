package bai4_OOP.Thuc_Hanh;

import bai4_OOP.Bai_Tap.QuadraticEquation;

import java.util.Scanner;

public class Ex14_1 {
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
