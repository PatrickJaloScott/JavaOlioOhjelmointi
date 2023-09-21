package model.testing.animals;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println("Cat is eating.");
    }

    @Override
    public void sleep() {
        System.out.println("Cat is sleeping.");
    }

    public void meow() {
        System.out.println("The cat named " + name + " says: Meow!");
    }
}
