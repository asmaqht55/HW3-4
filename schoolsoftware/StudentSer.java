package com.example.schoolsoftware;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentSer {
    private final StudntRes studentres;
    public List<Student> getstudent(){
        return studentres.findAll();
    }

    public void addstudent(Student student){
        studentres.save(student);
    }
    public void updetestudent(Student student,Integer id){
        Student updetstudent=studentres.getById(id);
        updetstudent.setName(student.getName());
        updetstudent.setAge(student.getAge());
        updetstudent.setMajor(student.getMajor());
        studentres.save(updetstudent);
    }
    public void deletestudent(Integer id){
        Student myuser=studentres.getById(id);
        studentres.delete(myuser);
    }

    public Student getstudentbyid(String id){
        Student student= studentres.findStudentById(id);
        if(student==null){
            throw new ApiException(("Wrong ID !"));
        }
        return student;
    }
    public Student getstudentbyname(String name){
        Student student=studentres.findStudentByName(name);
        if(student==null){
            throw new ApiException(("Student name invalid !"));
        }
        return student;
    }

    public List<Student> getstudentsbymajor(String major) {
        List<Student> students = studentres.findAllByMajor(major);

        if (students == null) {
            throw new ApiException(("Major invalid !"));
        }
        return students;

    }

    public List<Student> getstudentsgreaterthan(Integer age) {
        return  studentres.findByAgeGreaterThan(age);

    }
}
