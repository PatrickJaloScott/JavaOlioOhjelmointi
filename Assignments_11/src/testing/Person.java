package testing;

import java.io.Serializable;

public class Person implements Serializable {
    private String firstname;
    private String lastname;
    private int birthYear;

    public Person() {
        firstname = "";
        lastname = "";
        birthYear = 0;
    }

    public Person(String firstname, String lastname, int birthYear) {
        this.firstname = firstname;
        this.lastname  = lastname;
        this.birthYear = birthYear;
    }

    public String getName() {
        return firstname + " " + lastname;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname + " " + birthYear + " years";
    }
}