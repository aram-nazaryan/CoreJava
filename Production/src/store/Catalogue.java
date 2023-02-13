package store;

import javax.print.attribute.standard.PDLOverrideSupported;
import javax.print.attribute.standard.PresentationDirection;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Catalogue {
    private List<ProductItem> items;

    // eager initialization
    private static Catalogue instance;

    public static Catalogue getInstance() throws Exception {
        if (instance == null) {
            instance = new Catalogue();
        }
        return instance;
    }

    private Catalogue() throws Exception {
        FileReader reader = new FileReader("catalogue.txt");

        items = new ArrayList<>();
        String[] construct = new String[5];
        StringBuilder temp = new StringBuilder();
        int readerValue;
        int attributeNumber = 0;
        while ((readerValue = reader.read()) != -1){
            if((char) readerValue == ',' || (char) readerValue == '\n'){
                construct[attributeNumber++] = String.valueOf(temp);
                temp.delete(0, temp.length());
                if((char) readerValue == '\n'){
                    ItemType classType = ItemType.getClassName(construct[0]);
                    switch (classType.name()){
                        case "Sweets":
                            items.add(new Sweets(Integer.parseInt(construct[1]),construct[2],Integer.parseInt(construct[3]),Double.parseDouble(construct[4])));
                            break;
                        case "Beverage":
                            items.add(new Beverage(Integer.parseInt(construct[1]),construct[2],Integer.parseInt(construct[3]),Double.parseDouble(construct[4])));
                            break;
                        case "Toy":
                            items.add(new Toy(Integer.parseInt(construct[1]),construct[2],Integer.parseInt(construct[3])));
                            break;
                        case "KitchenItems":
                            items.add(new KitchenItems(Integer.parseInt(construct[1]),construct[2],Integer.parseInt(construct[3])));
                            break;
                    }
                    attributeNumber = 0;
                }
            }else {
                temp.append((char)readerValue);
            }
        }
    }

    public ProductItem find(int number) {
        for (ProductItem item : items) {
            if (number == item.getNumber()) {
                return item.clone();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (ProductItem item : items) {
            stringBuilder.append(item.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
