import java.util.*;

class Professor {
    String name;
    Professor(String name) { this.name = name; }
}

class CourseUMS {
    String courseName;
    Professor professor;
    List<StudentUMS> students = new ArrayList<>();

    CourseUMS(String courseName) { this.courseName = courseName; }

    void assignProfessor(Professor p) {
        this.professor = p;
        System.out.println("Professor " + p.name + " assigned to " + courseName);
    }

    void enroll(StudentUMS s) {
        students.add(s);
        System.out.println(s.name + " enrolled in " + courseName);
    }
}

class StudentUMS {
    String name;
    StudentUMS(String name) { this.name = name; }

    void enrollCourse(CourseUMS c) {
        c.enroll(this);
    }
}

public class UniversityManagementDemo {
    public static void main(String[] args) {
        Professor prof = new Professor("Dr. Gupta");
        CourseUMS c1 = new CourseUMS("AI");
        CourseUMS c2 = new CourseUMS("DSA");

        c1.assignProfessor(prof);

        StudentUMS s1 = new StudentUMS("Karan");
        s1.enrollCourse(c1);
        s1.enrollCourse(c2);
    }
}

