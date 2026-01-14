package com.example.studentmanager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Student;

@RestController
@RequestMapping("/api")
public class StudentController {

    // http://localhost:8080/api/greet?name=Hieu
    @GetMapping("/greet")
    public String greet(@RequestParam String name) {
        return "Xin chào " + name;
    }

    // http://localhost:8080/api/students/search?keyword=java&page=2
    @GetMapping("/students/search")
    public String search(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "1") int page) {
        return "keyword=" + keyword + ", page=" + page;
    }

    // Bài 3: Path Variable
    // http://localhost:8080/api/students/10
    @GetMapping("/students/{id}")
    public String getStudent(@PathVariable int id) {
        return "Sinh viên có mã: " + id;
    }

    //Bai4: 
    //http://localhost:8080/api/student
     @GetMapping("/student")
    public Student getStudent() {
        return new Student(1, "Nguyễn Tạ Thảo Kiên", 20);
    }

    // Bài 5: Trả về danh sách sinh viên
    // http://localhost:8080/api/students
    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> list = new ArrayList<>();

        list.add(new Student(1, "A", 20));
        list.add(new Student(2, "B", 21));
        list.add(new Student(3, "C", 22));

        return list;
    }

}
// update commit

