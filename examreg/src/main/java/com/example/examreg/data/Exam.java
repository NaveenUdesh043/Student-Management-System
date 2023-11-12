/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.examreg.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Naveen Udesh Silva
 */@Entity

public class Exam {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String examname;
    private String examsubject;
    private String batch;
    private String supervisor;
    private String examhall;
    private String examduration;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExamname() {
        return examname;
    }

    public void setExamname(String examname) {
        this.examname = examname;
    }

    public String getExamsubject() {
        return examsubject;
    }

    public void setExamsubject(String examsubject) {
        this.examsubject = examsubject;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getExamhall() {
        return examhall;
    }

    public void setExamhall(String examhall) {
        this.examhall = examhall;
    }

    public String getExamduration() {
        return examduration;
    }

    public void setExamduration(String examduration) {
        this.examduration = examduration;
    }
   
    
}
