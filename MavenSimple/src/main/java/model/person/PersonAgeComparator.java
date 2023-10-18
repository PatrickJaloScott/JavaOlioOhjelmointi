package model.person;

import java.util.Comparator;

public class PersonAgeComparator implements Comparator<ComparablePerson> {
    @Override
    public int compare(ComparablePerson p1, ComparablePerson p2) {
        return p1.getAge() - p2.getAge();
    }
}
