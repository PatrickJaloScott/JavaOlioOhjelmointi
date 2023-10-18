package programs.demo;

public class PingPong extends Thread {
    private String word;
    private int delay;

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
            return;
        }
    }

    public static void main(String[] args) {
        new PingPong("ping", 33).start();
        new PingPong("PONG\n", 100).start();
    }
}
