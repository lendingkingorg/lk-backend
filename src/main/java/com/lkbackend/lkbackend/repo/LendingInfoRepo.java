package com.lkbackend.lkbackend.repo;

import com.lkbackend.lkbackend.model.LendingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface LendingInfoRepo extends JpaRepository<LendingInfo, Long> {

    LendingInfo findByMobileNumber(long mobileNumber);

    LendingInfo findByReferral(String referral);
}
