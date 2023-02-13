package customer;

import payment.PaymentResponse;
import store.KitchenItems;
import store.ProductItem;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ReceiptPrinter {
    public static void print(ShoppingCart bucket, PaymentResponse status) throws IOException{
        FileWriter writer = new FileWriter("check");
        PrintWriter _print = new PrintWriter(writer);

        StringBuilder receipt = new StringBuilder();
        for(int i = 0; i < bucket.items.size(); ++i){
            receipt.append(bucket.items.get(i).getName() + " ");
            receipt.append(bucket.quantity.get(i) + " x ");
            receipt.append(bucket.items.get(i).getUnitPrice() + " = ");
            receipt.append(bucket.items.get(i).getUnitPrice() * bucket.quantity.get(i) + '\n');
        }
        receipt.append("Total: " + bucket.getTotal() + '\n');
        receipt.append("Payment status: " + status);
        _print.print(receipt);
        System.out.println("See your receipt in Check file.");
        _print.close();
    }

    private ReceiptPrinter(){

    };
}
