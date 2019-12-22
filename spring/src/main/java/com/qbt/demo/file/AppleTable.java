package com.qbt.demo.file;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;

@Entity(name = "apple")
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AppleTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer dr = 0;
}
