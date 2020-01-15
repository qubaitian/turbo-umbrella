package com.qbt.table;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "payment_contract")/*table*/
@Data
public class PaymentContractTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer dr = 0;

    /*fields*/
    private Long templateId;
    private Long presetContractId;
    private String fieldValues;
    private String creator;
    private Long creatorId;
    private String organization;
    private String organizationId;
    private String createTime;
    private Long discussionGroupId;
    private String filePath;
    private Integer paymentOrReceipt;
    private String contractNo;
    private String contractName;

    /*members*/

}
