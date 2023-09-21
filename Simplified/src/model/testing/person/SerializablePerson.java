package model.testing.person;

import java.io.Serializable;

public class SerializablePerson implements Serializable {
    private String firstname;
    private String lastname;
    private int birthYear;

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