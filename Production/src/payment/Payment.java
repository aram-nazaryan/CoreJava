package payment;

public interface Payment {
    // Empty default method in interface acts as an optional method
    // The subclass implementing it can skip the definition
    default void accept(double amount) {

    }
    PaymentResponse verify();
}
