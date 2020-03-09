package com.swe.lab.erigistrar.repository;

import com.swe.lab.erigistrar.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByStudentNumberEquals( String searchString);
}
