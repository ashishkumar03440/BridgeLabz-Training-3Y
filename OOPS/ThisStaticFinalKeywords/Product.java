package ThisStaticFinalKeywords;

public class Product {
    static double discount = 10.0;
    final int productID;
    String productName;
    double price;
    int quantity;

    Product(int productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    static void updateDiscount(double d) {
        discount = d;
    }

    void displayDetails() {
        if (this instanceof Product) {
            System.out.println(productID + " " + productName + " " + price + " " + quantity + " " + discount);
        }
    }

    public static void main(String[] args) {
        Product p = new Product(1, "Laptop", 50000.0, 2);
        updateDiscount(15.0);
        p.displayDetails();
    }
}
