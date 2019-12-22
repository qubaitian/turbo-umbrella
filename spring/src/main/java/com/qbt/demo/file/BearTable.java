package com.qbt.demo.file;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;

@Entity(name = "bear")
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BearTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer dr = 0;
}
