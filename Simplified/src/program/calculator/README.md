# Assignments_12 Read Me
A simple calculator program, which was written with help by GitHub Copilot.

```java
public class Calculator {

private int sum = 0;

    public void addToSum(int number) {
        sum += number;
    }

    public void add(int number) {
        for (int i = 0; i < number; i++) {
            addToSum(1);
        }
    }

    // sigma sum method to add a given number multiplied by a factor to the sum
    // described as sigma notation
    public void sigmaSum(int number, int factor) {
        for (int i = 0; i < number; i++) {
            addToSum(i * factor);
        }
    }

    public int getSum() {
        return sum;
    }

    public void reset() {
        sum = 0;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.addToSum(5);
        calculator.addToSum(10);
        System.out.println(calculator.getSum());
        calculator.reset();
        System.out.println(calculator.getSum());
    }
}
```

The class has methods for adding a number to the sum, adding a number to the sum by looping, adding a number to the sum in sigma notation, getting the sum, and resetting the sum to 0.

The main method is used to test the methods of the class.