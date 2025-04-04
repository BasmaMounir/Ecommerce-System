import java.util.Date;

class Product {
    String name;
    double price;
    int quantity;
    boolean isShipping;
    double weight;
    String expiryDate;

    public Product(String name, double price, int quantity, boolean isShipping, double weight, String expiryDate) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isShipping = isShipping;
        this.weight = weight;
        this.expiryDate = expiryDate;
    }
}