import java.util.Scanner;
public class FahrenheitCelsius {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter temperature in Fahrenheit: ");
        double f = input.nextDouble();
        double c = (f - 32)/1.8;
        System.out.printf("%.0f Fahrenheit in Celsius is %.1f", f, c);
        input.close();
    }
}
