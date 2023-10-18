package programs.threadsafe;

public class SafeCleaner implements Runnable {
    private SafeKeeping keeper;
    boolean directionIsReversed;

    public SafeCleaner(SafeKeeping safeKeeper, boolean isReversed) {
        keeper = safeKeeper;
        directionIsReversed = isReversed;
    }

    @Override
    public void run() {
        if (directionIsReversed) {
            for (int i = 25; i > 0; i--) {
                keeper.removeFromList(i, i);
            }
        } else {
            for (int i = 0; i < 26; i++) {
                keeper.removeFromList(i, i);
            }
        }
    }
}
