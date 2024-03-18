package com.lkbackend.lkbackend.Repo;

import com.lkbackend.lkbackend.model.BLDocumentUploadDetails;
import com.lkbackend.lkbackend.model.PLDocumentUploadDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface PLDocumentRepository extends JpaRepository<PLDocumentUploadDetails,Long> {
    PLDocumentUploadDetails findByMobileNo(long mobNo);
}
