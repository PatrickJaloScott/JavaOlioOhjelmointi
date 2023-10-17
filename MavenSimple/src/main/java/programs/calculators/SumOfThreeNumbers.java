package programs.calculators;

import views.ui.UserInterface;
public class SumOfThreeNumbers {
    public static void main(String[] args) {
        int first = UserInterface.promptIntegerInput("Give the first number: ");
        int second = UserInterface.promptIntegerInput("Give the second number: ");
        int third = UserInterface.promptIntegerInput("Give the third number:");

        int sum = first + second + third, product = first*second*third;
        // decimal numbers can't be stored into the Integer type
        // double type can store the decimals
        double average = sum / 3.0;

        System.out.println("The sum of the numbers is " + sum);
        System.out.println("The product of the numbers is " + product);
        System.out.println("The average of the numbers is " + average);
    }
}
