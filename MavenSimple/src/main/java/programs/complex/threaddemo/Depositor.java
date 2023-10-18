package programs.complex.threaddemo;

import java.math.BigInteger;

public class Depositor implements Runnable {
    private final Account account;
    private final int n;

    public Depositor(Account account, int n) {
        this.account = account;
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            account.deposit(BigInteger.ONE);
        }
    }
}
