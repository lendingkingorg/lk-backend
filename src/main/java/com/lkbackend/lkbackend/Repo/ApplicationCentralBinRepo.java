package com.lkbackend.lkbackend.Repo;

import com.lkbackend.lkbackend.model.ApplicationCentralBin;
import com.lkbackend.lkbackend.model.DocumentUploadDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationCentralBinRepo extends JpaRepository<ApplicationCentralBin,Long> {



}
