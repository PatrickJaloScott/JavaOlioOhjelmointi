package program.calculator;

import views.ui.UserInterface;
public class QuadraticSolver {
    public static void main(String[] args) {
        System.out.println("ax^2 + bx + c = 0");
        System.out.println("Enter the coefficients of the equation");

        int a = UserInterface.promptIntegerInput("a");
        int b = UserInterface.promptIntegerInput("\tb");
        int c = UserInterface.promptIntegerInput("\t\tc");

        double x1, x2, discriminant = (b * b) - (4 * a * c);

        if(a != 0 && discriminant > 0) {
            x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
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
    }
}
