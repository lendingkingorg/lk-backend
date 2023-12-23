package com.lkbackend.lkbackend.Repo;

import com.lkbackend.lkbackend.model.LendingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface LendingInfoRepo extends JpaRepository<LendingInfo, Long> {

    LendingInfo findByMobileNumber(long mobileNumber);
}
