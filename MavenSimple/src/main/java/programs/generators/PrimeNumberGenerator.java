package programs.generators;

import ui.UserInterface;
public class PrimeNumberGenerator {
    public static void main(String[] args) {
        int start, end;
        System.out.println("Enter the start and end number of the range");
        start = UserInterface.promptIntegerInput("Start");
        end = UserInterface.promptIntegerInput("End");
        // loop between start and end
        for (int i = start; i <= end; i++) {
            // variable for transferring the prime numbers forward
            int send = i;
            // loop between 2 and the current number
            for (int j = i-1; j >= 2; j--) {
                // check the division remainder
                if (i % j == 0) {
                    // negate if the remainder is null. a prime number will skip this block
                    send = 0;
                    break;
                }
            }
            // use the control variable as condition to print the prime numbers
            if(send != 0) {
                System.out.print(i + " ");
            }
        }
    }
}
