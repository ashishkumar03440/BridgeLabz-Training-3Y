package ThisStaticFinalKeywords;

public class Vehicle {
    static double registrationFee = 1200.0;
    final String registrationNumber;
    String ownerName, vehicleType;

    Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }

    void displayDetails() {
        if (this instanceof Vehicle) {
            System.out.println(ownerName + " " + vehicleType + " " + registrationNumber + " " + registrationFee);
        }
    }

    public static void main(String[] args) {
        Vehicle v = new Vehicle("Ankit", "Car", "UP32ZX1234");
        updateRegistrationFee(1500.0);
        v.displayDetails();
    }
}
