package ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    private static final Scanner input = new Scanner(System.in);
    public static String promptStringInput(String message) {
        String returnString;
        standardPrint(message);
        returnString = input.next();
        return returnString;
    }

    public static int promptIntegerInput(String message) {
        int retInt = Integer.MAX_VALUE;
        boolean isValid;
        do {
            standardPrint(message);
            try {
                retInt = input.nextInt();
                isValid = true;
            } catch (InputMismatchException mismatch) {
                System.out.println("Invalid input. Please enter a valid number");
                isValid = false;
                input.nextLine();
            }
        } while (!isValid);
        return retInt;
    }

    public static double promptDoubleInput(String message) {
        standardPrint(message);
        return input.nextDouble();
    }

    static void standardPrint(String msg) {
        System.out.print(msg + ": ");
    }
}
