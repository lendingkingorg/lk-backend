package com.lkbackend.lkbackend.Service;

import com.lkbackend.lkbackend.Entity.ApplicationCentralBinDTO;

public interface BusinessEngineServiceInterface {

     void getPayLoad(Long mobNo);
     ApplicationCentralBinDTO runBusinessEngine(Long mobNo);
}
