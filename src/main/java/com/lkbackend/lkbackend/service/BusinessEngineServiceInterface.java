package com.lkbackend.lkbackend.service;

public interface BusinessEngineServiceInterface {

    public void getPayLoad(Long mobNo);

    Long saveIntoCentralBin(Long mobNo);
    public Long runBusinessEngine(Long mobNo);
}
