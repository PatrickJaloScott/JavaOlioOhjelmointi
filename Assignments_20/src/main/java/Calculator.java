public class Calculator {
    private int result;

    public void clear() {
        result = 0;
    }
    public void add(int n) {
        result += n;
    }
    public void sub(int n) {
        result -= n;
    }
    public void mul(int n) {
        result *= n;
    }
    public void div(int n) {
        result /= n;
    }
    public int getResult() {
        return result;
    }
}
