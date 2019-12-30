package com.qbt.table;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity(name = "formal_contract")/*table*/
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class FormalContractTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer dr = 0;

    /*fields*/
    private Integer tag;
    private String partyA;
    private String partyB;
    private Long organizationId;
    private String contractNumber;
    private String contractName;
    private BigDecimal contractAmount;
    private Integer contractStatus;
    private Long creatorId;
    private Long originalId;

    /*members*/

}
