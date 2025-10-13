import java.util.*;

class Faculty {
    String name;
    Faculty(String name) { this.name = name; }
}

class DepartmentU {
    String deptName;
    DepartmentU(String deptName) { this.deptName = deptName; }
}

class University {
    String uniName;
    List<DepartmentU> departments = new ArrayList<>();
    List<Faculty> faculties = new ArrayList<>();

    University(String uniName) { this.uniName = uniName; }

    void addDepartment(DepartmentU d) { departments.add(d); }
    void addFaculty(Faculty f) { faculties.add(f); }

    void showStructure() {
        System.out.println("University: " + uniName);
        for (DepartmentU d : departments) System.out.println(" Department: " + d.deptName);
        for (Faculty f : faculties) System.out.println(" Faculty: " + f.name);
    }
}

public class UniversityDemo {
    public static void main(String[] args) {
        University u = new University("Delhi University");

        u.addDepartment(new DepartmentU("Engineering"));
        u.addDepartment(new DepartmentU("Arts"));

        Faculty f1 = new Faculty("Dr. Sharma");
        u.addFaculty(f1);

        u.showStructure();
        // Deleting University → departments gone, but Faculty may exist independently
    }
}
