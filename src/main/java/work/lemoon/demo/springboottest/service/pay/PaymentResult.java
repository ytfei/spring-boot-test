package work.lemoon.demo.springboottest.service.pay;

public class PaymentResult {
    private int count;

    public PaymentResult(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
