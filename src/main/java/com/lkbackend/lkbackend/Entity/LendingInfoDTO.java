package com.lkbackend.lkbackend.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LendingInfoDTO {
    private int userId;
    private long mobileNumber;
    private String name;
    private String email;
    private String pan;
    private String referral;
    private String lkTnC;
    private String cibilTnC;

}
