import java.util.Scanner;
public class RemovingDuplicates {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter size for an array: ");
        int arraySize = input.nextInt();
        int[] numbers = new int[arraySize], checkArr = new int[arraySize];
        System.out.println("Enter the numbers into the array:");
        for (int i = 0; i < arraySize; i++) {
            System.out.print("Enter number " + (i+1) + ": ");
            numbers[i] = input.nextInt();
            checkArr[i] = 0;
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
