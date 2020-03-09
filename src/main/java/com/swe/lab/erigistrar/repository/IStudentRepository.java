package com.swe.lab.erigistrar.repository;

import com.swe.lab.erigistrar.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student, Long> {
}
