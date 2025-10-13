import java.util.*;

class Product {
    String name;
    double price;
    Product(String name, double price) { this.name = name; this.price = price; }
}

class Order {
    List<Product> products = new ArrayList<>();
    void addProduct(Product p) { products.add(p); }
    void showOrder() {
        System.out.println("Order contains:");
        for (Product p : products) System.out.println(" " + p.name + " - Rs." + p.price);
    }
}

class Customer {
    String name;
    Customer(String name) { this.name = name; }
    void placeOrder(Order o) {
        System.out.println(name + " placed an order.");
        o.showOrder();
    }
}

public class ECommerceDemo {
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 60000);
        Product p2 = new Product("Mouse", 1000);

        Order o = new Order();
        o.addProduct(p1);
        o.addProduct(p2);

        Customer c = new Customer("Aditya");
        c.placeOrder(o);
    }
}
