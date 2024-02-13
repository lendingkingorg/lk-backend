package com.lkbackend.lkbackend.repo;
import com.lkbackend.lkbackend.model.OnSalaryInfoTbl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface OnSalaryInfoRepo extends JpaRepository<OnSalaryInfoTbl,Long> {
}
