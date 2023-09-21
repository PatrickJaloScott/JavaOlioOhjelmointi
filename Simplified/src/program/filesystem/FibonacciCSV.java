package program.filesystem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class FibonacciCSV {
    private static final String FILENAME = "numbersequence.csv";
    private static final int MAXFIBONACCI = 40, MINFIBONACCI = 5;
    public static void main(String[] args) {
        try (FileWriter fWriter = new FileWriter(FILENAME);
             BufferedWriter bufferedWriter = new BufferedWriter(fWriter)) {
            // loop 100x
            for (int i = 0; i < 100; i++) {
                // fibonacci sequence from random range of MIN(10)-MAX(40)
                Random rand = new Random();
                int randomSequence = rand.nextInt((int) ((Math.random() * (MAXFIBONACCI - MINFIBONACCI)) + MINFIBONACCI));
                int[] fibonacciRow = new int[randomSequence];
                for (int j = 0; j < randomSequence; j++) {
                    fibonacciRow[j] = (int)fibonacciSequence(j+MINFIBONACCI);
                    bufferedWriter.write(fibonacciRow[j] + ";");
                    System.out.print(fibonacciRow[j] + " ");
                }
                bufferedWriter.newLine();
                System.out.println();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    static long fibonacciSequence(long number) {
        if(number == 0 || number == 1) {
            return number;
        } else {
            return fibonacciSequence(number - 2) + fibonacciSequence(number - 1);
        }
    }
}
