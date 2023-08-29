import java.util.Scanner;
public class BinaryValues {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a binary number with 1s and 0s (i.e. 1101)");
        String binaryInput = input.nextLine();
        int n = 0, binarySum = 0;
        for (int i = binaryInput.length()-1; i >= 0; i--) {
            int value = (binaryInput.charAt(i) == '0') ? 0 : 1;
            binarySum += value*(int)Math.pow(2,n++);
        }
        System.out.println(binaryInput + " = " + binarySum);

        input.close();
    }
}
