package programs.calculators;

import ui.UserInterface;
public class QuadraticSolver {
    /*public static void main(String[] args) {
        System.out.println("ax^2 + bx + c = 0");
        System.out.println("Enter the coefficients of the equation");

        int a = UserInterface.promptIntegerInput("a"),
                b = UserInterface.promptIntegerInput("\tb"),
                c = UserInterface.promptIntegerInput("\t\tc");

        double x1, x2, discriminant = (b * b) - (4 * a * c);

        if(a != 0 && discriminant > 0) {
            x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("(-b \u00B1 \u221A[b\u00B2 - 4ac])/2a");
            System.out.printf("The roots are %f and %f", x1, x2);
        }
        else {
            if(discriminant < 0) {
                System.out.println("No real root");
            }
            else if(discriminant == 0) {
                double root = (double) -b /(2*a);
                System.out.println("There is one root: " + root);
            }
            else {
                System.out.println("Cannot divide by zero");
            }
        }
    }*/

    public static String formula() {
        return "(-b \u00B1 \u221A[b\u00B2 - 4ac])/2a";
    }

    public static String result(int a, int b, int c) {
        double x1, x2, discriminant = (b * b) - (4 * a * c);
        if(a != 0 && discriminant > 0) {
            x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            return String.format("The roots are\n%.2f\nand\n%.2f", x1, x2);
        }
        else {
            if(discriminant < 0) {
                return "No real root";
            }
            else if(discriminant == 0) {
                double root = (double) -b /(2*a);
                return "There is one root: " + root;
            }
            else {
                return "Cannot divide by zero";
            }
        }
    }
}
