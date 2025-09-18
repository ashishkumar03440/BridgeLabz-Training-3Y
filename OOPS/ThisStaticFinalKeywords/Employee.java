package ThisStaticFinalKeywords;

public class Employee {
    static String companyName = "Tech Solutions";
    static int totalEmployees = 0;
    final int id;
    String name, designation;

    Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    static void displayTotalEmployees() {
        System.out.println(totalEmployees);
    }

    void displayDetails() {
        if (this instanceof Employee) {
            System.out.println(companyName + " " + name + " " + id + " " + designation);
        }
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Amit", 101, "Manager");
        Employee e2 = new Employee("Neha", 102, "Developer");
        e1.displayDetails();
        e2.displayDetails();
        displayTotalEmployees();
    }
}
