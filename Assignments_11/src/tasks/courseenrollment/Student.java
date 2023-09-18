package tasks.courseenrollment;

import java.io.Serializable;

public class Student implements Serializable {
    private final int id;
    private static int lastStudentID = 0;
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = lastStudentID++;
    }

    public int getId() {
        return id;
    }

    public static int getLastStudentID() {
        return lastStudentID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return id + ": " +
                name + ", " +
                age;
    }
}
