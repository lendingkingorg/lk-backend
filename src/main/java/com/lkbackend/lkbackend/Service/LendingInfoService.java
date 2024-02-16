package com.lkbackend.lkbackend.Service;

import com.lkbackend.lkbackend.Repo.LendingInfoRepo;
import com.lkbackend.lkbackend.model.LendingInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;

@Service
@Slf4j
public class LendingInfoService {

    private final LendingInfoRepo repo;

    public LendingInfoService(LendingInfoRepo repo){
        this.repo = repo;
    }

    public LendingInfo findByMobileNumber(final long mobile){
        log.info("Finding lending information for mobile number: {}", mobile);
        return repo.findByMobileNumber(mobile);
    }

    public LendingInfo save(LendingInfo lendingInfo){
        log.info("Saving lending information: {}", lendingInfo);
        return repo.save(lendingInfo);
    }

    public LendingInfo findByReferral(String referral){
        log.info("Finding lending information by referral: {}", referral);
        return repo.findByReferral(referral);}
}
