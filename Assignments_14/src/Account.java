import java.math.BigInteger;

public class Account {
    private BigInteger credit;

    public Account() {
        credit = BigInteger.ZERO;
    }

    public void deposit(BigInteger amount) {
        synchronized (this) {
            credit = credit.add(amount);
        }
    }

    public synchronized boolean withdraw(BigInteger amount) {
        BigInteger result = credit.subtract(amount);

        if(result.signum() == -1) {
            return false;
        } else {
            credit = result;
            return true;
        }
    }

    public BigInteger getSaldo() {
        return credit;
    }
}
