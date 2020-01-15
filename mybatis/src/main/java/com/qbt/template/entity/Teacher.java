package com.qbt.template.entity;

import lombok.Data;

import java.util.List;

@Data
public class Teacher {
    Long id;
    String name;
    List<Student> students;
}
