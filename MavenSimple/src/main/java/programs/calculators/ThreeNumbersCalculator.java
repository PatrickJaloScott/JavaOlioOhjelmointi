package programs.calculators;

import ui.UserInterface;
public class ThreeNumbersCalculator {

    private int first, second, third;
    public ThreeNumbersCalculator(int num1, int num2, int num3) {
        this.first = num1;
        this.second = num2;
        this.third = num3;
    }

    /*public static void main(String[] args) {
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
    }*/

    public void setValues(int num1, int num2, int num3) {
        this.first = num1;
        this.second = num2;
        this.third = num3;
    }

    public int sum() {
        return first + second + third;
    }

    public int product() {
        return first * second * third;
    }

    public double average() {
        return (first + second + third) / 3.0;
    }
}
