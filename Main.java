import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Products that require shipping and have expiration dates
        Product yogurt = new Product("Yogurt", 10, 50, true, 1.5,  "2025-04-23"); // Expiry date
        Product cookies = new Product("Cookies", 25, 20, true, 2, "2025-04-01"); // Expiry date
        Product frozenPizza = new Product("Frozen Pizza", 30, 10, true, 3, "2025-07-01"); // Expiry date

        // Products that do not require shipping (e.g., electronics, office supplies)
        Product smartwatch = new Product("Smartwatch", 1500, 10, false, 0, null); // No expiry, no shipping needed
        Product tablet = new Product("Tablet", 2500, 8, false, 0, null); // No expiry, no shipping needed
        Product headphones = new Product("Headphones", 350, 25, false, 0, null); // No expiry, no shipping needed

        // Products with no expiry and require shipping
        Product refrigerator = new Product("Refrigerator", 8000, 4, true, 70, null); // Requires shipping, no expiry
        Product washingMachine = new Product("Washing Machine", 6000, 3, true, 60, null); // Requires shipping, no expiry

        // Products with no expiry and no shipping requirement
        Product mouse = new Product("Mouse", 100, 30, false, 0, null); // No expiry, no shipping needed
        Product keyboard = new Product("Keyboard", 200, 20, false, 0, null); // No expiry, no shipping needed
        Product powerBank = new Product("Power Bank", 300, 15, false, 0, null); // No expiry, no shipping needed


        Customer customer = new Customer("Basma",10000);
        customer.addToCart(cookies, 20);
        customer.addToCart(yogurt, 10);
        customer.addToCart(powerBank, 1);
        customer.addToCart(tablet, 10);

        customer.checkout();
    }
}
