package programs.demo;

public class PingPong extends Thread {
    private final String word;
    private final int delay;

    public PingPong(String whatToSay, int delayTime) {
        word = whatToSay;
        delay = delayTime;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.print(word + " ");
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            System.out.println("Caught exception " + e);
        }
    }

    public static void main(String[] args) {
        new PingPong("ping", 33).start();
        new PingPong("PONG\n", 100).start();
    }
}
