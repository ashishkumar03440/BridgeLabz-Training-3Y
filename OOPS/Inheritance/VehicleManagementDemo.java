package OOPS.Inheritance;

interface Refuelable {
    void refuel();
}

class VehicleBase {
    int maxSpeed;
    String model;

    VehicleBase(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }
}

class ElectricVehicle extends VehicleBase {
    ElectricVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    void charge() {
        System.out.println(model + " is charging");
    }
}

class PetrolVehicle extends VehicleBase implements Refuelable {
    PetrolVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    public void refuel() {
        System.out.println(model + " is refueling petrol");
    }
}

public class VehicleManagementDemo {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle(150, "Tesla");
        PetrolVehicle pv = new PetrolVehicle(180, "Honda City");

        ev.charge();
        pv.refuel();
    }
}

