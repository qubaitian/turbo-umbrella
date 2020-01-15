package com.qbt.template.entity;

import lombok.Data;

@Data
public class Blog {
    Long id;
    String name;
    Author author;
}
