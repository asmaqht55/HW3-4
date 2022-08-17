package com.example.schoolsoftware;

import net.bytebuddy.asm.Advice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudntRes extends JpaRepository<Student,Integer>{
    Student findStudentById(String id);
    List<Student> findAllByMajor (String major);
    List<Student> findByAgeGreaterThan(Integer age);

    Student findStudentByName(String name);
}
