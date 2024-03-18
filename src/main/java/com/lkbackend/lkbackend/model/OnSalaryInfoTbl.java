package com.lkbackend.lkbackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "on_salary_info_tbl")
public class OnSalaryInfoTbl {

    @Id
    @Column(name = "mobile_no")
    private Long mobileNo;

    // Personal Information
    @Column(name = "hr_name")
    private String hrName;
    @Column(name = "hr_email")
    private String hrEmail;
    @Column(name = "hr_mobile")
    private Long hrMobile;

}
