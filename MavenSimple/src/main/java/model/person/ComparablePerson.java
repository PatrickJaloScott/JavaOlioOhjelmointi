package model.person;

public class ComparablePerson implements Comparable<ComparablePerson> {
    private final String name;
    private final int age;

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
