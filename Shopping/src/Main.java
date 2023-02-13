import Market.ProductItem;
import Market.ShoppingCart;

import java.util.Scanner;

public class Main {
    public static void generateProducts(){
        ProductItem item1 = new ProductItem("Mandarin", 500, 100);
        ProductItem.addItem(item1);
        ProductItem item2 = new ProductItem("Botas", 40000, 10);
        ProductItem.addItem(item2);
        ProductItem item3 = new ProductItem("TV", 500000, 30);
        ProductItem.addItem(item3);
        ProductItem item4 = new ProductItem("IPhone", 470000, 25);
        ProductItem.addItem(item4);
        ProductItem item5 = new ProductItem("Rose", 1000, 101);
        ProductItem.addItem(item5);
        ProductItem item6 = new ProductItem("Wine", 8000, 60);
        ProductItem.addItem(item6);
        ProductItem item7 = new ProductItem("Marker", 300, 1000);
        ProductItem.addItem(item7);
        ProductItem item8 = new ProductItem("Mirror", 15000, 70);
        ProductItem.addItem(item8);
        ProductItem item9 = new ProductItem("Teddy Bear", 90000, 80);
        ProductItem.addItem(item9);
        ProductItem item10 = new ProductItem("Senior DevOps Engineer", 4000000, 3);
        ProductItem.addItem(item10);
    }

    public static void main(String[] args) {

        generateProducts();
        Scanner scan = new Scanner(System.in);
        boolean quit = false;
        ShoppingCart bucket = new ShoppingCart();
        do {
            System.out.println("""

                    Please enter option
                    "Show list of products":(1)
                    "Buy items":(2)
                    "See the CurrentPrice":(3)
                    "Payment":(4)
                    "Show current bucket":(5)
                    "Remove from bucket":(6)
                    "Quit":(0)""");
            int option = scan.nextInt();
            switch (option) {
                case 0 -> {
                    System.out.println("Adios");
                    quit = true;
                }
                case 1 -> {
                    System.out.println("All products list");
                    ProductItem.showProdList();
                }
                case 2 -> {
                    int opt = 1;
                    do {
                        System.out.print("Enter ID and quantity: ");
                        int id = scan.nextInt();
                        int quantity = scan.nextInt();
                        bucket.addProd(id, quantity);
                        System.out.println("Continue buying (1), to back Main menu (0)");
                        opt = scan.nextInt();
                    } while (opt == 1);
                }
                case 3 -> {
                    System.out.print("Your bucket's current price is ");
                    bucket.getPrice();
                }
                case 4 -> {
                    bucket.getPrice();
                    System.out.println("Choose the payment type(1: cash, 2: card): ");
                    int paymentOpt = scan.nextInt();
                    scan.nextLine();
                    switch (paymentOpt) {
                        case 1 -> {
                            bucket.cashMethod();
                            System.out.println("To confirm payment press 1, to cancel 0");
                            quit = bucket.accept(scan.nextInt());
                        }
                        case 2 -> {
                            bucket.cardMethod();
                            boolean isValidCard;
                            do {
                                System.out.println("Enter the card number 16 digits");
                                String input = scan.nextLine();
                                isValidCard = bucket.verifyCard(input);
                                if (isValidCard){
                                    System.out.println("Card number is valid");
                                    System.out.println("To confirm payment press 1, to cancel 0");
                                    quit = bucket.accept(scan.nextInt());
                                }else {
                                    System.out.println("Card Number is invalid");
                                    System.out.println("If you wanna go back to Main menu type \"exit\", to try enter number again press Enter.");
                                    isValidCard = scan.nextLine().equalsIgnoreCase("exit");
                                }
                            }while (!isValidCard);

                        }
                        default -> System.out.println("Incorrect payment type, please press 4 and select 1 or 2.");
                    }
                }
                case 5 -> {
                    System.out.println("You have chosen: ");
                    bucket.showList();
                }
                case 6-> {
                    System.out.println("Enter ID and quantity: ");
                    bucket.removeProd(scan.nextInt(), scan.nextInt());
                }
            }
        }while (!quit);
    }
}
