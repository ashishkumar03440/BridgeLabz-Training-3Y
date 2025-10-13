import java.util.*;

class Course {
    String courseName;
    List<Student> enrolled = new ArrayList<>();
    Course(String courseName) { this.courseName = courseName; }

    void enroll(Student s) {
        enrolled.add(s);
        System.out.println(s.name + " enrolled in " + courseName);
    }

    void showStudents() {
        System.out.println("Students in " + courseName + ":");
        for (Student s : enrolled) System.out.println(" " + s.name);
    }
}

class Student {
    String name;
    List<Course> courses = new ArrayList<>();

    Student(String name) { this.name = name; }

    void addCourse(Course c) {
        courses.add(c);
        c.enroll(this);
    }

    void showCourses() {
        System.out.println(name + " enrolled in:");
        for (Course c : courses) System.out.println(" " + c.courseName);
    }
}

class School {
    // Aggregation: School "has" Students
    List<Student> students = new ArrayList<>();

    void addStudent(Student s) {
        students.add(s);
    }
}

public class SchoolDemo {
    public static void main(String[] args) {
        School school = new School();
        Student s1 = new Student("Aarav");
        Student s2 = new Student("Isha");

        Course c1 = new Course("Math");
        Course c2 = new Course("Science");

        school.addStudent(s1);
        school.addStudent(s2);

        s1.addCourse(c1);
        s1.addCourse(c2);
        s2.addCourse(c1);

        s1.showCourses();
        c1.showStudents();
    }
}

