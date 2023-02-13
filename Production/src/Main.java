import customer.ReceiptPrinter;
import customer.ShoppingCart;
import payment.*;
import store.Catalogue;
import store.ProductItem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        CreditCardFactory factory = new ScannerBasedCardFactory();

        Catalogue catalogue = Catalogue.getInstance();

        PaymentResponse response;

        ShoppingCart shoppingCart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);


        while (true) {
            String line = askProduct(scanner);
            if ("q".equalsIgnoreCase(line)) {
                break;
            }

            int productNumber = Integer.parseInt(line);
            ProductItem product = catalogue.find(productNumber);

            int quantity = askQuantity(scanner);

            shoppingCart.addItem(product, quantity);

        }

        System.out.println("Total price: " + shoppingCart.getTotal());

        System.out.print("Choose payment method (1 = Cash, 2 = Credit Card): ");
        PaymentMethod method = PaymentMethod.getType(Integer.parseInt(scanner.nextLine()) - 1);

        Payment payment = null;
        double amount = 0;

        switch (method) {
            case CASH -> {
                payment = new CashPayment(shoppingCart.getTotal());
                System.out.print("Ask for cash: ");
                amount = Double.parseDouble(scanner.nextLine());
            }
            case CARD -> {
                CreditCard card = factory.getCard();
                payment = new CardPayment(shoppingCart.getTotal(), card);
            }
        }

        payment.accept(amount);

        response = payment.verify();
        System.out.println("Your payment status: " + response);

        ReceiptPrinter.print(shoppingCart, response);
    }

    private static String askProduct(Scanner scanner) {
        System.out.println("Enter product number (q to quit):");
        return scanner.nextLine();
    }

    private static int askQuantity(Scanner scanner) {
        System.out.println("Enter product quantity:");
        return Integer.parseInt(scanner.nextLine());
    }
}