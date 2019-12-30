package com.qbt.template.repository.append;

public class Candy {

    private Long id;
    private Integer dr;

    /*fields*/
    private String name;
    private String code;

    /*members*/

    public Candy() {
    }

    public Candy(Long id, Integer dr, String name, String code) {
        this.id = id;
        this.dr = dr;
        this.name = name;
        this.code = code;
    }
}
