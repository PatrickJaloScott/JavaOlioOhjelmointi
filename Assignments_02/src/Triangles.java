import java.util.Scanner;
public class Triangles {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the sides of a triangle");
        System.out.print("Adjacent side: ");
        double a = input.nextDouble();
        System.out.print("Opposite side: ");
        double b = input.nextDouble();
        double hypotenuse = Math.sqrt(a*a + b*b);
        System.out.printf("The hypotenuse of the triangle is: %.2f", hypotenuse);
        input.close();
    }
}
