package com.lkbackend.lkbackend.Repo;

import com.lkbackend.lkbackend.model.DocumentUploadDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface DocumentRepository extends JpaRepository<DocumentUploadDetails,Long> {
    DocumentUploadDetails findByMobileNo(long mobNo);

}
