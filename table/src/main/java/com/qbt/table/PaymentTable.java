package com.qbt.table;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity(name = "ebo_payment")/*table*/
@Data
public class PaymentTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer dr = 0;

    /*fields*/
    private String code;
    private String name;
    private String contractNumber;
    private BigDecimal amount;
    private BigDecimal taxAmount;
    private boolean isConfirmed;
    private String contract;
    private String creator;
    private String createTime;
    private String sumRatio;
    private String sum;
    private String notPayAmount;

    /*members*/

}
