package com.lkbackend.lkbackend.Service;

import com.lkbackend.lkbackend.model.ApplicationCentralBin;

import java.util.List;

public interface ApplicationCentralBinServiceInterface {
    List<ApplicationCentralBin> getApplicationIDByMobileNo(Long mobNo);

    ApplicationCentralBin findFirstByMobileNoOrderByCreatedAtDesc(Long mobNo);
}
