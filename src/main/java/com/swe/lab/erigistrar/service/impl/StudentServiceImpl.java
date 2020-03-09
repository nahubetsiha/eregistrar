package com.swe.lab.erigistrar.service.impl;

import com.swe.lab.erigistrar.model.Student;
import com.swe.lab.erigistrar.repository.IStudentRepository;
import com.swe.lab.erigistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    IStudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(IStudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> searchStudent(String searchString) {
        return studentRepository.findAllByStudentNumberEquals(searchString);
    }

    @Override
    public Student saveStudent(Student student) {
            return studentRepository.save(student);
    }


    @Override
    public void deleteStudent(Long id)
    {
        Optional<Student> student = studentRepository.findById(id);

        if(student.isPresent())
        {
            studentRepository.deleteById(id);
        }
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.getOne(id);
    }
}
