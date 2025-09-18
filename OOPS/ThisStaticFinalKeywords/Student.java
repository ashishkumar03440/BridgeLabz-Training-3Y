package ThisStaticFinalKeywords;

public class Student {
    static String universityName = "XYZ University";
    static int totalStudents = 0;
    final int rollNumber;
    String name, grade;

    Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    static void displayTotalStudents() {
        System.out.println(totalStudents);
    }

    void displayDetails() {
        if (this instanceof Student) {
            System.out.println(universityName + " " + name + " " + rollNumber + " " + grade);
        }
    }

    public static void main(String[] args) {
        Student s = new Student("Priya", 1, "A");
        s.displayDetails();
        displayTotalStudents();
    }
}
