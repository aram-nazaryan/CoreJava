package store;

public enum ItemType {
    Sweets,
    Beverage,
    Toy,
    KitchenItems;

    public static ItemType getClassName (String name) throws Exception{
        for (ItemType type: ItemType.values()){
            if(type.name().equals(name))
                return type;
        }
        throw new Exception("Wrong Class type.");
    }
}
