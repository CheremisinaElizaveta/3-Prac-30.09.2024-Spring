package com.web_project.shop.service;

import com.web_project.shop.model.StudentModel;

import java.util.List;

public interface StudentService {
    public List<StudentModel> findAllStudents();
    public StudentModel findStudentById(Long id);
    public StudentModel AddStudent(StudentModel student);
    public StudentModel updateStudent(StudentModel student);
    public void deleteStudent(Long id);



}
