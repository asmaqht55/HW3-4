package com.example.schoolsoftware;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Student {
    @Id
    @NotEmpty(message ="can't be empty")
    private Integer id;
    @NotEmpty(message ="can't be empty")
    private String name;
    @NotEmpty(message ="can't be empty")
    @Column(columnDefinition = "varchar(10) check (major='CS' or major='MATH' or major='Engineer') ")
    private String major;
    @NotEmpty(message ="can't be empty")
    private  Integer age ;
}
