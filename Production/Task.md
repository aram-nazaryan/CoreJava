# Topics

- Prevent overriding methods: final method (e.g. `getUnitPrice()`)
- Prevent extending a class: final class
- Implement Payment type using enum
- Get rid of accept(amount) method in CardPayment using default interface method
- Fix failing tests
  - Using Cloneable and clone() [Article Link](https://programming.guide/java/clone-and-cloneable.html)
- Implement **Singleton Design Pattern** on Catalogue
- Create a CreditCard class and implement a **Factory Design Pattern** for CreditCard
  - The CardPayment class should not work directly with Scanner (Why?)
  - Instead, a CardFactory should provide a CreditCard to it
- Use List in order to hold items in the ShoppingCart
- Use generic List
- Privacy Leak example in ShoppingCart: Exposing the list of items
- File I/O, **Decorator Design Pattern** in Java classes
- Write the receipt to a text file

# Homework 6

  - Implement a class that prints receipt (contents of Shopping Cart) on checkout:
    Wine     2       x 100 = 200
    .....

- Read catalogue from the file
- Use lists and generics in catalogue
- Implement Comparators to sort by:
  - Unit price
  - Name
- Implement an enum type PaymentResponse that describes the possible results that can happen when making a payment.
  - OK, REJECT, CONNECTION_ERROR: The result can be random
- Replace the `verify()` method return type to the enum defined above.
