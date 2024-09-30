package com.web_project.shop.service;

import com.web_project.shop.model.StudentModel;

import com.web_project.shop.repository.StudentRepository;
import jakarta.persistence.Id;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InMemoryStudentService implements StudentService{

    private final StudentRepository studentRepository;

    public InMemoryStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentModel> findAllStudents(){
        return studentRepository.findAll(Sort.by("id"));
    }

    @Override
    public StudentModel findStudentById(Long id){
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public StudentModel AddStudent(StudentModel student){
        return studentRepository.save(student);
    }

    @Override
    public StudentModel updateStudent(StudentModel student){
        if (studentRepository.existsById(student.getId())){
            return studentRepository.save(student);
        }else{
            return null;
        }

    }

    @Override
    public void deleteStudent(Long id){
        if (studentRepository.existsById(id)){
            studentRepository.deleteById(id);
        }
    }

}
