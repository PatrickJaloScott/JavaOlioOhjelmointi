package programs.threadtasks;

public class NumberPrinter implements Runnable {
    private final int endNumber;
    private int counter;
    private final String numberType;

    NumberPrinter(int startAt, int endAt) {
        counter = startAt;
        endNumber = endAt;
        numberType = (startAt % 2 == 0) ? "Even" : "Odd";
    }

    @Override
    public void run() {
        try {
            while (counter < endNumber) {
                System.out.println(numberType + " Thread: " + counter);
                counter += 2;
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.err.println("Caught an expected error: " + e);
        }
    }
}
