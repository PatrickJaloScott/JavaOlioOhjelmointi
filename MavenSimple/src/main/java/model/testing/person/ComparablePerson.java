package model.testing.person;

public class ComparablePerson implements Comparable<ComparablePerson> {
    private String name;
    private int age;

    public ComparablePerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(ComparablePerson o) {
        return this.age - o.age;
    }
}
