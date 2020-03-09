package com.swe.lab.erigistrar.service;

import com.swe.lab.erigistrar.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> getStudents();
    List<Student> searchStudent(String searchString);
    Student saveStudent(Student student);
    void deleteStudent(Long id);
    Student getStudentById(Long id);
}
