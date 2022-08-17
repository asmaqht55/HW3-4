package com.example.schoolsoftware;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("abi/v1/te")
@AllArgsConstructor
public class TeacherCon {
    private final TeacherSer teacherSer;

    @GetMapping
    public ResponseEntity getteachers(){
        List<Teacher> teachers=teacherSer.getteacher();
        return  ResponseEntity.status(201).body(teachers);
    }
    @PostMapping
    public ResponseEntity addteacher(@RequestBody @Valid Teacher teacher){
        teacherSer.addteacher(teacher);
        return  ResponseEntity.status(200).body(new Api("Teacher added !",200));
    }
    @PutMapping("/")
    public ResponseEntity Updateteacher(@RequestBody @Valid Teacher teacher,@PathVariable Integer id){
        teacherSer.updateteacher(teacher,id);
        return  ResponseEntity.status(200).body(new Api("Teacher updated!",200));
    }
    @DeleteMapping("/{index}")
    public ResponseEntity deleteteacher(@PathVariable Integer id){
        teacherSer.deleteteacher(id);
        return  ResponseEntity.status(200).body(new Api("Teacher deleted !",200));
    }
    @GetMapping("/salary")
    public ResponseEntity<List<Teacher>> getteacherbysalary(@PathVariable Integer salary) {
        List<Teacher> teachers = teacherSer.getteachersgreaterthan(salary);
        return ResponseEntity.status(200).body(teachers);
    }
    @GetMapping("/id")
    public ResponseEntity<Teacher> getteacherById(@PathVariable String id){
        Teacher teacher=teacherSer.getteacherbyid(id);
        return  ResponseEntity.status(200).body(teacher);
    }
}
