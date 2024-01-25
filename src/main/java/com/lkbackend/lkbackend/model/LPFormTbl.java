package com.lkbackend.lkbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "LPForm_tbl")
public class LPFormTbl {

    @Id
    @GeneratedValue
    private Long Id;

    String businessName;
    String email;


}
