package com.swe.lab.erigistrar.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentId;
    @Column(nullable = false)
    private String studentNumber;
    @Column(nullable = false)
    private String FirstName;
    private String MiddleName;
    @Column(nullable = false)
    private String LastName;
    private double cGpa;
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate enrollmentDate;
    @Column(nullable = false)
    private boolean international;

    public Student() {
    }

    public Student(String studentNumber, String firstName, String middleName, String lastName, double cGpa, LocalDate enrollmentDate, boolean international) {
        this.studentNumber = studentNumber;
        FirstName = firstName;
        MiddleName = middleName;
        LastName = lastName;
        this.cGpa = cGpa;
        this.enrollmentDate = enrollmentDate;
        this.international = international;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public double getcGpa() {
        return cGpa;
    }

    public void setcGpa(double cGpa) {
        this.cGpa = cGpa;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public boolean getInternational() {
        return international;
    }

    public void setInternational(boolean international) {
        this.international = international;
    }
}
