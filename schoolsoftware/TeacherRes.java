package com.example.schoolsoftware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRes extends JpaRepository<Teacher,Integer>{
    Teacher findTeacherById(String id);
    List<Teacher> findBySalaryGreaterThan(Integer salary);
}
