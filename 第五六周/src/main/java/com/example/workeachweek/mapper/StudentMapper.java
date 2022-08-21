package com.example.workeachweek.mapper;

import com.example.workeachweek.Infomation.Student;
import com.sun.tools.javac.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface StudentMapper {

    List<Student> findAll();
    Student findByName(String userName);
    String findPswByName(String passWord);

    void save(Student user);

}
