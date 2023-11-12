/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.examreg.service;

import com.example.examreg.data.Exam;
import com.example.examreg.data.ExamRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Naveen Udesh Silva
 */
@Service
public class ExamService {
    @Autowired
    private ExamRepository examRepository;
    public List<Exam> getAllExam(){
        List<Exam> exams = examRepository.findAll();
        return exams;
    }
    public Exam getExamById(Long id){
        Optional<Exam> exa= examRepository.findById(id);
        return exa.get();
    }
    public Exam createExam(Exam exa){
        return examRepository.save(exa);
    }
    public Exam updateExam(Exam exa){
        return examRepository.save(exa);
    }
    public void deleteExamById(Long id){
         examRepository.deleteById(id);
    }
}
