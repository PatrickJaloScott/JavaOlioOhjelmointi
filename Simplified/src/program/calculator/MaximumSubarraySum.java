package program.calculator;

import views.ui.UserInterface;
public class MaximumSubarraySum {
    public static void main(String[] args) {
        int arraySize = UserInterface.promptIntegerInput("How many numbers in the array?");
        int[] array = new int[arraySize];
        System.out.println("Provide the numbers for the array");
        for (int i = 0; i < arraySize; i++) {
            System.out.print("Enter number " + (i+1) + ": ");
            array[i] = UserInterface.promptIntegerInput("Enter number " + (i+1));
        }
        // variables for end result
        int maxSum = 0, rangeMin = 0, rangeMax = 0;
        // loop through the array
        for (int i = 0; i < arraySize; i++) {
            // loop between the main index i and the last number with subindex j
            // i.e. [i-arraySize] or (i < j < arraySize)
            for (int j = i; j < arraySize; j++) {
                //System.out.print("Subarray: ");
                // initiate variable for sum of the subarray
                int subSum = 0;
                // loop through the subarray with index k
                // i.e. [i-j] or (i < k < J)
                for (int k = i; k <= j; k++) {
                    //System.out.print(array[k] + " ");
                    // add up the sum of the subarray
                    subSum += array[k];
                }
                //System.out.println("\tSum: " + subSum);
                // check if the sum of the current subarray will be the new maximum sum
                if(subSum > maxSum) {
                    // set the new maximum sum
                    maxSum = subSum;
                    // set the range of where in the array the sum came from
                    rangeMin = i+1;
                    rangeMax = j+1;
                }
            }
        }
        System.out.println("\nMaximum sum: " + maxSum);
        System.out.printf("Range: %d-%d", rangeMin, rangeMax);
    }
}
