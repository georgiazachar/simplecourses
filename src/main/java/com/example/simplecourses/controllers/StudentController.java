package com.example.simplecourses.controllers;

import com.example.simplecourses.domain.Student;
import com.example.simplecourses.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("student", new Student());
        return "admin-students";
    }

    @PostMapping
    public String addStudent(@ModelAttribute Student student) {
        studentService.save(student);
        return "redirect:/admin/students";
    }

    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.delete(id);
        return "redirect:/admin/students";
    }
}
