package programs.demo;

public class ContinuousCounter implements Runnable {
    private int counter;
    boolean interrupted;

    ContinuousCounter() {
        counter = 1;
    }

    @Override
    public void run() {
        interrupted = false;
        try {
            while (!interrupted) {
                System.out.println(counter++);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
    }

    public void interrupt() {
        interrupted = true;
    }
}
