package com.lkbackend.lkbackend.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "lending_inf")
public class LendingInfo {

    @Id
    @Column(name = "userId")
    @GeneratedValue
    private int userId;

    private long mobileNumber;

    private String name;

    private int mPin;

    private String email;

    private String pan;

    private String referral;

    private String lk_TnC;

    private String cibil_TnC;

    @OneToOne(mappedBy = "lendingInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private LoanApplicationDetails loanApplicationDetails;

    public int getUserId() {
        return userId;
    }

    public String getLk_TnC() {
        return lk_TnC;
    }

    public void setLk_TnC(String lk_TnC) {
        this.lk_TnC = lk_TnC;
    }

    public String getCibil_TnC() {
        return cibil_TnC;
    }

    public void setCibil_TnC(String cibil_TnC) {
        this.cibil_TnC = cibil_TnC;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getmPin() {
        return mPin;
    }

    public void setmPin(int mPin) {
        this.mPin = mPin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getReferral() {
        return referral;
    }

    public void setReferral(String referral) {
        this.referral = referral;
    }
}
