package com.lkbackend.lkbackend.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class DocumentUploadRequest {

    private String DocumentInfo;
    private String DocumentType;
    private String DocumentFormat;
}
