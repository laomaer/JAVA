package com.example.workeachweek.controller;

import com.example.workeachweek.Infomation.Student;
import com.example.workeachweek.mapper.StudentMapper;
import com.example.workeachweek.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public String Login(Student student){
        return studentService.login(student);
    }







}
