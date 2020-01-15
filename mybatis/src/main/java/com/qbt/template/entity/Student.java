package com.qbt.template.entity;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    Long id;
    String name;
    Long teacherId;
    List<Teacher> teachers;
}
