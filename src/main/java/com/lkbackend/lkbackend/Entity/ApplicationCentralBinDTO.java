package com.lkbackend.lkbackend.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ApplicationCentralBinDTO {

    private Long applicationID;

    private double requestedLoanAmount;

    @JsonFormat(pattern="dd-MM-yyyy")
    private Date appliedDate;
}
