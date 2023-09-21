package program.filesystem;

import java.io.*;
import views.ui.UserInterface;
import model.courseenrollment.*;

public class CourseEnrollmentMain {
    private static final String FILENAME = "enrollments.ser";
    // save new data
    // show saved data
    public static void main(String[] args) {
        String inputCommand;
        do {
            inputCommand = UserInterface.promptStringInput("[N]ew data, [L]oad data, [X]Exit");
            switch (inputCommand.toLowerCase().charAt(0)) {
                case 'n':
                    saveToFile();
                    break;
                case 'l':
                    viewFromFile();
                    break;
            }
        } while (!inputCommand.equalsIgnoreCase("x"));
    }

    static void saveToFile() {
        int studentCount = UserInterface.promptIntegerInput("Enter student count");
        int courseCount = UserInterface.promptIntegerInput("Enter number of courses");
        int enrollmentCount = studentCount * courseCount;
        Student[] students = new Student[studentCount];
        Course[] courses = new Course[courseCount];
        Enrollment[] enrollments = new Enrollment[enrollmentCount];
        System.out.println("Student information");
        for (int i = 0; i < studentCount; i++) {
            String studentName = UserInterface.promptStringInput("\tEnter student name");
            int studentAge = UserInterface.promptIntegerInput("\tEnter student age");
            students[i] = new Student(studentName, studentAge);
            System.out.println();
        }
        System.out.println("Course information");
        for (int i = 0; i < courseCount; i++) {
            String courseCode = UserInterface.promptStringInput("\tEnter course code");
            String courseName = UserInterface.promptStringInput("\tEnter course name");
            String courseInstructor = UserInterface.promptStringInput("\tEnter instructor's name");
            courses[i] = new Course(courseCode, courseName, courseInstructor);
            UserInterface.promptStringInput("");
        }
        int enrollmentIndex = 0;
        System.out.println("Enrollment dates");
        for (Course course : courses) {
            for (Student student : students) {
                enrollments[enrollmentIndex] = new Enrollment(student, course,
                        UserInterface.promptStringInput("\tEnrollment date of (" + student.getName() + ") to course (" + course.getCourseName() + ")"));
                enrollmentIndex++;
            }
        }
        try (
                FileOutputStream outputStream = new FileOutputStream(FILENAME);
                ObjectOutputStream objects = new ObjectOutputStream(outputStream)
        ) {
            objects.writeObject(students);
            objects.writeObject(courses);
            objects.writeObject(enrollments);
        } catch (Exception e) {
            System.err.println("Writing objects: " + e);
        }
        System.out.println("\nNew enrollments");
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }
    }

    static void viewFromFile() {
        Student[] recordedStudents = new Student[10];
        Course[] recordedCourses = new Course[3];
        Enrollment[] recordedEnrollments = new Enrollment[30];
        try (
                FileInputStream inputStream = new FileInputStream(FILENAME);
                ObjectInputStream objects = new ObjectInputStream(inputStream)
        ) {
            recordedStudents = (Student[]) objects.readObject();
            recordedCourses = (Course[]) objects.readObject();
            recordedEnrollments = (Enrollment[]) objects.readObject();
        } catch (Exception e) {
            System.err.println("Reading file: " + e);
        }
        System.out.println("Last student records");
        for (Student student : recordedStudents) {
            System.out.println(student);
        }
        System.out.println("Last course records");
        for (Course course : recordedCourses) {
            System.out.println(course);
        }
        System.out.println("Last saved enrollments");
        for (Enrollment enrollment : recordedEnrollments) {
            System.out.println(enrollment);
        }
    }
}
