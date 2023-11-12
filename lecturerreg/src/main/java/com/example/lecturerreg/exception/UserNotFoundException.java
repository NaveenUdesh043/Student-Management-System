/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.lecturerreg.exception;

/**
 *
 * @author Naveen Udesh Silva
 */
public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id){
        super("Could not found the Lecturer with id "+ id);
    }
    
}
