package EPIAndA;
// File: OnlineFoodDeliverySystem.java
// Folder: KeywordsAndOperators

// Interface
interface Discountable {
    double applyDiscount(double totalPrice);
    String getDiscountDetails();
}

// Abstract class
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    // Constructor
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Encapsulation (getters and setters)
    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Abstract method
    public abstract double calculateTotalPrice();

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity);
    }
}

// VegItem class
class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity(); // no extra charge
    }

    @Override
    public double applyDiscount(double totalPrice) {
        return totalPrice * 0.9; // 10% discount
    }

    @Override
    public String getDiscountDetails() {
        return "Veg item: 10% discount applied.";
    }
}

// NonVegItem class
class NonVegItem extends FoodItem implements Discountable {
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        // Adding extra charge for non-veg items
        return (getPrice() * getQuantity()) + 50;
    }

    @Override
    public double applyDiscount(double totalPrice) {
        return totalPrice * 0.85; // 15% discount
    }

    @Override
    public String getDiscountDetails() {
        return "Non-Veg item: 15% discount applied.";
    }
}

// Main class
public class OnlineFoodDeliverySystem {
    public static void processOrder(FoodItem[] items) {
        for (FoodItem item : items) {
            item.getItemDetails();
            double totalPrice = item.calculateTotalPrice();

            if (item instanceof Discountable) {
                Discountable d = (Discountable) item;
                System.out.println(d.getDiscountDetails());
                totalPrice = d.applyDiscount(totalPrice);
            }

            System.out.println("Final Price: " + totalPrice);
            System.out.println("-----------------------------------");
        }
    }

    public static void main(String[] args) {
        FoodItem[] order = {
            new VegItem("Paneer Butter Masala", 200, 2),
            new NonVegItem("Chicken Biryani", 300, 1),
            new VegItem("Veg Burger", 100, 3)
        };

        processOrder(order);
    }
}
