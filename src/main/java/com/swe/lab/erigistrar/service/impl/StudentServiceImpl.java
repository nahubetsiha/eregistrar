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
    public Student saveStudent(Student student) {

        if(student.getStudentId()==null){
            return studentRepository.save(student);
        } else {
            Optional<Student> editStudent = studentRepository.findById(student.getStudentId());
            if(editStudent.isPresent()){
                Student newStudent = editStudent.get();
                newStudent.setStudentNumber(student.getStudentNumber());
                newStudent.setFirstName(student.getFirstName());
                newStudent.setLastName(student.getLastName());
                newStudent.setMiddleName(student.getMiddleName());
                newStudent.setcGpa(student.getcGpa());
                newStudent.setEnrollmentDate(student.getEnrollmentDate());
                newStudent.setInternational(student.getInternational());

                return studentRepository.save(newStudent);
            }else {
                return studentRepository.save(student);
            }
        }
    }

//    public void editStudent(Long id){
//        Optional<Student> student = studentRepository.findById(id);
//
//    }

    @Override
    public void deleteStudent(Long id)
    {
        Optional<Student> student = studentRepository.findById(id);

        if(student.isPresent())
        {
            studentRepository.deleteById(id);
        }
    }
}
