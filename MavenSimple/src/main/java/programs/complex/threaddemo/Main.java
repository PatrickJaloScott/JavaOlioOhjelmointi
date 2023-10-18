package programs.complex.threaddemo;

public class Main {
    static final int N = 1000;
    public static void main(String[] args) {
        Account account = new Account();

        Thread william = new Thread(new Depositor(account, N));
        Thread jeff = new Thread(new Depositor(account, N));

        william.start(); jeff.start();

        try {
            william.join(); jeff.join();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Saldo is: " + account.getSaldo());
    }
}