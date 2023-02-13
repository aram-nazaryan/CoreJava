package customer;

import store.ProductItem;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List<ProductItem> items;
    List<Integer> quantity;

    public ShoppingCart() {
        items = new ArrayList<>();
        quantity = new ArrayList<>();
    }

    public void addItem(ProductItem item, int howMany) {

        // Bonus if getting a second item
        if (howMany > 1) {
            double bonusPrice = item.getUnitPrice() * 0.8;
            item.setUnitPrice(bonusPrice);
        }

        items.add(item);
        quantity.add(howMany);
    }

    public double getTotal() {
        double total = 0;

        for (int i = 0; i < items.size(); i++) {
            total += items.get(i).getUnitPrice() * quantity.get(i);
        }
        return total;
    }

    public int getSize() {
        return items.size();
    }


    @Override
    public String  toString(){
        StringBuilder info = new StringBuilder();
        for (int i = 0; i < items.size(); ++i){
            info.append(items.get(i).toString());
            info.append(" Quantity: ");
            info.append(quantity.get(i));
            info.append('\n');
        }
        return info.toString();
    }
}
