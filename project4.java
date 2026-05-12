import java.util.ArrayList;
import java.util.Scanner;

class Order {

    public String productName;
    private double unitPrice;
    private int quantity;

    // Constructor
    public Order(String productName, double unitPrice, int quantity) throws Exception {

        if (unitPrice <= 0) {
            throw new Exception("Unit price must be greater than zero.");
        }

        if (quantity <= 0) {
            throw new Exception("Quantity must be greater than zero.");
        }

        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    // Calculate total
    public double calculateTotal() {
        return unitPrice * quantity;
    }

    // toString method
    public String toString() {

        return productName + " - "
                + quantity + " pcs x "
                + unitPrice + " = "
                + calculateTotal();
    }
}

public class Project4 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<Order> orders = new ArrayList<>();

        System.out.println("--- Welcome to BaseCase Shop ---");

        System.out.print("How many items do you want to purchase? ");

        int itemCount = input.nextInt();
        input.nextLine();

        // Maximum 5 items
        if (itemCount > 5) {

            itemCount = 5;

            System.out.println("Maximum 5 items allowed. Setting to 5.");
        }

        for (int i = 1; i <= itemCount; i++) {

            System.out.print("Enter Product " + i + " Name:");
            String name = input.nextLine();

            System.out.print("Enter Price: ");
            double price = input.nextDouble();

            System.out.print("Enter Quantity: ");
            int quantity = input.nextInt();
            input.nextLine();

            try {

                Order order = new Order(name, price, quantity);

                orders.add(order);

            } catch (Exception e) {

                System.out.println("Error: " + e.getMessage() + " Skipping item.");
            }
        }

        //Calculate Subtotal

        double subtotal = 0;

        for (int i = 0; i < orders.size(); i++) {

            subtotal += orders.get(i).calculateTotal();
        }

        // Calculate discount Logic

        double discountRate;

        if (subtotal > 100) {

            discountRate = 0.20;

        } else if (subtotal > 50) {

            discountRate = 0.10;

        } else {

            discountRate = 0.05;
        }

        double discountAmount = subtotal * discountRate;

        // Delivery Fee 

        double deliveryFee = (subtotal < 50) ? 10 : 0;

        //Final Total

        double finalTotal = subtotal - discountAmount + deliveryFee;

        //Print Receipt

        System.out.println("\n--- Final Receipt ---");

        for (int i = 0; i < orders.size(); i++) {

            System.out.println("Item " + (i + 1) + ": " + orders.get(i));
        }

        System.out.println("\nSubtotal: " + subtotal);

        System.out.println("Discount Applied (" 
                + (discountRate * 100) + "%): " 
                + discountAmount);

        System.out.println("Delivery Fee: " + deliveryFee);

        System.out.println("Final Total: " + finalTotal);

        System.out.println("---------------------------");

        input.close();
    }
}