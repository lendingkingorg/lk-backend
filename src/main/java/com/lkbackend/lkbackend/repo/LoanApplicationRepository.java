package com.lkbackend.lkbackend.repo;


import com.lkbackend.lkbackend.model.LoanApplicationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface LoanApplicationRepository extends JpaRepository<LoanApplicationDetails,Long> {
    LoanApplicationDetails findByMobileNo(Long mobNo);
}
