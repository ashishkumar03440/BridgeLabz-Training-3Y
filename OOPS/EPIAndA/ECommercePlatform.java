package EPIAndA;

// File: KeywordsAndOperators/ECommercePlatform.java

import java.util.*;

// Abstract Product class
abstract class Product {
    private int productId;
    private String name;
    private double price;

    // Constructor
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Getters and Setters (Encapsulation)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Abstract method
    public abstract double calculateDiscount();

    // Display details
    public void displayProductDetails() {
        System.out.println("ID   : " + productId);
        System.out.println("Name : " + name);
        System.out.println("Price: " + price);
    }
}

// Taxable interface
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Electronics class
class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18; // 18% GST
    }

    @Override
    public String getTaxDetails() {
        return "18% GST applied";
    }
}

// Clothing class
class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20; // 20% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05; // 5% GST
    }

    @Override
    public String getTaxDetails() {
        return "5% GST applied";
    }
}

// Groceries class
class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }

    // Groceries are tax-free (not implementing Taxable)
}

// Main class
public class ECommercePlatform {

    // Method to calculate final price (Polymorphism)
    public static void printFinalPrices(List<Product> products) {
        for (Product p : products) {
            p.displayProductDetails();
            double discount = p.calculateDiscount();
            double tax = 0;

            if (p instanceof Taxable) {
                Taxable t = (Taxable) p;
                tax = t.calculateTax();
                System.out.println(t.getTaxDetails());
            } else {
                System.out.println("No tax applied");
            }

            double finalPrice = p.getPrice() + tax - discount;
            System.out.println("Discount Applied : " + discount);
            System.out.println("Final Price      : " + finalPrice);
            System.out.println("----------------------------------");
        }
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        // Sample products
        Product e1 = new Electronics(201, "Smartphone", 30000);
        Product c1 = new Clothing(202, "T-Shirt", 1500);
        Product g1 = new Groceries(203, "Apples", 200);

        products.add(e1);
        products.add(c1);
        products.add(g1);

        // Polymorphism in action
        printFinalPrices(products);
    }
}

