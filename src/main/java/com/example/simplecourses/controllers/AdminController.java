package com.example.simplecourses.controllers;

import com.example.simplecourses.domain.Course;
import com.example.simplecourses.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final CourseService courseService;

    public AdminController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public String adminCourses(Model model) {
        model.addAttribute("courses", courseService.findAll());
        model.addAttribute("course", new Course());
        return "admin-courses";
    }

    @PostMapping("/courses")
    public String addCourse(@ModelAttribute Course course) {
        courseService.save(course);
        return "redirect:/admin/courses";
    }

    @PostMapping("/courses/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.delete(id);
        return "redirect:/admin/courses";
    }
}
