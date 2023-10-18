package programs.threadsafe;

public class TestSafe {
    public static void main(String[] args) {
        SafeKeeping safeList = new SafeKeeping();

        Thread initializer = new Thread(new SafeRunner(safeList));
        Thread normalCleaner = new Thread(new SafeCleaner(safeList, false));
        Thread reversedCleaner = new Thread(new SafeCleaner(safeList, true));
        initializer.start();

        try {
            initializer.join();
        } catch (InterruptedException e) {
            System.err.println("Initializer thread was interrupted.");
        }

        // start the other threads
        normalCleaner.start();
        reversedCleaner.start();
        // try joining the other threads
        try {
            //initializer.join();
            normalCleaner.join();
            reversedCleaner.join();
        } catch (InterruptedException e) {
            System.err.println("One of the cleaning threads was interrupted.\n" + e);
        }
        System.out.println("There are " + safeList.getListSize() + " combinations in the list.");
        safeList.printCombinations();
    }
}