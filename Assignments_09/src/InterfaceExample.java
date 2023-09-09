import com.metropolia.testing.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InterfaceExample {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.eat(); dog.sleep();

        Animal cat = new Cat();
        cat.eat(); cat.sleep();

        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 40));

        Comparator<Person> ageComparator = new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return Integer.compare(p1.getAge(), p2.getAge());
            }
        };

        Collections.sort(people, ageComparator);

        for (Person person : people) {
            System.out.println(person.getName() + " - " + person.getAge());
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
