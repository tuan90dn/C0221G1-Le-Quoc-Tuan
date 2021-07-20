package bai7_abstraction.thuc_hanh.animals;

import bai7_abstraction.thuc_hanh.edible.Edible;
import bai7_abstraction.thuc_hanh.fruit.Apple;
import bai7_abstraction.thuc_hanh.fruit.Fruit;
import bai7_abstraction.thuc_hanh.fruit.Orange;

public class AbstractAndInterfaceTests {
//    public static void main(String[] args) {
//        Animals[] animals=new Animals[2];
//        animals[0]=new Tiger();
//        animals[1]=new Chicken();
//        for (Animals animal:animals){
//            System.out.println(animal.makeSound());
//        }
//    }
public static void main(String[] args) {
    Animals[] animals = new Animals[2];
    animals[0] = new Tiger();
    animals[1] = new Chicken();
    for (Animals animal : animals) {
        System.out.println(animal.makeSound());

        if (animal instanceof Chicken) {
            Edible edibler = (Chicken) animal;
            System.out.println(edibler.howToEat());
        }
    }
    Fruit[] fruits = new Fruit[2];
    fruits[0] = new Orange();
    fruits[1] = new Apple();
    for (Fruit fruit : fruits) {
        System.out.println(fruit.howToEat());
    }
}
}
