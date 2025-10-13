import java.util.*;

class Employee {
    String name;
    Employee(String name) { this.name = name; }
}

class Department {
    String deptName;
    List<Employee> employees = new ArrayList<>();

    Department(String deptName) {
        this.deptName = deptName;
    }

    void addEmployee(Employee e) {
        employees.add(e);
    }
}

class Company {
    String companyName;
    List<Department> departments = new ArrayList<>();

    Company(String name) {
        this.companyName = name;
    }

    void addDepartment(Department d) {
        departments.add(d);
    }

    void showStructure() {
        System.out.println("Company: " + companyName);
        for (Department d : departments) {
            System.out.println(" Department: " + d.deptName);
            for (Employee e : d.employees) {
                System.out.println("  Employee: " + e.name);
            }
        }
    }
}

public class CompositionDemo {
    public static void main(String[] args) {
        Company c = new Company("TechCorp");
        Department d1 = new Department("IT");
        Department d2 = new Department("HR");

        d1.addEmployee(new Employee("Raj"));
        d2.addEmployee(new Employee("Meera"));

        c.addDepartment(d1);
        c.addDepartment(d2);

        c.showStructure();
        // If company is deleted => departments & employees are gone (composition)
    }
}

