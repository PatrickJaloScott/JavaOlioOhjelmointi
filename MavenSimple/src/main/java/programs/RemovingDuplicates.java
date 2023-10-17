package programs;

import views.ui.UserInterface;
public class RemovingDuplicates {
    public static void main(String[] args) {
        int arraySize = UserInterface.promptIntegerInput("Enter size for an array");
        int[] numbers = new int[arraySize], checkArr = new int[arraySize];
        System.out.println("Enter the numbers into the array:");
        for (int i = 0; i < arraySize; i++) {
            numbers[i] = UserInterface.promptIntegerInput("Enter number " + (i+1));
        }
        int[] cutArray = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            for (int j = i+1; j < arraySize; j++) {
                int x = numbers[i], y = numbers[j];
                //System.out.println(x + ", " + y + " " + (x == y));
                if (x == y) {
                    checkArr[j] = 666;
                }
            }
            if(checkArr[i] == 0) {
                cutArray[i] = numbers[i];
            }
        }
        System.out.println("The array without duplicates");
        for (int x: cutArray) {
            if(x != 0) {
                System.out.print(x + " ");
            }
        }
    }
}
