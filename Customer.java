import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    String customerName;
    double customerBalance;
    ArrayList<CartItem> cart;

    public Customer(String customerName, double customerBalance) {
        this.customerName = customerName;
        this.customerBalance = customerBalance;
        this.cart = new ArrayList<>();
    }

    public static boolean isExpired(String expiryDateString) {
        LocalDate expiryDate = LocalDate.parse(expiryDateString);
        LocalDate currentDate = LocalDate.now();
        return currentDate.isAfter(expiryDate);
    }

    public void addToCart(Product product, int quantity) {
        if (quantity > product.quantity) {
            System.out.println("!! One of the products is unavailable: " + product.name);
            return;
        }
        if (product.expiryDate!= null && isExpired(product.expiryDate.toString())) {
            System.out.println("!! " + product.name + " Expired.");
            return;
        }
        else {
            cart.add(new CartItem(product, quantity));
            product.quantity -= quantity;
        }
    }

    public void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        double subtotal = 0;
        double shippingFees = 0;
        List<ShippingService> shippingItems = new ArrayList<>();

        for (CartItem item : cart) {
            subtotal += item.product.price * item.quantity;

            if (item.product.isShipping) {
                shippingFees += item.product.weight * 5;
                shippingItems.add(new ShippableProduct(item.product));
            }
        }

        double totalAmount = subtotal + shippingFees;
        if (customerBalance < totalAmount) {
            System.out.println("Your balance is insufficient.");
            return;
        }

        customerBalance -= totalAmount;
        displayCartDetails(subtotal,shippingFees,totalAmount,shippingItems);
    }

    void displayCartDetails(double subtotal,double shippingFees,double totalAmount, List<ShippingService> shippingItems ) {
        System.out.println("Welcome to our store! Dear " + customerName );
        System.out.println("** Checkout receipt **");
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Shipping: " + shippingFees);
        System.out.println("Amount: " + totalAmount);
        System.out.println("Remaining Balance: " + customerBalance);

        if (!shippingItems.isEmpty()) {
            float shippingWeight = 0;
            for (ShippingService service : shippingItems) {
                shippingWeight += service.getWeight();
            }
            System.out.println("Total package weight: "+shippingWeight );
            System.out.println("Your products have been sent to the shipping service.");
        }
    }

}
