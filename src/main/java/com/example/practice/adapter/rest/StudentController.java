package com.example.practice.adapter.rest;

import com.example.practice.application.StudentService;
import com.example.practice.domain.Student;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("practice/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable Long id,
            @RequestParam String fieldName,
            @RequestParam Object fieldValue) {
        return studentService.updateStudent(id, fieldName, fieldValue);
    }
}
