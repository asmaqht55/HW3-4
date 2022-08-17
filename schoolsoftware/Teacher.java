package com.example.schoolsoftware;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Teacher {
    @Id
    @NotEmpty(message ="Can't be empty!")
    private Integer id;
    @NotEmpty(message = "Can't be empty!")
    private String name;
    @NotEmpty(message ="Can't be empty!")
    private Integer salary;
}
