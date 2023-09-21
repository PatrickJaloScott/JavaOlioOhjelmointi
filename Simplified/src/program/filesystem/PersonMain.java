package program.filesystem;

import java.io.*;
import model.testing.SerializablePerson;

public class PersonMain {
    private final static String FILENAME = "person.dat";

    public static void main(String[] args) {
        File f = new File(FILENAME);
        SerializablePerson serializablePerson = new SerializablePerson();

        if (f.exists() && f.isFile()) {
            // we have objects state stored to the file, read it
            try (
                    FileInputStream inputstream = new FileInputStream(FILENAME);
                    ObjectInputStream objects = new ObjectInputStream(inputstream);
            ) {
                serializablePerson = (SerializablePerson) objects.readObject();
            } catch (Exception e) {
                System.err.println("Reading person: " + e);
            }
        } else {
            // there are no stored object state, let's create an object
            serializablePerson = new SerializablePerson("Enzio", "Benzio", 2002);
            try (
                    FileOutputStream outputstream = new FileOutputStream(FILENAME);
                    ObjectOutputStream objects = new ObjectOutputStream(outputstream);
            ) {
                objects.writeObject(serializablePerson);
            } catch (Exception e) {
                System.err.println("Writing person: " + e);
            }
        }
        System.out.println("Person: " + serializablePerson);
    }
}
