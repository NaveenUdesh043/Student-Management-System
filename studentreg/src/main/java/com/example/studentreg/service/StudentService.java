/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.studentreg.service;

import com.example.studentreg.data.Student;
import com.example.studentreg.data.StudentRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Naveen Udesh Silva
 */
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public List<Student> getAllStudent(){
        List<Student> students = studentRepository.findAll();
        return students;
    }
    public Student getStudentById(Long id){
        Optional<Student> stu= studentRepository.findById(id);
        return stu.get();
    }
    public Student createStudent(Student stu){
        return studentRepository.save(stu);
    }
    public Student updateStudent(Student stu){
        return studentRepository.save(stu);
    }
    public void deleteStudentById(Long id){
         studentRepository.deleteById(id);
    }

}
    

