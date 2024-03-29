package com.lkbackend.lkbackend.Repo;

import com.lkbackend.lkbackend.model.ApplicationCentralBin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@EnableJpaRepositories
public interface ApplicationCentralBinRepo extends JpaRepository<ApplicationCentralBin,Long> {

   ApplicationCentralBin findFirstByMobileNoOrderByCreatedAtDesc(Long mobileNo);
   List<ApplicationCentralBin> findAllByMobileNo(Long mobNo);
   List<ApplicationCentralBin> findAllByOrderByCreatedAtDesc();


}
