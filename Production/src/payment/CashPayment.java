package payment;

public class CashPayment implements Payment {

    private double expected;
    private double received;

    public CashPayment(double expected) {
        this.expected = expected;
    }

    @Override
    public void accept(double amount) {
        this.received = amount;
    }

    @Override
    public PaymentResponse verify() {
        if (received < expected) {
            return PaymentResponse.REJECTED;
        }

        double change = received - expected;
        System.out.println("Change to return: " + change);
        return PaymentResponse.OK;
    }
}
