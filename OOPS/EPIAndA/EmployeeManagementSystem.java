package EPIAndA;

// File: KeywordsAndOperators/EmployeeManagementSystem.java

import java.util.*;

// Abstract class Employee
abstract class Employee {
    // Encapsulation: private fields
    private int employeeId;
    private String name;
    private double baseSalary;

    // Constructor
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Getters and Setters
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    // Abstract method
    public abstract double calculateSalary();

    // Concrete method
    public void displayDetails() {
        System.out.println("ID      : " + employeeId);
        System.out.println("Name    : " + name);
        System.out.println("Base Salary: " + baseSalary);
    }
}

// Department interface
interface Department {
    void assignDepartment(String dept);
    String getDepartmentDetails();
}

// FullTimeEmployee subclass
class FullTimeEmployee extends Employee implements Department {
    private String department;

    public FullTimeEmployee(int employeeId, String name, double baseSalary) {
        super(employeeId, name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        // Fixed monthly salary
        return getBaseSalary();
    }

    @Override
    public void assignDepartment(String dept) {
        this.department = dept;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}

// PartTimeEmployee subclass
class PartTimeEmployee extends Employee implements Department {
    private String department;
    private int workHours;
    private double hourlyRate;

    public PartTimeEmployee(int employeeId, String name, double hourlyRate, int workHours) {
        super(employeeId, name, 0); // baseSalary not used for part-time
        this.hourlyRate = hourlyRate;
        this.workHours = workHours;
    }

    @Override
    public double calculateSalary() {
        // Salary based on hours worked
        return hourlyRate * workHours;
    }

    @Override
    public void assignDepartment(String dept) {
        this.department = dept;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}

// Main Class
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        // Polymorphism: Employee reference for different objects
        List<Employee> employees = new ArrayList<>();

        FullTimeEmployee fte = new FullTimeEmployee(101, "Alice", 50000);
        fte.assignDepartment("HR");

        PartTimeEmployee pte = new PartTimeEmployee(102, "Bob", 500, 40);
        pte.assignDepartment("IT");

        employees.add(fte);
        employees.add(pte);

        // Display employee details polymorphically
        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println("Calculated Salary: " + emp.calculateSalary());

            // Access department details through interface
            if (emp instanceof Department) {
                Department dept = (Department) emp;
                System.out.println(dept.getDepartmentDetails());
            }
            System.out.println("-----------------------------");
        }
    }
}

    

