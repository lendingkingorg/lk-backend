package com.lkbackend.lkbackend.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "lending_nfo")
public class LendingInfo {

    @Id
    @Column(name = "userId")
    private int userId;

    @Column(name = "mobileNumber")
    private long mobileNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "mPin")
    private int mPin;

    @Column(name = "email")
    private String email;

    @Column(name = "pan")
    private String pan;

    @Column(name = "referral")
    private String referral;

}
