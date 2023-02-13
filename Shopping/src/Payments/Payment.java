package Payments;

public interface Payment {
    void cashMethod();
    void cardMethod();
    boolean accept(int option);
    boolean verifyCard(String cardNumber);
}
