/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.examreg.controller;

import com.example.examreg.data.Exam;
import com.example.examreg.data.ExamRepository;
import com.example.examreg.exception.UserNotFoundException;
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
@CrossOrigin("http://localhost:3003") 
public class ExamController {
     @Autowired
    private ExamRepository examRepository;
    
    @GetMapping("/exams")
    List<Exam> getAllExams(){
        return examRepository.findAll();
    }
    @PostMapping("/exams")
    Exam newExam(@RequestBody Exam newExam)
    {
        return examRepository.save(newExam);
    }
    
    
    
    @GetMapping("/exams/{id}")
    Exam getExamById(@PathVariable Long id){
        return examRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }
    @PutMapping("/exams/{id}")
    Exam updateExam(@RequestBody Exam newExam,@PathVariable Long id){
        return examRepository.findById(id)
                .map(exam ->{
                exam.setExamname(newExam.getExamname());
                 exam.setExamsubject(newExam.getExamsubject());
                  exam.setBatch(newExam.getBatch());
                   exam.setSupervisor(newExam.getSupervisor());
                    exam.setExamhall(newExam.getExamhall());
                     exam.setExamduration(newExam.getExamduration());
                
                return examRepository.save(exam);
                }).orElseThrow(()->new UserNotFoundException(id));
    }
    @DeleteMapping("/exams/{id}")
    String deleteExam(@PathVariable Long id){
        if(!examRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        examRepository.deleteById(id);
        return "Exam with id "+id+" has been deleted success.";
    }
}
