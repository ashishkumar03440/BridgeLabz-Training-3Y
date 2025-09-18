package EPIAndA;

import java.util.ArrayList;
import java.util.List;

// Interface
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// Abstract class
abstract class Patient implements MedicalRecord {
    private int patientId;
    private String name;
    private final int age;
    private List<String> medicalHistory;  // encapsulated sensitive data

    // Constructor
    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.medicalHistory = new ArrayList<>();
    }

    // Getters (Encapsulation)
    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Abstract method
    public abstract double calculateBill();

    // Concrete method
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId + ", Name: " + name + ", Age: " + age);
    }

    // Interface methods for MedicalRecord
    @Override
    public void addRecord(String record) {
        medicalHistory.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for " + name + ":");
        for (String record : medicalHistory) {
            System.out.println(" - " + record);
        }
    }
}

// Subclass for InPatient
class InPatient extends Patient {
    private int daysAdmitted;
    private double dailyRate;

    public InPatient(int patientId, String name, int age, int daysAdmitted, double dailyRate) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyRate;
    }
}

// Subclass for OutPatient
class OutPatient extends Patient {
    private double consultationFee;

    public OutPatient(int patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }
}

// Main class
public class HospitalPatientManagement {
    public static void processPatients(Patient[] patients) {
        for (Patient p : patients) {
            p.getPatientDetails();
            p.viewRecords();
            System.out.println("Total Bill: " + p.calculateBill());
            System.out.println("-----------------------------------");
        }
    }

    public static void main(String[] args) {
        InPatient ip = new InPatient(101, "Alice", 30, 5, 2000);
        ip.addRecord("Admitted for surgery");
        ip.addRecord("Post-surgery observation");

        OutPatient op = new OutPatient(102, "Bob", 25, 500);
        op.addRecord("Routine check-up");
        op.addRecord("Prescribed medicines");

        Patient[] patients = {ip, op};
        processPatients(patients);
    }
}
