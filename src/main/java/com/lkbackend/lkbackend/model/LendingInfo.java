package com.lkbackend.lkbackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "lending_inf")
@Getter
@Setter
public class LendingInfo {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(name = "mobile_number")
    private long mobileNumber;
    private String name;
    @Column(name = "mpin")
    private int mPin;
    private String email;
    private String pan;
    private String referral;

    @Column(name = "lk_tnc")
    private String lkTnC;

    @Column(name = "cibil_tnc")
    private String cibilTnC;
}
