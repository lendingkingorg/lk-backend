package com.lkbackend.lkbackend.Service;

public interface BusinessEngineServiceInterface {

    public void getPayLoad(Long mobNo);

    Boolean saveIntoCentralBin(Long mobNo);
    public void runBusinessEngine(Long mobNo);
}
