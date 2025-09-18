package EPIAndA;

public class RideHailingApplication {
    public static void calculateRides(Vehicle[] rides, double distance) {
        for (Vehicle v : rides) {
            v.getVehicleDetails();
            System.out.println("Current Location: " + v.getCurrentLocation());
            double fare = v.calculateFare(distance);
            System.out.println("Fare for " + distance + " km: " + fare);
            System.out.println("-----------------------------------");
        }
    }

    public static void main(String[] args) {
        Vehicle car = new Car(201, "Arjun", 15, "Downtown");
        Vehicle bike = new Bike(202, "Ravi", 8, "Airport");
        Vehicle auto = new Auto(203, "Suresh", 10, "Railway Station");

        Vehicle[] rides = {car, bike, auto};

        calculateRides(rides, 12.5); // Distance = 12.5 km
    }
}
