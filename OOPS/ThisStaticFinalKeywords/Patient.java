package ThisStaticFinalKeywords;

public class Patient {
    static String hospitalName = "City Hospital";
    static int totalPatients = 0;
    final int patientID;
    String name, ailment;
    int age;

    Patient(String name, int age, String ailment, int patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }

    static void getTotalPatients() {
        System.out.println(totalPatients);
    }

    void displayDetails() {
        if (this instanceof Patient) {
            System.out.println(hospitalName + " " + name + " " + age + " " + ailment + " " + patientID);
        }
    }

    public static void main(String[] args) {
        Patient p = new Patient("Sonia", 30, "Flu", 1001);
        p.displayDetails();
        getTotalPatients();
    }
}
