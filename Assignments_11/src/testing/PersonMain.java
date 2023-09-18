package testing;

import java.io.*;

public class PersonMain {
    private final static String FILENAME = "person.dat";

    public static void main(String[] args) {
        File f = new File(FILENAME);
        Person person = new Person();

        if (f.exists() && f.isFile()) {
            // we have objects state stored to the file, read it
            try (
                    FileInputStream inputstream = new FileInputStream(FILENAME);
                    ObjectInputStream objects = new ObjectInputStream(inputstream);
            ) {
                person = (Person) objects.readObject();
            } catch (Exception e) {
                System.err.println("Reading person: " + e);
            }
        } else {
            // there are no stored object state, let's create an object
            person = new Person("Enzio", "Benzio", 2002);
            try (
                    FileOutputStream outputstream = new FileOutputStream(FILENAME);
                    ObjectOutputStream objects = new ObjectOutputStream(outputstream);
            ) {
                objects.writeObject(person);
            } catch (Exception e) {
                System.err.println("Writing person: " + e);
            }
        }
        System.out.println("Person: " + person);
    }
}
