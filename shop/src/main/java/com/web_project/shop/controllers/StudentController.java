package com.web_project.shop.controllers;

import com.web_project.shop.model.StudentModel;
import com.web_project.shop.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping ("/students")
public class StudentController {

    @Autowired
    public StudentService studentService;

    @GetMapping("/all")
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.findAllStudents());
        model.addAttribute("student", new StudentModel());
        return "studentList";
    }

    @PostMapping("/add")
    public String addStudent(@Valid @ModelAttribute("student") StudentModel student, BindingResult result, Model model) {
        /*StudentModel newStudent = new StudentModel(0, name, firstName, lastName, corpEmail);*/
        if (result.hasErrors()) {
            model.addAttribute("students", studentService.findAllStudents());
            return "studentList";
        }
        studentService.AddStudent(student);
        return "redirect:/students/all";

    }

    @PostMapping("/update")
    public String updateStudent(@Valid @ModelAttribute("student") StudentModel student, BindingResult result) {
        /*  StudentModel newStudent = new StudentModel(id, name, firstName, lastName, corpEmail);*/
        studentService.updateStudent(student);
        return "redirect:/students/all";
    }


    @PostMapping("/delete")
    public String deleteStudent(@RequestParam Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students/all";
    }

    @GetMapping("/all/{id}")
    public String getIdStudents(@PathVariable("id") Long id, Model model) {
        model.addAttribute("students", studentService.findStudentById(id));
        model.addAttribute("student", new StudentModel());
        return "studentList";
    }


}

