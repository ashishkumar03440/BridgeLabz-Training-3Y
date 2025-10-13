// import java.util.*;

class Doctor {
    String name;
    Doctor(String name) { this.name = name; }

    void consult(Patient p) {
        System.out.println("Doctor " + name + " is consulting Patient " + p.name);
    }
}

class Patient {
    String name;
    Patient(String name) { this.name = name; }
}

class Hospital {
    String hospitalName;
    Hospital(String hospitalName) { this.hospitalName = hospitalName; }
}

public class HospitalDemo {
    public static void main(String[] args) {
        Doctor d1 = new Doctor("Dr. Arjun");
        Doctor d2 = new Doctor("Dr. Meera");

        Patient p1 = new Patient("Rohan");
        Patient p2 = new Patient("Priya");

        d1.consult(p1);
        d2.consult(p2);
        d1.consult(p2);
    }
}

