package store;

import java.util.Comparator;

public abstract class ProductItem implements Cloneable, Comparable {
    private int number;
    private String name;
    private double unitPrice;

    private double size;

    public ProductItem(ProductItem item) {
        this(item.number, item.name, item.unitPrice, item.size);
    }

    public ProductItem(int number, String name, double unitPrice, double size) {
        this.number = number;
        this.name = name;
        this.unitPrice = unitPrice;
        this.size = size;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public final double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double price) {
        this.unitPrice = price;
    }

    public abstract String getUnitDescription();

    @Override
    public String toString() {
        return name + " " + size + " ( " + getUnitDescription() + " ) " + "Price: " + unitPrice;
    }

    public ProductItem clone() {
        try {
            return (ProductItem) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int compareTo(Object o) {
        ProductItem temp = (ProductItem) o;
        return this.unitPrice - temp.unitPrice == 0 ? this.name.compareTo(temp.name) : (int) (this.unitPrice - temp.unitPrice);
    }

}
