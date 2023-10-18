package programs.complex;

import ui.UserInterface;
public class Triangles {
    public static void main(String[] args) {
        System.out.println("Enter the sides of a triangle");
        double a = UserInterface.promptDoubleInput("Adjacent side");
        double b = UserInterface.promptDoubleInput("Opposite side");
        double hypotenuse = Math.sqrt(a*a + b*b);
        System.out.printf("The hypotenuse of the triangle is: %.2f", hypotenuse);
    }
}
