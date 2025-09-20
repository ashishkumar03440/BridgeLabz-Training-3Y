package OOPS.Inheritance;

class Device {
    String deviceId;
    String status;

    Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }
}

class Thermostat extends Device {
    int temperatureSetting;

    Thermostat(String deviceId, String status, int temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    void displayStatus() {
        System.out.println("Device ID: " + deviceId + ", Status: " + status +
                           ", Temp Setting: " + temperatureSetting + "°C");
    }
}

public class SmartHomeDemo {
    public static void main(String[] args) {
        Thermostat t = new Thermostat("TH123", "ON", 24);
        t.displayStatus();
    }
}
