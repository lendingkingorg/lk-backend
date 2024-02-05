package com.lkbackend.lkbackend.Service;

public interface BusinessEngineServiceInterface {

    public void getPayLoad(Long mobNo);

    Long saveIntoCentralBin(Long mobNo);
    public Long runBusinessEngine(Long mobNo);
}
