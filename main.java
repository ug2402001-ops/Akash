class main {
    // Attributes
    public String productName;
    private double unitPrice;
    private int quantity;
    
    // Constructor with validation
    public main(String productName, double unitPrice, int quantity) throws Exception {
        this.productName = productName;
        setUnitPrice(unitPrice);
        setQuantity(quantity);
    }
    
    // Setter for unitPrice with validation
    public void setUnitPrice(double price) throws Exception {
        if (price <= 0) {
            throw new Exception("Unit price must be greater than zero.");
        }
        this.unitPrice = price;
    }
    
    // Setter for quantity with validation
    public void setQuantity(int qty) throws Exception {
        if (qty <= 0) {
            throw new Exception("Quantity must be greater than zero.");
        }
        this.quantity = qty;
    }
    
    // Getter methods
    public double getUnitPrice() {
        return unitPrice;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    // Method to calculate total
    public double calculateTotal() {
        return unitPrice * quantity;
    }
    
    // toString method
    public String toString() {
        return productName + " - " + quantity + " pcs x " + unitPrice + " = " + calculateTotal();
    }
    
    // Main method for testing
    public static void main(String[] args) {
        System.out.println("--- Order Test ---");
        
        try {
            
            main order1 = new main("Gaming Mouse", 25.75, 3);
            main order2 = new main("Mechanical Keyboard", 120.0, 1);
            
            // Print the orders
            System.out.println(order1);
            System.out.println(order2);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("--- Invalid Order Attempt ---");
        
        // Attempt to create invalid order for negative price
        try {
            main invalidOrder1 = new main("Monitor", -10.0, 2);
            System.out.println(invalidOrder1);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        // Attempt to create invalid order for zero quantity
        try {
            main invalidOrder2 = new main("Another Item", 15.0, 0);
            System.out.println(invalidOrder2);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}