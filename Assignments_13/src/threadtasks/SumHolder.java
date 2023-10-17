package threadtasks;

public class SumHolder {
    private int sum = 0;

    public SumHolder() {
    }

    public void addToSum() {
        System.out.println("Total sum is now: " + ++sum);
    }

    public int getSum() {
        return this.sum;
    }
}
