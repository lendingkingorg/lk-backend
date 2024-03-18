package com.lkbackend.lkbackend.Repo;


import com.lkbackend.lkbackend.model.BLApplicationDetails;
import com.lkbackend.lkbackend.model.PLApplicationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface PLApplicationRepository extends JpaRepository<PLApplicationDetails,Long> {
    PLApplicationDetails findByMobileNo(Long mobNo);
}
