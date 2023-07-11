package com.example.practice.application;

import com.example.practice.adapter.repository.StudentRepository;
import com.example.practice.domain.Student;
import com.example.practice.domain.exceptions.StudentNotFoundException;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, String fieldName, Object fieldValue) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found"));

        try {
            Field field = existingStudent.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(existingStudent, fieldValue);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new IllegalArgumentException("Invalid field name: " + fieldName);
        }

        return studentRepository.save(existingStudent);
    }
}
