package com.lkbackend.lkbackend.Service;

import com.lkbackend.lkbackend.Repo.LendingInfoRepo;
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
}
