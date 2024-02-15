package com.lkbackend.lkbackend.Service;

public interface BusinessEngineServiceInterface {

    void getPayLoad(Long mobNo);
    Long saveIntoCentralBin(Long mobNo);
    Long runBusinessEngine(Long mobNo);
}
