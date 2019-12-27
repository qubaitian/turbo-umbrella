package com.qbt.table;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "dear")/*table*/
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DearTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer dr = 0;

    /*fields*/
    private String name;
    private String code;

    /*members*/
    private Long candy;
    private String candies;

}
