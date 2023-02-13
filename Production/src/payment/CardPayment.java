package payment;

public class CardPayment implements Payment {
    private double expected;
    private CreditCard creditCard;

    public CardPayment(double expected, CreditCard creditCard) {
        this.expected = expected;
        this.creditCard = creditCard;
    }

    @Override
    public PaymentResponse verify() {
        try {
            creditCard.authorize();
        } catch (Exception e) {
            return PaymentResponse.REJECTED;
        }
        return creditCard.deduct(expected) ? PaymentResponse.OK : PaymentResponse.INSUFFICIENT_FUNDS;
    }
}
