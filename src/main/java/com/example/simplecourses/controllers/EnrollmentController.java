package com.example.simplecourses.controllers;


import com.example.simplecourses.domain.Course;
import com.example.simplecourses.domain.Enrollment;
import com.example.simplecourses.domain.Student;
import com.example.simplecourses.service.CourseService;
import com.example.simplecourses.service.EnrollmentService;
import com.example.simplecourses.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;
    private final StudentService studentService;
    private final CourseService courseService;

    public EnrollmentController(EnrollmentService enrollmentService,
                                StudentService studentService,
                                CourseService courseService) {
        this.enrollmentService = enrollmentService;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @GetMapping
    public String listEnrollments(Model model) {
        model.addAttribute("enrollments", enrollmentService.findAll());
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("courses", courseService.findAll());
        return "admin-enrollments";
    }

    @PostMapping
    public String addEnrollment(@RequestParam Long studentId,
                                @RequestParam Long courseId) {

        Student student = studentService.findById(studentId);
        Course course = courseService.findById(courseId);

        Enrollment enrollment = new Enrollment(student, course);
        enrollmentService.save(enrollment);

        return "redirect:/admin/enrollments";
    }

    @PostMapping("/delete/{id}")
    public String deleteEnrollment(@PathVariable Long id) {
        enrollmentService.delete(id);
        return "redirect:/admin/enrollments";
    }
}
