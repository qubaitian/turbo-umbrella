package com.qbt.demo.method.file.repo;

import lombok.Data;

@Data
public class Field {
    private String type;
    private String name;

    public Field() {
    }

    public Field(String type, String name) {
        this.type = type;
        this.name = name;
    }

}
