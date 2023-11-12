/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.coursereg.service;

import com.example.coursereg.data.Course;
import com.example.coursereg.data.CourseRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Naveen Udesh Silva
 */
@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    public List<Course> getAllStudent(){
        List<Course> courses = courseRepository.findAll();
        return courses;
    }
    public Course getCourseById(Long id){
        Optional<Course> cur= courseRepository.findById(id);
        return cur.get();
    }
    public Course createStudent(Course cur){
        return courseRepository.save(cur);
    }
    public Course updateCourse(Course cur){
        return courseRepository.save(cur);
    }
    public void deleteCourseById(Long id){
         courseRepository.deleteById(id);
    }

}
