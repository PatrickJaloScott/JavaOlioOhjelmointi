package model.testing.animals;

public abstract class Animal implements IAnimal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }
}
