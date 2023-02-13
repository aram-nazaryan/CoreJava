import payment.CreditCard;

// ScannerBasedCardFactory
// MemoryBasedCardFactory

public abstract class CreditCardFactory {
    public abstract CreditCard getCard() throws Exception;
}
