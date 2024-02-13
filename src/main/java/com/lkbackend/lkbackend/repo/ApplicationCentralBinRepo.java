package com.lkbackend.lkbackend.repo;

import com.lkbackend.lkbackend.model.ApplicationCentralBin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@EnableJpaRepositories
public interface ApplicationCentralBinRepo extends JpaRepository<ApplicationCentralBin,Long> {

 List<ApplicationCentralBin> findAllByMobileNo(Long MobileNo);

    //  List<ApplicationCentralBin> findAll() ;

}
