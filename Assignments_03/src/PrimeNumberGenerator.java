import java.util.Scanner;
public class PrimeNumberGenerator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int start, end;
        System.out.println("Enter the start and end number of the range");
        System.out.print("Start: ");
        start = input.nextInt();
        System.out.print("End: ");
        end = input.nextInt();
        // loop between start and end
        for (int i = start; i <= end; i++) {
            // variable for transferring the prime numbers forward
            int send = i;
            // loop between 2 and the current number
            for (int j = i-1; j >= 2; j--) {
                // check the division remainder
                if(i%j == 0) {
                    // negate if the remainder is null. a prime number will skip this block
                    send = 0;
                }
            }
            // use the control variable as condition to print the prime numbers
            if(send != 0) {
                System.out.print(i + " ");
            }
        }

        input.close();
    }
}
