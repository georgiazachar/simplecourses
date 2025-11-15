package com.example.simplecourses;

import com.example.simplecourses.domain.Course;
import com.example.simplecourses.domain.Enrollment;
import com.example.simplecourses.domain.Student;
import com.example.simplecourses.service.CourseService;
import com.example.simplecourses.service.EnrollmentService;
import com.example.simplecourses.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CourseService courseService;
    private final StudentService studentService;
    private final EnrollmentService enrollmentService;

    public DataInitializer(CourseService courseService,
                           StudentService studentService,
                           EnrollmentService enrollmentService) {
        this.courseService = courseService;
        this.studentService = studentService;
        this.enrollmentService = enrollmentService;
    }

    @Override
    public void run(String... args) {
        initCourses();
        initStudents();
        initEnrollments();
    }

    private void initCourses() {
        if (!courseService.findAll().isEmpty()) {
            return;
        }

        Course c1 = new Course("Εισαγωγή στη Java", "Βασικές έννοιες Java και OOP");
        Course c2 = new Course("Spring Boot για Αρχάριους", "Δημιουργία απλών web εφαρμογών");
        Course c3 = new Course("Βάσεις Δεδομένων", "SQL και σχεσιακά μοντέλα");

        courseService.save(c1);
        courseService.save(c2);
        courseService.save(c3);

        System.out.println(">>> Demo courses inserted");
    }

    private void initStudents() {
        if (!studentService.findAll().isEmpty()) {
            return;
        }

        Student s1 = new Student("Μαρία Παπαδοπούλου", "maria@example.com");
        Student s2 = new Student("Γιάννης Δημητρίου", "giannis@example.com");
        Student s3 = new Student("Ελένη Κωνσταντίνου", "eleni@example.com");

        studentService.save(s1);
        studentService.save(s2);
        studentService.save(s3);

        System.out.println(">>> Demo students inserted");
    }

    private void initEnrollments() {
        if (!enrollmentService.findAll().isEmpty()) {
            return;
        }

        List<Student> students = studentService.findAll();
        List<Course> courses = courseService.findAll();

        if (students.isEmpty() || courses.isEmpty()) {
            return;
        }

        // λίγες demo εγγραφές
        Enrollment e1 = new Enrollment(students.get(0), courses.get(0));
        Enrollment e2 = new Enrollment(students.get(0), courses.get(1));
        Enrollment e3 = new Enrollment(students.get(1), courses.get(1));
        Enrollment e4 = new Enrollment(students.get(2), courses.get(2));

        enrollmentService.save(e1);
        enrollmentService.save(e2);
        enrollmentService.save(e3);
        enrollmentService.save(e4);

        System.out.println(">>> Demo enrollments inserted");
    }
}