package programs.threadtasks;

public class NumberPrinter implements Runnable {
    private int startNumber, endNumber;
    private int counter;
    private String numberType;

    NumberPrinter(int startAt, int endAt) {
        counter = startNumber = startAt;
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
