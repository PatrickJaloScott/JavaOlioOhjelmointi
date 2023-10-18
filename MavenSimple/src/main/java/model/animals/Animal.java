package model.animals;

import interfaces.animals.IAnimal;

public abstract class Animal implements IAnimal {
    protected final String name;

    public Animal(String name) {
        this.name = name;
    }
}
