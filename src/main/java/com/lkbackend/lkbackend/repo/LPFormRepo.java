package com.lkbackend.lkbackend.repo;

import com.lkbackend.lkbackend.model.LPFormTbl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface LPFormRepo extends JpaRepository<LPFormTbl,Long> {
}
