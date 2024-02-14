package com.lkbackend.lkbackend.Service;

import com.lkbackend.lkbackend.Repo.LendingInfoRepo;
import com.lkbackend.lkbackend.model.LendingInfo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.parser.Entity;

@Service
public class LendingInfoService {

    private final LendingInfoRepo repo;

    public LendingInfoService(LendingInfoRepo repo){
        this.repo = repo;
    }

    public LendingInfo findByMobileNumber(final long mobile){
        return repo.findById(mobile)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Info not found"));
    }

    public LendingInfo save(LendingInfo lendingInfo){
        return repo.save(lendingInfo);
    }

    public LendingInfo findByReferral(String referral){return repo.findByReferral(referral);}
}
