package com.qbt.demo.method.file.repo;

import lombok.Data;

@Data
public class Member {
    private String type;
    private String name;
    private String objType;

    public Member() {
    }

    public Member(String type, String name, String objType) {
        this.type = type;
        this.name = name;
        this.objType = objType;
    }
}
