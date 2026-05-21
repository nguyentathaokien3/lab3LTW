package com.example.studentmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.studentmanager.entity.Student;
import com.example.studentmanager.service.StudentService;

@Controller
@RequestMapping("/students") // ✅ gộp URL cho gọn
public class StudentViewController {

    @Autowired
    private StudentService studentService;

    // ================== HIỂN THỊ ==================
    // http://localhost:8080/students
    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    // ================== THÊM ==================
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("student", new Student());
        return "form";
    }

    // ================== LƯU (THÊM + SỬA) ==================
    @PostMapping("/save")
    public String save(@ModelAttribute("student") Student student) {
        studentService.save(student);
        return "redirect:/students";
    }

    // ================== SỬA ==================
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {

        Student student = studentService.getById(id);

        // ❗ tránh lỗi null
        if (student == null) {
            return "redirect:/students";
        }

        model.addAttribute("student", student);
        return "form";
    }

    // ================== XÓA ==================
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        studentService.delete(id);
        return "redirect:/students";
    }
}