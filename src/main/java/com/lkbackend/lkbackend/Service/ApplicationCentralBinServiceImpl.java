package com.lkbackend.lkbackend.Service;

import com.lkbackend.lkbackend.Repo.ApplicationCentralBinRepo;
import com.lkbackend.lkbackend.model.ApplicationCentralBin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationCentralBinServiceImpl implements ApplicationCentralBinServiceInterface {
@Autowired
    ApplicationCentralBinRepo applicationCentralBinRepo;

    @Override
    public List<ApplicationCentralBin> getApplicationIDByMobileNo(Long mobNo) {
      return   applicationCentralBinRepo.findAllByMobileNo(mobNo);
    }
}
