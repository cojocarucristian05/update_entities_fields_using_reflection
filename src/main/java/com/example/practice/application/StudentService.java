package com.example.practice.application;

import com.example.practice.domain.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {

    Student createStudent(Student student);
    Student updateStudent(Long id, String fieldName, Object fieldValue);
}
