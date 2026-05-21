package com.example.studentmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentmanager.entity.Student;
import com.example.studentmanager.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    // Lấy tất cả sinh viên
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // Thêm + Sửa
    public void save(Student student) {
        repository.save(student);
    }

    // Lấy theo ID
    public Student getById(int id) {
        return repository.findById(id).orElse(null);
    }

    // Xóa
    public void delete(int id) {
        repository.deleteById(id);
    }
}