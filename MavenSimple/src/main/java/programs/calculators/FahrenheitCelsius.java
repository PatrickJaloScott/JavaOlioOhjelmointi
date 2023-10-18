package programs.calculators;

import ui.UserInterface;
public class FahrenheitCelsius {
    public static void main(String[] args) {
        double f = UserInterface.promptDoubleInput("Enter temperature in Fahrenheit");
        double c = (f - 32)/1.8;
        System.out.printf("%.0f Fahrenheit in Celsius is %.1f", f, c);
    }
}
