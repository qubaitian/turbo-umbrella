package com.qbt.table;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity(name = "receipt")/*table*/
@Data
public class ReceiptTable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Integer dr = 0;

  /*fields*/
  private String code;
  private String name;
  private String recipient;
  private String contractNumber;
  private BigDecimal amount;
  private BigDecimal taxAmount;
  private Boolean isConfirmed;
  private String contract;
  private String creator;
  private String sumRatio;
  private String sum;
  private String notPayAmount;
  private Long bankReceiptId;
  private String createTime;
  private String receiveTime;
  /*members*/

}
