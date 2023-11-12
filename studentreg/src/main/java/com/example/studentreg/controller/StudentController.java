/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.studentreg.controller;

import com.example.studentreg.data.Student;
import com.example.studentreg.data.StudentRepository;
import com.example.studentreg.exception.UserNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Naveen Udesh Silva
 */
@RestController
@CrossOrigin("http://localhost:3000") 

public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    
    @GetMapping("/students")
    List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    @PostMapping("/students")
    Student newStudent(@RequestBody Student newStudent)
    {
        return studentRepository.save(newStudent);
    }
    
     
    
    
    @GetMapping("/students/{id}")
    Student getStudentById(@PathVariable Long id){
        return studentRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }
    @PutMapping("/students/{id}")
    Student updateStudent(@RequestBody Student newStudent,@PathVariable Long id){
        return studentRepository.findById(id)
                .map(student ->{
                student.setFname(newStudent.getFname());
                student.setLname(newStudent.getLname());
                student.setTelno(newStudent.getTelno());
                student.setEmail(newStudent.getEmail());
                student.setAddress(newStudent.getAddress());
                student.setSchool(newStudent.getSchool());
                student.setGname(newStudent.getGname());
                student.setCourse(newStudent.getCourse());
                return studentRepository.save(student);
                }).orElseThrow(()->new UserNotFoundException(id));
    }
    @DeleteMapping("/students/{id}")
    String deleteStudent(@PathVariable Long id){
        if(!studentRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        studentRepository.deleteById(id);
        return "Student with id "+id+" has been deleted success.";
    }
}


