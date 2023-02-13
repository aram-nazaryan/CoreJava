package payment;

public enum PaymentMethod {
    CASH, // 0
    CARD; // 1


    public static PaymentMethod getType(int number) throws Exception {
        for (PaymentMethod value : PaymentMethod.values()) {
            if (value.ordinal() == number) {
                System.out.println(value.name());
                return value;
            }
        }
        throw new Exception("Wrong payment type code");
    }
}
