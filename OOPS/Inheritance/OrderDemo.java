package OOPS.Inheritance;

class Order {
    int orderId;
    String orderDate;

    Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }
}

class ShippedOrder extends Order {
    String trackingNumber;

    ShippedOrder(int orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }
}

class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    DeliveredOrder(int orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    String getOrderStatus() {
        return "Delivered on " + deliveryDate + ", Tracking: " + trackingNumber;
    }
}

public class OrderDemo {
    public static void main(String[] args) {
        DeliveredOrder d = new DeliveredOrder(101, "2025-09-20", "TRK123", "2025-09-25");
        System.out.println(d.getOrderStatus());
    }
}
