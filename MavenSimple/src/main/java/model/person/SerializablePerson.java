package model.person;

import java.io.Serializable;

public class SerializablePerson implements Serializable {
    private final String firstname;
    private final String lastname;
    private final int birthYear;

    public SerializablePerson() {
        firstname = "";
        lastname = "";
        birthYear = 0;
    }

    public SerializablePerson(String firstname, String lastname, int birthYear) {
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