/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.lecturerreg.service;

import com.example.lecturerreg.data.Lecturer;
import com.example.lecturerreg.data.LecturerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Naveen Udesh Silva
 */
@Service
public class LecturerService {
     @Autowired
    private LecturerRepository lecturerRepository;
    public List<Lecturer> getAllLecturer(){
        List<Lecturer> lecturers = lecturerRepository.findAll();
        return lecturers;
    }
    public Lecturer getStudentById(Long id){
        Optional<Lecturer> stu= lecturerRepository.findById(id);
        return stu.get();
    }
    public Lecturer createStudent(Lecturer stu){
        return lecturerRepository.save(stu);
    }
    public Lecturer updateStudent(Lecturer stu){
        return lecturerRepository.save(stu);
    }
    public void deleteLecturerById(Long id){
         lecturerRepository.deleteById(id);
    }
}
