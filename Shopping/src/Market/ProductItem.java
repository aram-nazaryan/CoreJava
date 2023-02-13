package Market;

import java.util.ArrayList;
import java.util.List;

public class ProductItem {
    double price;
    String name;
    int itemID;
    int quantity = 0;
    static int IDCounter = 0;
    static List<ProductItem> prodList = new ArrayList<>();
    int reservedQuantity = 0;

    public ProductItem(String name, int price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.itemID = -1;
    }

    public static void addItem(ProductItem item){
        boolean terminated = false;

        for (ProductItem productItem : prodList) {
            if (productItem.name.equals(item.name)) {
                productItem.quantity += item.quantity;
                terminated = true;
                break;
            }
        }

        if(!terminated){
            item.itemID = IDCounter++;
            prodList.add(item);
        }
    }

    public static void showProdList(){
        for(ProductItem p: prodList){
            System.out.println("---------------------");
            System.out.println("Product: " + p.name);
            System.out.println("Price: " + p.price);
            System.out.println("Quantity: " + p.quantity);
            System.out.println("ID: " + p.itemID);
        }
    }

    static ProductItem getProdByID(int prodID){
        for(ProductItem p: prodList){
            if(p.itemID == prodID)
                return p;
        }
        return null;
    }

}


