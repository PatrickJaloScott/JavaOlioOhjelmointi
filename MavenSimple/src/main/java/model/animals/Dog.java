package model.animals;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println("Dog is eating.");
    }

    @Override
    public void sleep() {
        System.out.println("Dog is sleeping.");
    }

    public void bark() {
        System.out.println("The dog named " + name + " says: Bark!");
    }
}
