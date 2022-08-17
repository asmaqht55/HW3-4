package com.example.schoolsoftware;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

 @RestController
 @RequestMapping("abi/v1/student")
 @RequiredArgsConstructor
 @Repository
  public class StudentCon {
 private final StudentSer studentSer;

     @PostMapping
     public ResponseEntity Addstudents(@RequestBody @Valid Student student){
         studentSer.addstudent(student);
         return  ResponseEntity.status(200).body(new Api("Student added !",200));
     }

     @PutMapping("/{index}")
     public ResponseEntity Updatestudent(@RequestBody @Valid Student student,@PathVariable Integer id){
         studentSer.updetestudent(student, id);
         return  ResponseEntity.status(200).body(new Api("Student updated !",200));
     }

     @DeleteMapping("/{index}")
     public ResponseEntity deleteuser(@PathVariable Integer id){
         studentSer.deletestudent(id);
         return  ResponseEntity.status(200).body(new Api("Student deleted !",200));
     }


 @GetMapping
    public ResponseEntity getstudent(){
    List<Student> students=studentSer.getstudent();
    return ResponseEntity.status(201).body(students);
}
 @PostMapping("/id")
    public ResponseEntity<Student> getstudentByid(@PathVariable String id){
     Student student=studentSer.getstudentbyid(id);
     return ResponseEntity.status(201).body(student);
}
     @GetMapping("/name")
     public ResponseEntity<Student> getsstudentByname(@PathVariable String name){
         Student student=studentSer.getstudentbyname(name);
         return  ResponseEntity.status(200).body(student);
     }

     @GetMapping("/age")
     public ResponseEntity<List<Student>> getstudentByAge(@PathVariable Integer age) {
         List<Student> students = studentSer.getstudentsgreaterthan(age);
         return ResponseEntity.status(200).body(students);
     }
     @GetMapping("/major")
     public ResponseEntity<List<Student>> getstudentByMajor(@PathVariable String major) {
         List<Student> students = studentSer.getstudentsbymajor(major);
         return ResponseEntity.status(200).body(students);
     }
}
