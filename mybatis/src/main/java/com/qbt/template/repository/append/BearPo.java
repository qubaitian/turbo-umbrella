package com.qbt.template.repository.append;

import lombok.Data;

@Data
public class BearPo {

    private Long id;
    private Integer dr;

    /*fields*/
    private String name;
    private String code;

    /*members*/
    private Long candy;
    private String candies;

}
