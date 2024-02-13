package com.lkbackend.lkbackend.service;

import com.lkbackend.lkbackend.repo.LendingInfoRepo;
import com.lkbackend.lkbackend.model.LendingInfo;
import org.springframework.stereotype.Service;


@Service
public class LendingInfoService {

    private final LendingInfoRepo repo;

    public LendingInfoService(LendingInfoRepo repo){
        this.repo = repo;
    }

    public LendingInfo findByMobileNumber(final long mobile){
        return repo.findByMobileNumber(mobile);
    }

    public LendingInfo save(LendingInfo lendingInfo){
        return repo.save(lendingInfo);
    }

    public LendingInfo findByReferral(String referral){return repo.findByReferral(referral);}
}
