package bai7_abstraction.thuc_hanh.animals;

import bai7_abstraction.thuc_hanh.edible.Edible;

public class Chicken extends Animals implements Edible {
    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }
}
