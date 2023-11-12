/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.lecturerreg.controller;

import com.example.lecturerreg.data.Lecturer;
import com.example.lecturerreg.data.LecturerRepository;
import com.example.lecturerreg.exception.UserNotFoundException;
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
@CrossOrigin("http://localhost:3001")
public class LecturerController {
    @Autowired LecturerRepository lecturerRepository;
    
    
    @GetMapping("/lecturers")
    List<Lecturer> getAllLecturers(){
        return lecturerRepository.findAll();
    }
    
    @PostMapping("/lecturers")
    Lecturer newLecturer(@RequestBody Lecturer newLecturer){
        return lecturerRepository.save(newLecturer);
    }
    
    @GetMapping("/lecturers/{id}")
    Lecturer getLecturerById(@PathVariable Long id){
        return lecturerRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }
    @PutMapping("/lecturers/{id}")
    Lecturer updateLecturer(@RequestBody Lecturer newLecturer,@PathVariable Long id){
        return lecturerRepository.findById(id)
                .map(Lecturer -> {
                    Lecturer.setLname(newLecturer.getLname());
              Lecturer.setEmail(newLecturer.getEmail());
              Lecturer.setAge(newLecturer.getAge());
              Lecturer.setTelno(newLecturer.getTelno());
              Lecturer.setSubject(newLecturer.getSubject());
              Lecturer.setAddress(newLecturer.getAddress());
              Lecturer.setQualification(newLecturer.getQualification());
              Lecturer.setWexperience(newLecturer.getWexperience());
              return lecturerRepository.save(Lecturer);
    
                }).orElseThrow(()->new UserNotFoundException(id));
               
                }
    @DeleteMapping("/lecturers/{id}")
    String deleteLecturer(@PathVariable Long id){
        if(!lecturerRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        lecturerRepository.deleteById(id);
        return "Lecturer with id "+id+" has been deleted success.";
    }
    
}
