import java.util.Scanner;
import java.lang.Math;
public class MultiplicationExam {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int correctAnswers;
        do {
            correctAnswers = 0;
            for (int i = 1; i <= 10; i++) {
                int x = (int) (Math.random() * 10) + 1,
                        y = (int) (Math.random() * 10) + 1,
                        z = x * y;
                System.out.printf("%d: %d * %d = ", i, x, y);
                int answer = input.nextInt();
                if (answer == z) {
                    System.out.println("Correct!");
                    correctAnswers++;
                } else {
                    System.out.println("Incorrect!");
                }
            }
            System.out.printf("You scored %d/10 points!\n", correctAnswers);
        } while (correctAnswers < 10);
        System.out.println("Congratulations! You mastered the multiplication table!");

        input.close();
    }
}
