public class ContinuousCounter implements Runnable {
    private int counter;

    ContinuousCounter() {
        counter = 1;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(counter++);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
            return;
        }
    }
}
