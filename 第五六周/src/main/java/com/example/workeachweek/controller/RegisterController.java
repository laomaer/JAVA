package com.example.workeachweek.controller;

import com.example.workeachweek.Infomation.Student;
import com.example.workeachweek.mapper.StudentMapper;
import com.example.workeachweek.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class RegisterController {
    @Autowired
    StudentService studentService;

    @GetMapping("/register")
    public String register(Student student){
        return studentService.register(student);
    }
}
