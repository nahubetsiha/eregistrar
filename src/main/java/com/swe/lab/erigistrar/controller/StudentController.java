package com.swe.lab.erigistrar.controller;

import com.swe.lab.erigistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.swe.lab.erigistrar.model.Student;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(value = {"students/list"})
    public ModelAndView getStudents(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", studentService.getStudents());
        modelAndView.addObject("studentLength", studentService.getStudents().size());
        modelAndView.setViewName("student/list-student");
        return modelAndView;
    }

    @GetMapping({"/addStudent"})
    public String getStudentForm(Model model){
            model.addAttribute("student", new Student());
        return "student/add-student";
    }

    @PostMapping("/addStudent")
    public String addStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent((student));
        return "redirect:/students/list";
    }

    @GetMapping(value = {"/", "/home", "/eregistrar/home"})
    public String goToHomepage(){
        return "home/index";
    }

    @RequestMapping(path = "/deleteStudent/{id}")
    public String deleteStudent(@PathVariable("id") Long id)
    {
        studentService.deleteStudent(id);
        return "redirect:/students/list";
    }

    @GetMapping(value = "/editStudent/{id}")
    public String editStudentForm(@PathVariable Long id,  Model model){
        Student student = studentService.getStudentById(id);
        model.addAttribute("editStudent", student);
        return "student/edit-student";
    }

    @RequestMapping(path = "/editStudent")
    public String editStudent(@ModelAttribute("editStudent") Student student){
        studentService.saveStudent(student);
        return "redirect:/students/list";
    }

    @GetMapping(value = "/searchStudent")
    public ModelAndView searchStudent(@RequestParam String searchQuery){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", studentService.searchStudent(searchQuery));
        modelAndView.addObject("searchQuery", searchQuery);
        modelAndView.addObject("studentLength", studentService.searchStudent(searchQuery).size());
        modelAndView.setViewName("student/list-student");
        return modelAndView;
    }

}
