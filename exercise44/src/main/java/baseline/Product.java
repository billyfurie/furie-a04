package baseline;

public class Product {

    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        // set all the instance variables
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        // return the product as a string in our specified format
        String builder = "";

        builder += (String.format("Name: %s%n", name));
        builder += (String.format("Price: %.2f%n", price));
        builder += (String.format("Quantity: %d%n", quantity));

        return builder;
    }
}
