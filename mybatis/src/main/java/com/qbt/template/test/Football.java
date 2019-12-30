package com.qbt.template.test;

public class Football {

    private Long id;
    private Integer dr;

    /*fields*/
    private String name;
    private String code;

    /*members*/

    public Football() {
    }

    public Football(Long id, Integer dr, String name, String code) {
        this.id = id;
        this.dr = dr;
        this.name = name;
        this.code = code;
    }

}
