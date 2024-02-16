package com.lkbackend.lkbackend.controller;

import com.lkbackend.lkbackend.Repo.ApplicationCentralBinRepo;
import com.lkbackend.lkbackend.model.ApplicationCentralBin;
import com.lkbackend.lkbackend.Service.BusinessEngineServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/")
@Slf4j
public class BusinessEngineController {

    @Autowired
    BusinessEngineServiceInterface businessEngineServiceInterface;

    @Autowired
    ApplicationCentralBinRepo applicationCentralBinRepo;

    @PostMapping("business-engine-api/{mobNo}")
    public ResponseEntity<?> sendDocToLenders(@PathVariable Long mobNo) {
        log.info("Send Doc To Lenders Started.");
        try {
            Long sol = businessEngineServiceInterface.runBusinessEngine(mobNo);
            if (sol == null) {
                log.info("No data found for mobNo: {}", mobNo);
                return new ResponseEntity<>("NO_DATA_FOUND", HttpStatus.OK);
            }

            HashMap<String, Object> jsonResponse = new HashMap<>();
            jsonResponse.put("ApplicationID", sol);
            log.info("Send Doc To Lenders Successful for mobNo: {}", mobNo);
            return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
        } catch (Exception errorMessage) {
            log.error("Error while Sending Doc To Lenders for mobNo: {}", mobNo, errorMessage);
            return new ResponseEntity<>(errorMessage.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("get-application-id/{mobNo}")
    public ResponseEntity<?> getApplicationID(@PathVariable Long mobNo) {
        try {
            List<ApplicationCentralBin> allUser = applicationCentralBinRepo.findAllByMobileNo(mobNo);

            ApplicationCentralBin finalElement = null;
            for (ApplicationCentralBin x : allUser) {
                if (Objects.equals(mobNo, x.getMobileNo())) {
                    finalElement = x;
                }
            }

            if (finalElement != null) {
                HashMap<String, Object> jsonResponse = new HashMap<>();
                jsonResponse.put("ApplicationID", finalElement.getApplicationID());
                jsonResponse.put("created_at", finalElement.getCreatedAt());
                log.info("Application ID retrieved successfully for mobNo: {}", mobNo);
                return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
            } else {
                log.info("No data found for mobNo: {}", mobNo);
                return new ResponseEntity<>("NO_DATA_FOUND", HttpStatus.OK);
            }
        } catch (Exception errorMessage) {
            log.error("Error while retrieving Application ID for mobNo: {}", mobNo, errorMessage);
            return new ResponseEntity<>("SORRY_SOMETHING_WENT_WRONG", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
