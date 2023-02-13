package payment;

import java.util.Scanner;

public class CreditCard {
    double balance;
    public CreditCard(String number) {
        balance = 1000;
    }

    public boolean deduct(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("New balance: " + balance);
            return true;
        }
        return false;
    }

    public void authorize() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();
        if (!pin.equals("1111")) throw new Exception("Incorrect PIN");
    }
}
