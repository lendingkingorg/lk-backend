package com.lkbackend.lkbackend.Repo;

import com.lkbackend.lkbackend.model.BLDocumentUploadDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface BLDocumentRepository extends JpaRepository<BLDocumentUploadDetails,Long> {
    BLDocumentUploadDetails findByMobileNo(long mobNo);
}
