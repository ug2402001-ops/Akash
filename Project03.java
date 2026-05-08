class Order {
    
    // Attributes
    public String productName;
    private double unitPrice;
    private int quantity;

    // Constructor
    public Order(String name, double price, int qty) throws Exception {

        if (price <= 0) {
            throw new Exception("Unit price must be greater than zero.");
        }

        if (qty <= 0) {
            throw new Exception("Quantity must be greater than zero.");
        }

        productName = name;
        unitPrice = price;
        quantity = qty;
    }

    // Setter for unit price
    public void setUnitPrice(double price) throws Exception {

        if (price <= 0) {
            throw new Exception("Unit price must be greater than zero.");
        }

        unitPrice = price;
    }

    // Setter for quantity
    public void setQuantity(int qty) throws Exception {

        if (qty <= 0) {
            throw new Exception("Quantity must be greater than zero.");
        }

        quantity = qty;
    }

    // Method to calculate total
    public double calculateTotal() {
        return unitPrice * quantity;
    }

    // toString() method
    @Override
    public String toString() {
        return productName + " - " + quantity + 
               " pcs x " + unitPrice + 
               " = " + calculateTotal();
    }
}

public class Project03
 {

    public static void main(String[] args) {

        System.out.println("--- Order Test ---");

        try {

            // Valid Orders
            Order order1 = new Order(
                "Gaming Mouse", 25.75, 3);

            Order order2 = new Order(
                "Mechanical Keyboard", 120.0, 1);

            System.out.println(order1);
            System.out.println(order2);

            // Invalid Order
            System.out.println(
                "--- Invalid Order Attempt ---");

            Order order3 = new Order(
                "Monitor", -50, 2);

            System.out.println(order3);

        } 
        
        catch (Exception e) {

            System.out.println(
                "Error: " + e.getMessage());
        }
    }
}