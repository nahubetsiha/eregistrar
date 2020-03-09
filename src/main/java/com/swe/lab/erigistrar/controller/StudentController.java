package com.swe.lab.erigistrar.controller;

import com.swe.lab.erigistrar.repository.IStudentRepository;
import com.swe.lab.erigistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.swe.lab.erigistrar.model.Student;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.Optional;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    IStudentRepository studentRepository;

    @GetMapping(value = {"students/list"})
    public ModelAndView getStudents(@ModelAttribute("student") Student student){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", studentService.getStudents());
        modelAndView.addObject("studentLength", studentService.getStudents().size());
        modelAndView.setViewName("student/list-student");
        return modelAndView;
    }

    @GetMapping({"/addStudent", "/editStudent/{id}"})
    public String getStudentForm(@ModelAttribute("student") Student student, Model model, @PathVariable("id") Optional<Long> id){
        if (id.isPresent()) {
            Optional<Student> entity = studentRepository.findById(id.get());
            Student editStudent = entity.get();
            model.addAttribute("student", editStudent);
        } else {
            model.addAttribute("student", new Student());
        }
        return "student/add-student";

    }

    @PostMapping("/addStudent")
    public String addStudent(@ModelAttribute("student") Student student, RedirectAttributes ra){
//        model.addAttribute("student", new Student());
//        String StudentNumber = (String) model.getAttribute("StudentNumber");
//        String FirstName = (String) model.getAttribute("FirstName");
//        String MiddleName = (String) model.getAttribute("MiddleName");
//        String LastName = (String) model.getAttribute("LastName");
//        double GPA = (double) model.getAttribute("GPA");
//        LocalDate datepicker = (LocalDate) model.getAttribute("datepicker");
//        Boolean International = (Boolean) model.getAttribute("International");
//        Student newStudent = new Student(StudentNumber, FirstName, MiddleName, LastName, GPA, datepicker, International);
        ra.addFlashAttribute("savedStudent", student);
        studentService.saveStudent((student));
        return "redirect:/students/list";
    }

    @GetMapping(value = {"/", "/home", "/eregistrar/home"})
    public String goToHomepage(){
        return "home/index";
    }

    @RequestMapping(path = "/deleteStudent/{id}")
    public String deleteStudent(Model model, @PathVariable("id") Long id)
    {
        studentService.deleteStudent(id);
        return "redirect:/students/list";
    }

    @RequestMapping(path = "/editStudent/{id}")
    public String editStudent(Model model, @PathVariable("id") Optional<Long> id){
        if (id.isPresent()) {
            Optional<Student> entity = studentRepository.findById(id.get());
            Student editStudent = entity.get();
            model.addAttribute("student", editStudent);
        } else {
            model.addAttribute("student", new Student());
        }
        return "student/add-student";
    }

}
