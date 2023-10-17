package threadsafe;

public class SafeRunner implements Runnable {
    private SafeKeeping keeper;

    public SafeRunner(SafeKeeping safeKeeper) {
        keeper = safeKeeper;
    }

    @Override
    public void run() {
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                keeper.addToList(i, j);
            }
        }
        System.out.println("Starting with " + keeper.getListSize() + " combinations in the list.");
    }
}
