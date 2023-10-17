package programs.complex;

import model.testing.animals.IAnimal;
import model.testing.animals.Cat;
import model.testing.animals.Dog;
import model.testing.person.ComparablePerson;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class InterfaceExample {
    public static void main(String[] args) {
        IAnimal dog = new Dog("Spot");
        dog.eat(); dog.sleep();
        ((Dog)dog).bark();

        IAnimal cat = new Cat("Whiskers");
        cat.eat(); cat.sleep();
        ((Cat)cat).meow();

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
