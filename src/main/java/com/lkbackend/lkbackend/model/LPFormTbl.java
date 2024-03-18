package com.lkbackend.lkbackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "lp_form_tbl")
@Getter
@Setter
public class LPFormTbl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "business_name")
    private String businessName;
    private String email;
}
