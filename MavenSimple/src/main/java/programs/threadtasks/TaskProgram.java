package programs.threadtasks;

import ui.UserInterface;

public class TaskProgram {
    public static void main(String[] args) {
        int start, end;
        start = UserInterface.promptIntegerInput("Enter start range");
        end = UserInterface.promptIntegerInput("Enter end range");
        Runnable evenNumbers = new NumberPrinter(start, end),
                oddNumbers = new NumberPrinter(1 + start, end);
        Thread t2 = new Thread(evenNumbers),
                t1 = new Thread(oddNumbers);

        t1.start();
        t2.start();
    }
}