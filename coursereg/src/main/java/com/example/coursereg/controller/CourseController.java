/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.coursereg.controller;

import com.example.coursereg.data.Course;
import com.example.coursereg.data.CourseRepository;
import com.example.coursereg.exception.UserNotFoundException;
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
@CrossOrigin("http://localhost:3002") 
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;
    
    @GetMapping("/courses")
    List<Course> getAllStudents(){
        return courseRepository.findAll();
    }
    @PostMapping("/courses")
    Course newStudent(@RequestBody Course newStudent)
    {
        return courseRepository.save(newStudent);
    }
    
    @GetMapping("/courses/{id}")
    Course getStudentById(@PathVariable Long id){
        return courseRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }
    @PutMapping("/courses/{id}")
   Course updatCourse(@RequestBody Course newCourse,@PathVariable Long id){
        return courseRepository.findById(id)
                .map(course ->{
                course.setCname(newCourse.getCname());
                 course.setFee(newCourse.getFee());
                  course.setModules(newCourse.getModules());
                   course.setDuration(newCourse.getDuration());
                return courseRepository.save(course);
                }).orElseThrow(()->new UserNotFoundException(id));
    }
    @DeleteMapping("/courses/{id}")
    String deleteStudent(@PathVariable Long id){
        if(!courseRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        courseRepository.deleteById(id);
        return "Course with id "+id+" has been deleted success.";
    }
}
