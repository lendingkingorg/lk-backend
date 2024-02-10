package com.lkbackend.lkbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "on_salary_info_tbl")
public class OnSalaryInfoTbl {

    @Id
    private Long mobileNo;

    // Personal Information
    private String hrName;
    private String hrEmail;
    private Long hrMobile;

}
