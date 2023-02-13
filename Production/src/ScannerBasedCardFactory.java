import payment.CreditCard;

import java.util.Scanner;

public class ScannerBasedCardFactory extends CreditCardFactory {
    @Override
    public CreditCard getCard() throws Exception {

        Scanner scanner = new Scanner(System.in);

        String cardNumber = scanner.nextLine();
        // Validate cardNumber
        if (!checkCardNumber(cardNumber)) {
            throw new Exception("Invalid card number");
        }
        CreditCard creditCard = new CreditCard(cardNumber);
        return creditCard;
    }

    private static boolean checkCardNumber(String cardNumber) {
        if (cardNumber.length() != 16) {
            return false;
        }

        for (int i = 0; i < cardNumber.length(); i++) {
            if (!Character.isDigit(cardNumber.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
