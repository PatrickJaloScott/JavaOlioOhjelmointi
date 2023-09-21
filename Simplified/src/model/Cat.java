package model;

public class Cat {
    private final String name;

    public Cat(String name) {
        this.name = name;
    }

    public void meow() {
        System.out.println("The cat named " + name + " says: Meow!");
    }

    public static void main(String[] args) {
        Cat catW = new Cat("Whiskers"),
        catR = new Cat("Rex");
        catW.meow();
        catW.meow();
        catR.meow();
        catW.meow();
    }
}
