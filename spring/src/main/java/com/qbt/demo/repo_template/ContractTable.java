package com.qbt.demo.repo_template;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;

@Entity(name = "contract")
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ContractTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer dr = 0;
}
