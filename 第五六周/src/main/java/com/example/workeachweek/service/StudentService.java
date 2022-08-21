package com.example.workeachweek.service;

import com.example.workeachweek.Infomation.Student;
import com.example.workeachweek.mapper.StudentMapper;
import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentService {
    @Autowired
    StudentMapper studentMapper;

    // 登录操作
    public String login(Student student) {
        try {
            Student studentExistN = studentMapper.findByName(student.getUserName());
            if (studentExistN!= null) {
                String userExistP = studentMapper.findPswByName(student.getPassWord());
                if (userExistP.equals(student.getPassWord())) {
                    return student.getUserName()+"登录成功，欢迎您！";
                }else{
                    return "登录失败，密码错误！";
                }
            }else {
                return "登录失败，用户不存在!";
            }
        }catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    // 注册操作
    public String register(Student user) {
        try {
            Student userExist = studentMapper.findByName(user.getUserName());
            if (user.getUserName().equals("")) {
                return "用户名不能为空";
            }else if (user.getPassWord().equals("")) {
                return "密码不能为空";
            }else if (userExist != null) {
                return "账号已经存在";
            }else {
                studentMapper.save(user);
                return "注册成功";
            }
        }catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    // 获取所有用户
    public List<Student> findAll() {
        List<Student> list = studentMapper.findAll();
        return list;
    }

}
