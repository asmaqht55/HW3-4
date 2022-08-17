package com.example.schoolsoftware;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherSer {
    private final TeacherRes teacherRes;

    public List<Teacher> getteacher() {
        return teacherRes.findAll();
    }

    public void addteacher(Teacher teacher) {
        teacherRes.save(teacher);
    }

    public void updateteacher(Teacher teacher, Integer id) {
        Teacher oldteacher = teacherRes.getById(id);
        oldteacher.setName(teacher.getName());
        oldteacher.setSalary(teacher.getSalary());
        teacherRes.save(teacher);
    }

    public void deleteteacher(Integer id) {
        Teacher teacher = teacherRes.getById(id);
        teacherRes.delete(teacher);
    }

    public Teacher getteacherbyid(String id) {
        Teacher teacher = teacherRes.findTeacherById(id);
        if (teacher == null) {
            throw new ApiException("wrong ID");
        }
        return teacher;
    }

    public List<Teacher> getteachersgreaterthan(Integer salary) {
        return teacherRes.findBySalaryGreaterThan(salary);


    }
}
