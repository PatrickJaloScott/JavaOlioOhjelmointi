import java.util.Scanner;
public class SumOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Give the first number: ");
        int first = scanner.nextInt();

        System.out.print("Give the second number: ");
        int second = scanner.nextInt();

        System.out.print("Give the third number: ");
        int third = scanner.nextInt();

        int sum = first + second + third, product = first*second*third;
        // decimal numbers can't be stored into the Integer type
        // double type can store the decimals
        double average = sum / 3.0;

        System.out.println("The sum of the numbers is " + sum);
        System.out.println("The product of the numbers is " + product);
        System.out.println("The average of the numbers is " + average);
    }
}
