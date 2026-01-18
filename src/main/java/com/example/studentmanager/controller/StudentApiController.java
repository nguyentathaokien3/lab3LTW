package com.example.studentmanager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentmanager.entity.Student;


@RestController
@RequestMapping("/api")
public class StudentApiController {

    // http://localhost:8080/api/student
    @GetMapping("/student")
    public Student getStudent() {
        return new Student(1, "Nguyễn Tạ Thảo Kiên", "kien@gmail.com");
    }

    // http://localhost:8080/api/students
    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "A", "a@gmail.com"));
        list.add(new Student(2, "B", "b@gmail.com"));
        list.add(new Student(3,  "C", "c@gmail.com"));
        return list;
    }
}
