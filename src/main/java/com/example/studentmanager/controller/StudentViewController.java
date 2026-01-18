package com.example.studentmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.studentmanager.service.StudentService;

@Controller
public class StudentViewController {

    @Autowired
    private StudentService studentService;

    // http://localhost:8080/students
    @GetMapping("/students")
    public String students(Model model) {
        model.addAttribute("students",
                studentService.getAllStudents());
        return "students"; // students.html
    }
}
