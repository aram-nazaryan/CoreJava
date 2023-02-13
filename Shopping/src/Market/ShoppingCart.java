package Market;
import Payments.Payment;


import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements Payment {
        private static List<ProductItem> bucket = new ArrayList<>();
        private static double totalPrice = 0;

        public void addProd(int prodID, int howMany){
                ProductItem prod = ProductItem.getProdByID(prodID);
                if(prod == null){
                        System.out.println("Please check the product ID.");
                }else if(howMany > prod.quantity){
                        System.out.print("There are only " + prod.quantity + " items of " + prod.name + " can not add");
                }else if(notInList(prod.name)){
                        totalPrice += prod.price * howMany;
                        prod.reservedQuantity += howMany;
                        prod.quantity -= prod.reservedQuantity;
                        bucket.add(prod);
                        System.out.println(prod.name + " successfully added");
                }else {
                        totalPrice += prod.price * howMany;
                        prod.reservedQuantity += howMany;
                        prod.quantity -= howMany;
                        System.out.println("Another " + howMany + " " + prod.name + " added");
                }
        }

        public void removeProd(int prodID, int quantity){
                ProductItem prod = ProductItem.getProdByID(prodID);
                if(prod == null){
                        System.out.println("Please check the product ID.");
                }
                else if(notInList(prod.name)){
                        System.out.println("The " + prod.name + " is not in your bucket.");
                }
                else if(quantity > prod.reservedQuantity){
                        System.out.println("There are " + prod.reservedQuantity + " " + prod.name +" in your bucket, unable to remove " + quantity);
                }
                else{
                        totalPrice -= prod.price * quantity;
                        prod.reservedQuantity -= quantity;
                        prod.quantity += quantity;
                        if (prod.reservedQuantity == 0)
                                bucket.remove(prod);
                        System.out.println(quantity + " " + prod.name + " are removed from bucket.");
                }
        }

        private static boolean notInList(String name){
                for(ProductItem p: bucket){
                        if(p.name.equals(name))
                                return false;
                }
                return true;
        }

        public void showList(){
                for(var p: bucket){
                        System.out.println("---------------------");
                        System.out.println("Product: " + p.name);
                        System.out.println("Price: " + p.price);
                        System.out.println("Quantity: " + p.reservedQuantity);
                        System.out.println("ID: " + p.itemID);
                }
        }

        public void getPrice(){
                System.out.println("Current cost: " + totalPrice);
        }


        @Override
        public void cashMethod(){
                System.out.println("Chosen CASH!");
        }
        @Override
        public void cardMethod(){
                System.out.print("Chosen Card!");
        }
        @Override
        public boolean accept(int option){
                if(option == 1){
                        System.out.println("Your payment is accepted.");
                        return true;
                }
                else{
                        System.out.println("Your payment is canceled.");
                        return false;
                }
        }
        
        @Override
        public boolean verifyCard(String cardNumber){
        if(cardNumber.length() != 16)
            return false;
        for (int i = 0; i < cardNumber.length(); ++i){
            if(cardNumber.toCharArray()[i] < '0' || cardNumber.toCharArray()[i] > '9')
                return false;
        }
        return true;
    }


}
