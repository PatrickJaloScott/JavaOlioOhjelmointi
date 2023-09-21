package program.demo;

import model.testing.Animal;
import model.testing.Cat;
import model.testing.Dog;
import model.testing.ComparablePerson;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class InterfaceExample {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.eat(); dog.sleep();

        Animal cat = new Cat();
        cat.eat(); cat.sleep();

        List<ComparablePerson> people = new ArrayList<>();
        people.add(new ComparablePerson("Alice", 30));
        people.add(new ComparablePerson("Bob", 25));
        people.add(new ComparablePerson("Charlie", 40));

        Comparator<ComparablePerson> ageComparator = new Comparator<ComparablePerson>() {
            @Override
            public int compare(ComparablePerson p1, ComparablePerson p2) {
                return Integer.compare(p1.getAge(), p2.getAge());
            }
        };

        people.sort(ageComparator);

        for (ComparablePerson comparablePerson : people) {
            System.out.println(comparablePerson.getName() + " - " + comparablePerson.getAge());
        }

        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        for (String name : names) {
            System.out.println(name);
        }
    }
}
