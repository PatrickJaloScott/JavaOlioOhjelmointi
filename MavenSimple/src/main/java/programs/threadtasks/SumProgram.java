package programs.threadtasks;

import ui.UserInterface;

public class SumProgram {
    public static void main(String[] args) {
        SumHolder holder = new SumHolder();
        int numberOfCounters = UserInterface.promptIntegerInput("Enter number of Sum Counters");
        SumCounter[] counters = new SumCounter[numberOfCounters];
        int targetSum = UserInterface.promptIntegerInput("What is the target sum for the counters?");

        for (SumCounter counter : counters) {
            counter = new SumCounter(holder, targetSum);
            Thread tX = new Thread(counter);
            tX.start();
        }
    }
}