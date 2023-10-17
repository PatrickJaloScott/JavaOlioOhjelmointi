# Assignments_12 Read Me
A simple calculator program, which was written with help by GitHub Copilot.

```java
public class Calculator {
    private int sum = 0;

    public void addToSum(int number) throws NegativeNumberException {
        if (number < 0) {
            throw new NegativeNumberException("Number must be positive");
        }
        else {
            sum += number;
        }
    }

    public void add(int number) throws NegativeNumberException {
        for (int i = 0; i < number; i++) {
            addToSum(1);
        }
    }

    // sigma sum method to add a given number multiplied by a factor to the sum
    // described as sigma notation
    public void sigmaSum(int number, int factor) throws NegativeNumberException {
        System.out.println("(" + number + " Σ i=0) " + factor + " * x_i");
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
        try {
            calculator.addToSum(5);
            calculator.addToSum(10);
        } catch (NegativeNumberException e) {
            throw new RuntimeException(e);
        }
        System.out.println(calculator.getSum());
        calculator.reset();
        System.out.println(calculator.getSum());
        try {
            calculator.addToSum(-5);
        } catch (NegativeNumberException e) {
            System.out.println(e.getMessage());
        }

        try {
            calculator.sigmaSum(5, 2);
        } catch (NegativeNumberException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(calculator.getSum());
    }
}
```

The class has methods for adding a number to the sum, adding a number to the sum by looping, adding a number to the sum in sigma notation, getting the sum, and resetting the sum to 0.

The main method is used to test the methods of the class.

```java

/**
 * Exception class for negative number validation
 */
public class NegativeNumberException extends Exception {
    public NegativeNumberException(String message) {
        super(message);
    }
}
```

The NegativeNumberException class is used to throw an exception when a negative number is passed to the addToSum method.