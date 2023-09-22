import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Runnable writer = new ContinuousCounter();
        Thread t = new Thread(writer);

        t.start();
        while (scanner.nextLine().charAt(0) != 'q');
        t.interrupt();
        System.out.println("Program terminated");
    }
}