package programs.threadtasks;

public class SumCounter implements Runnable {
    private final int counterID;
    private static int lastCounterID = 0;
    private final SumHolder sumHolder;
    private final int targetNumber, randomFilter;
    private int ownSum;

    public SumCounter(SumHolder holder, int target) {
        counterID = lastCounterID++;
        sumHolder = holder;
        targetNumber = target;
        randomFilter = (int) (Math.random() * 10) + 1;
        ownSum = 0;
    }

    @Override
    public void run() {
        try {
            while (sumHolder.getSum() < targetNumber) {
                System.out.print("Counter " + counterID + " added to sum. ");
                sumHolder.addToSum();
                if (sumHolder.getSum() % randomFilter == 0) {
                    ownSum += sumHolder.getSum();
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Caught interrupted exception: " + e);
        }
        System.out.print("\n(" + counterID + ", " + randomFilter + ") own sum is " + ownSum);
    }
}
