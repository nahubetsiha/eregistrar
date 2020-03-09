package com.swe.lab.erigistrar.service;

import com.swe.lab.erigistrar.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> getStudents();
    Student saveStudent(Student student);
    void deleteStudent(Long id);
}
