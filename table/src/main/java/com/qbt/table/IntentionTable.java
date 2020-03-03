package com.qbt.table;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "ebo_intention")/*table*/
@Data
public class IntentionTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer dr = 0;

    /*fields*/
    private String intentionCode;
    private Long organizationId;
    private Long creatorId;
    private Long discussionGroupId;
    private String subject;
    private Integer intentionDr;

    /*members*/

}
