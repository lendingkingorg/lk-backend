package com.lkbackend.lkbackend.Repo;


import com.lkbackend.lkbackend.model.BLApplicationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface BLApplicationRepository extends JpaRepository<BLApplicationDetails,Long> {
    BLApplicationDetails findByMobileNo(Long mobNo);
}
